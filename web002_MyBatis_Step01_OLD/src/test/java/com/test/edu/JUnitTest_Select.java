package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobVo;

public class JUnitTest_Select {

	SqlSession session;
	
//	@Test
	public void lombok() {
		JobVo vo = new JobVo();
		vo.setJob_id("비온다");
		vo.getJob_id();
		System.out.println(vo);
		assertNotNull(vo);
	}

	@Before
	public void createSalSession() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		session = manager.openSession(); // openSession() 기본은 auto-commit이 false
//		SqlSession session = manager.openSession(true); // insert 등 할 때에는 true
		
		assertNotNull(manager);
	}
	
	@Test
	public void selectAllJob() {
		List<JobVo> lists = session.selectList("com.min.edu.job.selectAllJob");
		System.out.println(lists);
		assertNotNull(lists);
	}
}
