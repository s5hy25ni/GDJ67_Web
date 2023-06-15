package com.test.mybatis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.Job_DTO;
import com.min.edu.model.DynamicDaoImpl;
import com.min.edu.model.IDynamicDao;

public class Dynamic_JUnitTest {

	private IDynamicDao dao = new DynamicDaoImpl();
	
	@Test
	public void test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("job_id","IT_PROG");
		List<Job_DTO> lists = dao.getJobIf(map);
		assertNotNull(lists);
	}

}
