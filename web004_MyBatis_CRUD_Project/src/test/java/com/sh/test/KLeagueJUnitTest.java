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

	private SqlSession session;
	private IKLeagueDao dao = new KLeagueDaoImpl();
	
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
//		List<PlayerDTO> lists = dao.userSearchPlayer();
		
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
	
	@Test
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

	
}
