package com.test.schedule;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.bean.DatePattern;
import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.CalendarDto;
import com.min.edu.model.CalboardDaoImpl;
import com.min.edu.model.ICalboardDao;
import com.min.edu.util.CalendarUtil;

public class ScheduleBoardTest {

//	@Test
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	
//	@Test
	public void testDaoInsert() {
		ICalboardDao dao = new CalboardDaoImpl();
		CalendarDto dto = new CalendarDto("RABIT", "JUnit TEST", "JUnit TEST 진행", "202307251111");
		int n =dao.insertCalBoard(dto);
		assertEquals(1, n);
	}
	
//	@Test
	public void testDao() {
		ICalboardDao dao = new CalboardDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id","RABIT");
		map.put("yyyymmdd", "20230725");
//		List<CalendarDto> lists = dao.getCalViewList(map);
//		List<CalendarDto> lists = dao.getCalList(map);
//		assertNotNull(lists);
		
//		int n = dao.getCalCount(map);
//		assertEquals(4, n);
		
		map.put("seq", "3");
//		CalendarDto dto = dao.getCalDetail(map);
//		assertNotNull(dto);
		
		String[] seqs = {"3", "4"};
		boolean isc = dao.multiDel(seqs);
		assertTrue(isc);
	}
	
//	@Test
	public void utilTest() {
		
		System.out.println(CalendarUtil.iTwoWord(11));
	}
	
	@Test
	public void datePatternTest() {
		DatePattern dp = new DatePattern();
		dp.setToDate("202307281200");
		String convert = dp.getToDate();
		System.out.println(convert);
		assertNotNull(convert);
	}

}
