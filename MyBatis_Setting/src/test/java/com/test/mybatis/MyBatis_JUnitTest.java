package com.test.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.Job_Dto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class MyBatis_JUnitTest {

	private SqlSessionFactory manager;
	
	@Before
	public void createSqlSesstionFactory() {
		manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	
	@Test
	public void selectAllJob() {
		SqlSession session = manager.openSession();
		List<Job_Dto> lists = session.selectList("com.min.edu.model.jobDaoImpl.selectAllJob");
		assertNotNull(lists);
		
	}

}
