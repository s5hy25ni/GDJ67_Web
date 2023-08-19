package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.UserDto;

public class UserImpl implements IUser {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.UserImpl.";
	private SqlSessionFactory manager;
	
	public UserImpl() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
	@Override
	public UserDto login(Map<String, Object> map) {
		logger.info("login : "+map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"login", map);
	}
	
	@Override
	public List<UserDto> allUser(Map<String, Object> map) {
		logger.info("allUser");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"allUser",map);
	}
	
	@Override
	public int getMyUser() {
		logger.info("getMyUser");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getMyUser");
	}

}
