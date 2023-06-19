package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Team_DTO;

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
}
