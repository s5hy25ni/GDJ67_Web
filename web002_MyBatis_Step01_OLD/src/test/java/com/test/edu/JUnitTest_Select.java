package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.IJobSelectDao;
import com.min.edu.model.JobSelectDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobVo;

public class JUnitTest_Select {

	SqlSession session;
	private IJobSelectDao dao = new JobSelectDaoImpl();

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

//	@Test
	public void selectAllJob() {
		List<JobVo> lists = session.selectList("com.min.edu.job.selectAllJob");
		System.out.println(lists);
		assertNotNull(lists);
	}

//	@Test
	public void select01() {
		String id = "AD_PRES";
		Integer MaxSalary = dao.select01(id);
		assertTrue(true);
	}

//	@Test
	public void select02() {
		String id = "AD_PRES";
		JobVo one = dao.select02(id);
		assertNotNull(one);
		String id2 = "AD";
		JobVo one2 = dao.select02(id2);
		assertNull(one2);
	}

//	@Test
	public void select03() {
		String id = "113";
		JobVo one = dao.select03(id);
		assertNotNull(one);
	}
	
//	@Test
	public void select04() {
		Map<String, JobVo> jobs = dao.select04();
		assertNotNull(jobs);
	}
	
//	@Test
	public void select05() {
		JobVo vo = new JobVo();
		vo.setJob_id("AD_PRES");
		vo.setJob_title("President");
		List<JobVo> lists = dao.select05(vo);
		assertEquals(lists.size(), 1);
	}
	
//	@Test
	public void select06() {
		Map<String, Object> inMap = new HashMap<String, Object>();
		inMap.put("pid", "2012001");
		JobVo vo = dao.select06(inMap);
		String 축구선수정보 = vo.getJob_id();
		String 팀아이디 = vo.getJob_title();
		System.out.println(축구선수정보);
		System.out.println(팀아이디);
		assertNotNull(vo);
		
	}
	
	@Test
	public void select07() {
		Object obj = 3000;
		List<JobVo> lists = dao.select07(obj);
		System.out.println(lists.size());
		assertNotNull(lists);
		
	}
}
