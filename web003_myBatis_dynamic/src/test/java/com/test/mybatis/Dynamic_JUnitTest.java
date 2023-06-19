package com.test.mybatis;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.Job_DTO;
import com.min.edu.model.DynamicDaoImpl;
import com.min.edu.model.IDynamicDao;

public class Dynamic_JUnitTest {

	private IDynamicDao dao = new DynamicDaoImpl();
	
//	@Test
	public void getJobIf() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("job_id","IT_PROG");
		List<Job_DTO> lists = dao.getJobIf(map);
		assertNotNull(lists);
	}
	
//	@Test
	public void getJobForeach() {
		String[] chks = {"IT_PROG", "AD_PRES"}; // 화면에서 요청받아 java로 처리하는 객체
//		List<String> list = Arrays.asList(chks);
//		List<Job_DTO> lists = dao.getJobList(list);
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("ids", chks);
		List<Job_DTO> lists = dao.getJobMap(map);
		assertNotNull(lists);
		
	}
	
//	@Test
	public void getJobChoose() {
		Job_DTO dto = new Job_DTO();
//		dto.setJobId("IT_PROG");
		dto.setJobTitle("Developer");
		
		List<Job_DTO> lists = dao.getJobChoose(dto);
		assertNotNull(lists);
	}
	
//	@Test
	public void getJobTrim() {
		Job_DTO dto = new Job_DTO();
		dto.setJobId("IT_PROG");
		dto.setJobTitle("Developer");
		
		List<Job_DTO> lists = dao.getJobTrim(dto);
		assertNotNull(lists);
	}
	
//	@Test
	public void updateJobSet() {
		Job_DTO dto = new Job_DTO();
//		dto.setJobId("IT");
		dto.setJobTitle("Programmer");
		
		boolean isc = dao.updateJobSet(dto);
		assertTrue(isc);
	}

//	@Test
	public void updateJobTrim() {
		Job_DTO dto = new Job_DTO();
		dto.setJobTitle("Prog");
		dto.setMinSalary("101");
		int n = dao.updateJobTrim(dto);
		assertEquals(1, n);
	}
}
