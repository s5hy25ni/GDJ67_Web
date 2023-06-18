package com.sh.crud.model;


import java.util.List;
import java.util.Map;

import com.sh.crud.dto.HistoryDTO;
import com.sh.crud.dto.PlayerDTO;
import com.sh.crud.dto.ResultDTO;
import com.sh.crud.dto.ScheduleDTO;
import com.sh.crud.dto.TeamStadiumDTO;

public interface IKLeagueDao {
	
	// 전체조회
	public List<TeamStadiumDTO> getStadiumInfo();
	public List<TeamStadiumDTO> getTeamInfo();
	public List<PlayerDTO> getPlayerInfo();
	public List<HistoryDTO> getHistory();
	public List<ScheduleDTO> getScheduleInfo();
	
	// 조건조회_사용자
	public List<PlayerDTO> userSearchPlayer();
	public List<PlayerDTO> userSearchPlayer(Map<String, Object> map);
	public List<PlayerDTO> userSearchPlayerDetail(String playerId);
	public List<TeamStadiumDTO> userSearchTeam(Map<String, Object> map);
	public List<ScheduleDTO> userSearchSchedule();
	public List<ScheduleDTO> userSearchSchedule(Map<String, Object> map);
	public List<ResultDTO> userSearchRank();
	
	// insert
	public int insertStadium(TeamStadiumDTO dto);
	public int insertTeam(TeamStadiumDTO dto);
	public int insertPlayer(PlayerDTO dto);
	public int insertSchedule(ScheduleDTO dto);
	
	// update
	public boolean updateStadiumTeam(Map<String, Object> map);
	public boolean updateStadium(Map<String, Object> map);
	public boolean updateTeamStadium(Map<String, Object> map);
	public boolean updateTeam(Map<String, Object> map);
	public boolean updatePlayerTeam(Map<String, Object> map);
	public boolean updatePlayer(Map<String, Object> map);
	public boolean updateSchedule(Map<String, Object> map);
	
	// delete
	public boolean deletePlayer(String playerId);
	public boolean deleteTeam(String teamId);
	public boolean deleteStadium(String stadiumId);
}
