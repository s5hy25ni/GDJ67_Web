package com.test.page;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.BoardDto;

public class listTest {

	@Test
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", 1);
		map.put("last", 10);
		
		List<BoardDto> lists = session.selectList("com.min.edu.model.BoardPageImpl.pageList", map);
		assertNotNull(lists);
		
		int cnt = session.selectOne("com.min.edu.model.BoardPageImpl.countMyBoard");
		System.out.println(cnt);
	}

}
