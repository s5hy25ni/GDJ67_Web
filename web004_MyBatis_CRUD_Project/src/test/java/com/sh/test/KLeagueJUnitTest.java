package com.sh.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.sh.crud.dto.HistoryDTO;
import com.sh.crud.dto.PlayerDTO;
import com.sh.crud.dto.ResultDTO;
import com.sh.crud.dto.ScheduleDTO;
import com.sh.crud.dto.TeamStadiumDTO;
import com.sh.crud.model.IKLeagueDao;
import com.sh.crud.model.KLeagueDaoImpl;

public class KLeagueJUnitTest {

	private IKLeagueDao dao = new KLeagueDaoImpl();
	
//	@Test
	public void stadium_in() {
		TeamStadiumDTO dto1 = new TeamStadiumDTO("E01", "한화이글스파크", 15000, "대전광역시 동구");
		TeamStadiumDTO dto2 = new TeamStadiumDTO("E02", "잠실", 15000, "서울특별시");
		int result1 = dao.insertStadium(dto1);
		int result2 = dao.insertStadium(dto2);
		assertEquals(1, result1);
		assertEquals(1, result2);
		
	}
	
//	@Test
	public void team_in() {
		TeamStadiumDTO dto1 = new TeamStadiumDTO("K99", "대전", "한화이글스", "1989", "E01");
		TeamStadiumDTO dto2 = new TeamStadiumDTO("K88", "잠실", "두산베어스", "E02");
		int result1 = dao.insertTeam(dto1);
		int result2 = dao.insertTeam(dto2);
		assertEquals(1, result1);
		assertEquals(1, result2);
	}
	
//	@Test
	public void player_in() {
		PlayerDTO dto = new PlayerDTO("0", "문동주", "K99", "DF", 1);
		int result = dao.insertPlayer(dto);
		assertEquals(1, result);
	}
	
//	@Test
	public void sche_in() {
		ScheduleDTO dto = new ScheduleDTO("E01", "20121231", "K99", "K88");
		int result = dao.insertSchedule(dto);
		assertEquals(1, result);
	}
	
//	@Test
	public void stadium_team_up() {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("teamId", "K99");
		map1.put("stadiumId", "E01");
		boolean result1 = dao.updateStadiumTeam(map1);
		assertEquals(true, result1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("teamId", "K88");
		map2.put("stadiumId", "E02");
		boolean result2 = dao.updateStadiumTeam(map2);
		assertEquals(true, result2);
	}
	
//	@Test
	public void stadium_up() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zipCode1", "123");
		map.put("zipCode2", "");
		map.put("ddd", "789");
		map.put("tel", "101-1121");
		map.put("fax", "314-1516");
		map.put("stadiumId", "E01");
		boolean result = dao.updateStadium(map);
		assertEquals(true, result);
	}
	
//	@Test
	public void team_stadium_up() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stadiumId", "E01");
		map.put("teamId", "K99");
		boolean result = dao.updateTeamStadium(map);
		assertEquals(true, result);
	}
	
//	@Test
	public void team_up() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("homepage", "https://www.hanwhaeagles.co.kr");
		map.put("teamId", "K99");
		boolean result = dao.updateTeam(map);
		assertEquals(true, result);
	}
	
//	@Test
	public void player_team_up() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teamId", "K88");
		map.put("playerId", "2023001");
		boolean result = dao.updatePlayerTeam(map);
		assertEquals(true, result);
	}
	
//	@Test
	public void player_up() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ePlayerName", "MUN, DONGJU");
		map.put("backNo", "1");
		map.put("nation", "대한민국");
		map.put("birthDate", "");
		map.put("height", "");
		map.put("weight", "");
		map.put("playerId", "2023001");
		boolean result = dao.updatePlayer(map);
		assertEquals(true, result);
	}
	
//	@Test
	public void sche_up() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gubun", "Y");
		map.put("homeScore", 3);
		map.put("awayScore", 1);
		map.put("stadiumId", "E01");
		map.put("scheDate", "20121231");
		boolean result = dao.updateSchedule(map);
		assertEquals(true, result);
	}

//	@Test
	public void stadium_sel() {
		List<TeamStadiumDTO> lists = dao.getStadiumInfo();
		assertNotNull(lists);
		System.out.println(lists);
	}

//	@Test
	public void team_sel() {
		List<TeamStadiumDTO> lists = dao.getTeamInfo();
		assertNotNull(lists);
		System.out.println(lists);
	}
	
//	@Test
	public void player_sel() {
		List<PlayerDTO> lists = dao.getPlayerInfo();
		assertNotNull(lists);
		System.out.println(lists);
	}
	
//	@Test
	public void player_his_sel() {
		List<HistoryDTO> lists = dao.getHistory();
		assertNotNull(lists);
		System.out.println(lists);
	}
	
//	@Test
	public void sche_sel() {
		List<ScheduleDTO> lists = dao.getScheduleInfo();
		assertNotNull(lists);
		System.out.println(lists);
	}
	
//	@Test
	public void user_p_summary() {
		List<PlayerDTO> lists = dao.userSearchPlayer();
		
		Map<String, Object> mapTeam = new HashMap<String, Object>();
		mapTeam.put("teamId","K99");
		List<PlayerDTO> lists1 = dao.userSearchPlayer(mapTeam);
		assertNotNull(lists1);
		System.out.println(lists1);
		
		Map<String, Object> mapPosition = new HashMap<String, Object>();
		mapPosition.put("position","DF");
		List<PlayerDTO> lists2 = dao.userSearchPlayer(mapPosition);
		assertNotNull(lists2);
		System.out.println(lists2);
		
		Map<String, Object> mapSearchName = new HashMap<String, Object>();
		mapSearchName.put("playerName","동주");
		mapSearchName.put("backNo","동주");
		List<PlayerDTO> lists3 = dao.userSearchPlayer(mapSearchName);
		assertNotNull(lists3);
		System.out.println(lists3);
		
		Map<String, Object> mapSearchBackNo = new HashMap<String, Object>();
		mapSearchBackNo.put("playerName","1");
		mapSearchBackNo.put("backNo","1");
		List<PlayerDTO> lists4 = dao.userSearchPlayer(mapSearchBackNo);
		assertNotNull(lists4);
		System.out.println(lists4);
	}
	
//	@Test
	public void user_p_detail() {
		List<PlayerDTO> lists = dao.userSearchPlayerDetail("2023001");
		assertNotNull(lists);
		System.out.println(lists);
	}
	
//	@Test
	public void user_t_detail() {
		Map<String, Object> mapTeam = new HashMap<String, Object>();
		mapTeam.put("teamName","한화");
		mapTeam.put("stadiumName","한화");
		List<TeamStadiumDTO> team = dao.userSearchTeam(mapTeam);
		assertNotNull(team);
		System.out.println(team);
		
		Map<String, Object> mapSta = new HashMap<String, Object>();
		mapSta.put("teamName","포항");
		mapSta.put("stadiumName","포항");
		List<TeamStadiumDTO> sta = dao.userSearchTeam(mapSta);
		assertNotNull(sta);
		System.out.println(sta);
	}
	
//	@Test
	public void user_s_detail() {
		List<ScheduleDTO> total = dao.userSearchSchedule();
		assertNotNull(total);
		System.out.println(total);
		
		Map<String, Object> mapDate = new HashMap<String, Object>();
		mapDate.put("scheDate","20120904");
		List<ScheduleDTO> date = dao.userSearchSchedule(mapDate);
		assertNotNull(date);
		System.out.println(date);
		
		Map<String, Object> mapTeam = new HashMap<String, Object>();
		mapTeam.put("hometeamName","서울");
		mapTeam.put("awayteamName","서울");
		List<ScheduleDTO> team = dao.userSearchSchedule(mapTeam);
		assertNotNull(team);
		System.out.println(team);
	}

//	@Test
	public void user_rank() {
		List<ResultDTO> lists = dao.userSearchRank();
		assertNotNull(lists);
		System.out.println(lists);
	}
	

//	@Test
	public void player_del() {
		boolean result = dao.deletePlayer("2023053");
		assertEquals(true, result);
	}
	
//	@Test
	public void team_del() {
		boolean result1 = dao.deleteTeam("K99");
		boolean result2 = dao.deleteTeam("K88");
		assertEquals(true, result1);
		assertEquals(true, result2);
	}
	
//	@Test
	public void stadium_del() {
		boolean result1 = dao.deleteStadium("E01");
		boolean result2 = dao.deleteStadium("E02");
		assertEquals(true, result1);
		assertEquals(true, result2);
	}
}
