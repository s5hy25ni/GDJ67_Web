package com.test.answerboard;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.comm.DatePatternBean;
import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.AnswerboardDto;
import com.min.edu.model.AnswerboardImpl;
import com.min.edu.model.IAnswerboardDao;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class Answerboard_JUnitTest {

	@Test
	public void beanTest() {
//		DatePatternBean bean = new DatePatternBean();
//		String result = bean.datePattern("2023-07-10 16:28:00");		
//		System.out.println(result);
	}
	
//	@Test
	public void daoTest() {
		IAnswerboardDao dao = new AnswerboardImpl();
		
//		String seq = "10";
//		dao.selectDetailBoard(seq);
		
		//ID, TITLE, CONTENT
//		AnswerboardDto dto = new AnswerboardDto();
//		dto.setId("TEST_ID");
//		dto.setTitle("TEST_TITLE");
//		dto.setContent("TEST_CONTENT");
//		dao.insertBoard(dto);
		
//		AnswerboardDto dto = new AnswerboardDto();
//		dto.setSeq(25);
//		dto.setId("Reply2_ID");
//		dto.setTitle("Reply2_TITLE");
//		dto.setContent("Reply2_CONTENT");
//		dao.reply(dto);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("seq", "25");
//		map.put("content", "수정된 내용");
//		dao.modifyBoard(map);
//		dao.selectDetailBoard("25");
		
//		dao.deleteBoard(seq);
		
//		dao.deleteBoardReal("26");
		
//		String[] seq = {"27"};
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("seqs", seq);
//		int result = dao.multiDelete2(map);
//		dao.selectAllBoard();
//		System.out.println(result);
		
		IUserDao uDao = new UserDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "user");
		map.put("pw", "1234");
		uDao.loginSelect(map);
		assertTrue(true);
	}
	
	
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}

}
