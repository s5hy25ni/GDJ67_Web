package com.test.mybatis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.Job_DTO;
import com.min.edu.model.BindingDaoImpl;
import com.min.edu.model.IBindingDao;

public class Binding_JUnitTest {

	private IBindingDao dao = new BindingDaoImpl();
	
//	@Test
	public void binding01() {
		Map<String, Object> map = new HashMap<String, Object>();
		// #으로 처리 되었기 때문에 값이 전달되지 않는다.
//		map.put("column", "JOB_ID");
//		map.put("value", "IT_PROG");
		
		// $로 처리 하는 방식은 값이 아닌 Name으로 처리가 됨 -> property에 이렇게 작성
		// SQL Injection 공격에 취약
		map.put("column", "'a'='a' or JOB_ID");
		map.put("value", "IT_PROG");
		List<Job_DTO> lists =	dao.binding01(map);
		assertNotNull(lists);
	}
	
	@Test
	public void binding02() {
		Map<String, Object> map = new HashMap<String, Object>();
		// #, $ 테스트 값
//		map.put("val","I");
		
		// 직접 %문장 생성
		map.put("val", "I%");
		
		List<Job_DTO> lists =	dao.binding02(map);
		assertNotNull(lists); // 어치피 list라 notNull은 필요가 없다
	}

}
