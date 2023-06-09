package com.min.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobVo;

public class JUnitTest {
	
	SqlSession session;

//	@Test
	public void JobVo() {
		JobVo vo = new JobVo();
		vo.setJob_id("바붕");
		vo.getJob_id();
		System.out.println(vo);
		assertNotNull(vo);
	}
	
	@Before
	public void SqlSessionFactory() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		session = manager.openSession();
		
		assertNotNull(manager);
	}

	@Test
	public void selectAllJob() {
		List<JobVo> lists = session.selectList("com.min.edu.job.selectAllJob");
		System.out.println(lists);
		assertNotNull(lists);
	}
}
