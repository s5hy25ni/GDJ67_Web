package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.UserVo;

public class UserDaoImpl implements IUserDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.UserDaoImpl.";
	private SqlSessionFactory manager;
	
	public UserDaoImpl() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
	@Override
	public UserVo loginSelect(Map<String, Object> map) {
		logger.info("loginSelect 회원로그인 : "+map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"loginSelect", map);
	}

}
