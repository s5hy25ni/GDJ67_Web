package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.IJobIUDDao;
import com.min.edu.model.JobIUDDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobVo;

public class JUnitTest_IUD {

	private SqlSession session;
	private IJobIUDDao dao;
	
	@Before
	public void createSalSession() {
		dao = new JobIUDDaoImpl();
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		session = manager.openSession();
		assertNotNull(manager);
	}
	
//	@Test
	public void insert01() {
		JobVo vo = new JobVo("IT", "Programmer", 1000, 3000);
		int n = dao.insert01(vo);
		assertEquals(n, 1);
	}
//		@Test
	public void delete01() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id","IT");
		int n = dao.delete01(map);
		assertEquals(n, 2);
	}
	
	@Test
	public void update01() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("job_title","Developer");
		map.put("job_id","IT_PROG");
		assertTrue(dao.update01(map));
	}

}
