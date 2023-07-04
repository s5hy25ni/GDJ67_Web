package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.support.SqlSessionFactoryManager;


public class UserDaoImpl implements IUserDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS="com.min.edu.dao.UserDaoImpl.";
	
	@Override
	public List<UserDto> getAllUserStatus() {
		logger.info("getAllUserStatus 실행");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllUserStatus");
	}

	@Override
	public List<UserDto> getAllUser() {
		logger.info("getAllUser 실행");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllUser");
	}

	@Override
	public int updateAuthUser(Map<String, Object> inMap) {
		logger.info("updateAuthUser 실행 : " + inMap);
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateAuthUser", inMap);
	}

	@Override
	public int insertUser(UserDto inDto) {
		logger.info("insertUser 실행 : " + inDto);
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertUser", inDto);
	}

	@Override
	public UserDto getLogin(Map<String, Object> inMap) {
		logger.info("getLogin 실행 : " + inMap);
		SqlSession session = manager.openSession();
		List<UserDto> loginDto = session.selectList(NS+"getLogin",inMap);
		return loginDto.size()==1?loginDto.get(0):null;
	}

	@Override
	public UserDto getUserInfo(String seq) {
		logger.info("getUserInfo 실행 : " + seq);
		SqlSession session = manager.openSession();
		List<UserDto> userInfo = session.selectList(NS+"getUserInfo", seq);
		return userInfo.size()==1?userInfo.get(0):null;
	}

	@Override
	public int updateUserInfo(Map<String, Object> inMap) {
		logger.info("updateUserInfo 실행 : " + inMap);
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateUserInfo", inMap);
	}

	@Override
	public int delUser(String seq) {
		logger.info("delUser 실행 : " + seq);
		SqlSession session = manager.openSession(true);
		return session.delete(NS+"delUser", seq);
	}

	@Override
	public int duplicateId(String id) {
		logger.info("duplicateId 실행 : " + id);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"duplicateId", id);
	}

}
