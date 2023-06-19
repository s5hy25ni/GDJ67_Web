package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Team_DTO;
import com.min.edu.manager.SqlSessionFactoryManager;
import com.min.edu.model.ISoccerDao;
import com.min.edu.model.SoccerDaoImpl;

public class MyBatis_Join_JUnitTest {

	private ISoccerDao dao = new SoccerDaoImpl();
//	@Before
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	
//	@Test
	public void joinCombine01() {
		List<All_Dto> lists = dao.joinCombine01();
		assertNotNull(lists);
	}
	
//	@Test
	public void joinCombine02() {
		List<Team_DTO> lists = dao.joinCombine02();
		assertNotNull(lists);
	}
	
	@Test
	public void joinCombine03() {
		List<Team_DTO> lists = dao.joinCombine03();
		assertNotNull(lists);
	}

}
