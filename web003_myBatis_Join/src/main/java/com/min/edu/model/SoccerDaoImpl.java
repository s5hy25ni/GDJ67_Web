package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Team_DTO;
import com.min.edu.manager.SqlSessionFactoryManager;

public class SoccerDaoImpl implements ISoccerDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS1 = "com.min.edu.join01.";
	private final String NS2 = "com.min.edu.join02.";
	private final String NS3 = "com.min.edu.join03.";
	private final String NS4 = "com.min.edu.join04.";
	private final String NS5 = "com.min.edu.join05.";
	
	//TODO 01-02 Dao
	@Override
	public List<All_Dto> joinCombine01() {
		logger.info("하나의 단일 DTO 조인 매핑");
		SqlSession session = manager.openSession();
		List<All_Dto> lists = session.selectList(NS1+"joinCombine01");
		return lists;
	}

	//TODO 02-02 Dao
	@Override
	public List<Team_DTO> joinCombine02() {
		logger.info("하나의 객체에 소속된 DTO 조인");
		SqlSession session = manager.openSession();
		List<Team_DTO> lists = session.selectList(NS2+"joinCombine02");
		return lists;
	}
	
	//TODO 03-02 Dao
	@Override
	public List<Team_DTO> joinCombine03() {
		logger.info("하나의 객체에 소속된 DTO 조인");
		SqlSession session = manager.openSession();
		List<Team_DTO> lists = session.selectList(NS3+"joinCombine03");
		return lists;
	}
}
