package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Player_DTO4;
import com.min.edu.dto.Team_DTO;
import com.min.edu.dto.Team_DTO5;

public interface ISoccerDao {
	
	//TODO 01-00 이전의 단일 테이블 처리 방식
	/*
	 * 하나의 DTO에 두 개의 테이블 컬럼과 매핑된 getter/setter를 모두 작성하여 매핑
	 * 하나의 객체에 너무 많은 컬럼의 갯수가 많은 경우 복잡도 및 객체의 메모리가 증가
	 */
	public List<All_Dto> joinCombine01();
	
	//TODO 02-00 각 테이블의 객체를 만들고, 부모의 객체에 자식 객체를 멤버 필드로 만들어 사용
	/*
	 * 복잡도가 감소하고, 1:1인 테이블
	 * 각 객체를 단일로 사용할 수 있음
	 */
	public List<Team_DTO> joinCombine02();
	
	//TODO 03-00 myBatis의 Collection 문법을 사용하여 1:1 처리
	/*
	 * 코드이 가독성이 좋아짐
	 */
	public List<Team_DTO> joinCombine03();
	
	//TODO 04-00 myBatis의 Collection 문법을 사용하여 1:1 처리 player -> team
	/*
	 * team(부모테이블)에 소속되지 않고 player에 소속 
	 */
	public List<Player_DTO4> joinCombine04();
	
	//TODO 05-00 joinCombine03과 같이 team(15)이 기준으로 player(483) 호출 => 각 팀에 List(row)로 만듦
	/*
	 * 		1:n의 관계를 가진 테이블의 결과를 조인
	 * 		출력시 하나의 팀에 여러 선수가 포함되어 있는 1:n 관계의 객체를 생성할 수 있다.
	 * 
	 * 		{
	 * 			"K01" : [
	 * 						{"PLAYER_NAME" : "고길동", "POSITION" : "FW" , ...},
	 * 						{"PLAYER_NAME" : "또치", "POSITION" : "MF" , ...},
	 * 						{"PLAYER_NAME" : "둘리", "POSITION" : "FW" , ...},
	 *						... 							
	 * 					]
	 * 		}
	 * 
	 * 		Map<String, List<Player_DTO>> soccer = new HashMap<String, List<Player_DTO>>();
	 * 		List<Player_DTO> lists = new ArrayList<Player_DTO>();
	 * 		Player_DTO pDto1 = new Player_DTO("홍길동", "FW");
	 * 		Player_DTO pDto2 = new Player_DTO("또치", "MF");
	 * 		Player_DTO pDto3 = new Player_DTO("둘리", "FW");
	 * 		lists.add(pDto1);
	 * 		lists.add(pDto2);
	 * 		lists.add(pDto3);
	 * 		soccer.put("K01", lists);
	 */
	public List<Team_DTO5> joinCombine05();
}
