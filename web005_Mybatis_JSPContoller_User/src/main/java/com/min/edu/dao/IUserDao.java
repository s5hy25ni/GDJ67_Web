package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.UserDto;

/**
 * MemberInfo 테이블을 활용한 사용자 기능 웹 애플리케이션
 * @author SH
 * @since 2023.06.30
 */
public interface IUserDao {
	
	/**
	 * USER0001 전체 사용자 조회
	 * @return 사용자 전체 리스트
	 */
	public List<UserDto> getAllUserStatus();
	
	/**
	 * USER0002 전체 사용자 조회
	 * @return 사용자 전체 리스트(ENABLE='Y')
	 */
	public List<UserDto> getAllUser();
	
	/**
	 * USER0003 권한 수정
	 * @param Map 권한(ADMIN, USER)
	 * @return 성공한 row의 갯수
	 */
	public int updateAuthUser(Map<String, Object> inMap);
	
	/**
	 * USER0004 일반 사용자 입력
	 * @param DTO 사용자 정보 입력
	 * @return 성공한 row의 갯수
	 */
	public int insertUser(UserDto inDto);
	
	/**
	 * USER0005 사용자 로그인 정보
	 * @param Map ID, PASSWORD
	 * @return 사용자 정보
	 */
	public UserDto getLogin(Map<String, Object> inMap);
	
	/**
	 * USER0006 사용자 상세 정보 조회
	 * @param seq pk값
	 * @return 사용자 상세 정보
	 */
	public UserDto getUserInfo(String seq);
	
	/**
	 * USER0007 사용자 정보 수정
	 * @param Map ADDRESS, PHONE, EMAIL, SEQ
	 * @return 성공한 row의 갯수
	 */
	public int updateUserInfo(Map<String, Object> inMap);
	
	/**
	 * USER0008 사용자 정보 삭제(UPDATE)
	 * @param seq pk값
	 * @return 성공한 row의 갯수
	 */
	public int delUser(String seq);
	
	/**
	 * USER0009 ID 중복 검사
	 * @param id 사용가능여부 판단 ID 입력
	 * @return 1사용불가 0사용가능
	 */
	public int duplicateId(String id);
	
}
