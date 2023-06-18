package com.sh.crud.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sh.crud.dto.HistoryDTO;
import com.sh.crud.dto.PlayerDTO;
import com.sh.crud.dto.ResultDTO;
import com.sh.crud.dto.ScheduleDTO;
import com.sh.crud.dto.TeamStadiumDTO;
import com.sh.crud.mybatis.SqlDaoSupport;

public class KLeagueDaoImpl implements IKLeagueDao {
	private final String NS = "com.sh.crud.model.KLeagueImpl.";
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	private SqlSession session = manager.openSession();
	private SqlSession sessionIUD = manager.openSession(true);
	private List<TeamStadiumDTO> tsDTO;
	private List<PlayerDTO> pDTO;
	private List<HistoryDTO> hDTO;
	private List<ScheduleDTO> sDTO;
	private List<ResultDTO> rDTO;
	private int result;
	
	
	@Override
	public List<TeamStadiumDTO> getStadiumInfo() {
		tsDTO = session.selectList(NS+"stadium_sel");
		return tsDTO;
	}
	
	@Override
	public List<TeamStadiumDTO> getTeamInfo() {
		tsDTO = session.selectList(NS+"team_sel");
		return tsDTO;
	}
	
	@Override
	public List<PlayerDTO> getPlayerInfo() {
		pDTO = session.selectList(NS+"player_sel");
		return pDTO;
	}
	
	@Override
	public List<HistoryDTO> getHistory() {
		hDTO = session.selectList(NS+"player_his_sel");
		return hDTO;
	}
	
	@Override
	public List<ScheduleDTO> getScheduleInfo() {
		sDTO = session.selectList(NS+"sche_sel");
		return sDTO;
	}

	@Override
	public List<PlayerDTO> userSearchPlayer() {
		pDTO = session.selectList(NS+"user_p_summary");
		return pDTO;
	}
	
	@Override
	public List<PlayerDTO> userSearchPlayer(Map<String, Object> map) {
		pDTO = session.selectList(NS+"user_p_summary", map);
		return pDTO;
	}

	@Override
	public List<PlayerDTO> userSearchPlayerDetail(String playerId) {
		pDTO = session.selectList(NS+"user_p_detail", playerId);
		return pDTO;
	}
	
	@Override
	public List<TeamStadiumDTO> userSearchTeam(Map<String, Object> map) {
		tsDTO = session.selectList(NS+"user_t_detail", map);
		return tsDTO;
	}
	
	@Override
	public List<ScheduleDTO> userSearchSchedule() {
		sDTO = session.selectList(NS+"user_s_detail");
		return sDTO;
	}
	
	@Override
	public List<ScheduleDTO> userSearchSchedule(Map<String, Object> map) {
		sDTO = session.selectList(NS+"user_s_detail", map);
		return sDTO;
	}
	
	@Override
	public List<ResultDTO> userSearchRank() {
		rDTO = session.selectList(NS+"user_rank");
		return rDTO;
	}
	
	@Override
	public int insertStadium(TeamStadiumDTO dto) {
		result = sessionIUD.insert(NS+"stadium_in",dto);
		return result;
	}
	
	@Override
	public int insertTeam(TeamStadiumDTO dto) {
		result = sessionIUD.insert(NS+"team_in",dto);
		return result;
	}
	
	@Override
	public int insertPlayer(PlayerDTO dto) {
		result = sessionIUD.insert(NS+"player_in",dto);
		return result;
	}
	
	@Override
	public int insertSchedule(ScheduleDTO dto) {
		result = sessionIUD.insert(NS+"sche_in",dto);
		return result;
	}
	
	@Override
	public boolean updateStadiumTeam(Map<String, Object> map) {
		result = sessionIUD.update(NS+"stadium_team_up", map);
		return result>0?true:false;
	}
	
	@Override
	public boolean updateStadium(Map<String, Object> map) {
		result = sessionIUD.update(NS+"stadium_up", map);
		return result>0?true:false;
	}
	
	@Override
	public boolean updateTeamStadium(Map<String, Object> map) {
		result = sessionIUD.update(NS+"team_stadium_up", map);
		return result>0?true:false;
	}
	
	@Override
	public boolean updateTeam(Map<String, Object> map) {
		result = sessionIUD.update(NS+"team_up", map);
		return result>0?true:false;
	}
	
	@Override
	public boolean updatePlayerTeam(Map<String, Object> map) {
		result = sessionIUD.update(NS+"player_team_up", map);
		return result>0?true:false;
	}
	
	@Override
	public boolean updatePlayer(Map<String, Object> map) {
		result = sessionIUD.update(NS+"player_up", map);
		return result>0?true:false;
	}
	
	@Override
	public boolean updateSchedule(Map<String, Object> map) {
		result = sessionIUD.update(NS+"sche_up", map);
		return result>0?true:false;
	}
	
	@Override
	public boolean deletePlayer(String playerId) {
		result = sessionIUD.delete(NS+"player_del", playerId);
		return result>0?true:false;
	}
	
	@Override
	public boolean deleteTeam(String teamId) {
		result = sessionIUD.delete(NS+"team_del", teamId);
		return result>0?true:false;
	}
	
	@Override
	public boolean deleteStadium(String stadiumId) {
		result = sessionIUD.delete(NS+"stadium_del", stadiumId);
		return result>0?true:false;
	}
}
