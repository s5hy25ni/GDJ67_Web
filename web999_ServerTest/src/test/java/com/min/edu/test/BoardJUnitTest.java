package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.model.BoardPageImpl;
import com.min.edu.model.IBoardPage;
import com.min.edu.vo.FileVo;
import com.min.edu.vo.ReplyVo;
import com.min.edu.vo.RootVo;

public class BoardJUnitTest {

	@Test
	public void test() {
		IBoardPage dao = new BoardPageImpl();
		
		// 상세보기
//		List<RootVo> rtVo = dao.getDetail("1");
//		assertNotNull(rtVo);
//		System.out.println(rtVo);
		
		// 댓글보기
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("ref", "1");
//		map.put("start", "4");
//		map.put("end", "6");
//		
//		List<ReplyVo> rpVo = dao.getReply(map);
//		assertNotNull(rpVo);
//		System.out.println(rpVo);
		
		// 새글 작성
		RootVo rtVo = new RootVo("TEST", "TEST TITLE 03", "TEST CONTENT 03");
		FileVo fVo = new FileVo("TEST NAME 02", "afdasfasdfse", 5);
		boolean isc = dao.insertRoot(rtVo, fVo);
		assertTrue(isc);
	}

}
