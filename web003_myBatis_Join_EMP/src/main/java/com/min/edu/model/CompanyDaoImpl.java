package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.Dept_DTO;
import com.min.edu.dto.Dept_DTO5;
import com.min.edu.manager.SqlSessionFactoryManager;

public class CompanyDaoImpl implements ICompanyDao {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS2 = "com.min.edu.join02.";
	private final String NS3 = "com.min.edu.join03.";
	private final String NS5 = "com.min.edu.join05.";
	
	@Override
	public List<Dept_DTO> joinCombine02() {
		logger.info("하나의 객체에 소속된 DTO 조인");
		SqlSession session = manager.openSession();
		List<Dept_DTO> lists = session.selectList(NS2+"joinCombine02");
		return lists;
	}
	
	@Override
	public List<Dept_DTO> joinCombine03() {
		logger.info("하나의 객체에 소속된 DTO 조인");
		SqlSession session = manager.openSession();
		List<Dept_DTO> lists = session.selectList(NS3+"joinCombine03");
		return lists;
	}
	
	@Override
	public List<Dept_DTO5> joinCombine05() {
		logger.info("Dept에 소속된 Emp의 리스트로 조인");
		SqlSession session = manager.openSession();
		List<Dept_DTO5> lists = session.selectList(NS5+"joinCombine05");
		return lists;
	}
}
