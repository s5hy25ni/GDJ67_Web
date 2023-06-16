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
	private List<TeamStadiumDTO> tsDTO;
	private List<PlayerDTO> pDTO;
	private List<HistoryDTO> hDTO;
	private List<ScheduleDTO> sDTO;
	private List<ResultDTO> rDTO;
	
	
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
}
