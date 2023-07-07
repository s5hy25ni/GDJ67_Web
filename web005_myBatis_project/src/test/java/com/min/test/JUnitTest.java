package com.min.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dao.BoardDaoImpl;
import com.min.edu.dao.IBoardDao;
import com.min.edu.dto.BoardDto;
import com.min.edu.support.SqlSessionFactoryManager;

public class JUnitTest {

	IBoardDao dao;
	
	@Before
	public void test() {
		dao = new BoardDaoImpl();
	}
	
	@Test
	public void testDao() {
//		List<BoardDto> lists = dao.getAllBoard();
//		assertNotNull(lists);
//		
//		String seq = "3";
//		BoardDto dto = dao.getOneBoard(seq);
//		assertNotNull(dto);
		
//		BoardDto dto = new BoardDto("깡깡", "배고파욥", "저녁메뉴뭐할까");
//		boolean isc = dao.setInsertBoard(dto);
//		assertEquals(isc, true);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "갈비갈비갈비갈비ㅣㅣㅣ");
		map.put("seq", "3");
		boolean isc = dao.setUpdateBoard(map);
		assertEquals(isc, true);
		
//		String seq2 = "3";
//		boolean isc = dao.setDeleteBoard(seq2);
//		assertEquals(isc, true);
	}

}
