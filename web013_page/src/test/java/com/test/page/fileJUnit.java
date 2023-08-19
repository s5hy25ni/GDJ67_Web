package com.test.page;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.min.edu.dto.BoardDto2;
import com.min.edu.dto.FileDto;
import com.min.edu.dto.ReplyDto;
import com.min.edu.model.BoardImpl;
import com.min.edu.model.IBoard;

public class fileJUnit {

	@Test
	public void test() {
		IBoard dao = new BoardImpl();
//		BoardDto2 dto2 = new BoardDto2();
		
		//전제 글 조회
//		List<BoardDto2> lists = dao.getAllBoard();
//		assertNotNull(lists);
		
		//ROOT글 작성
//		dto2.setTitle("멋쟁이 토마토");
//		dto2.setBWriter("토마토");
//		dto2.setBContent("멋쟁이 토맛토마토");
//		
//		List<FileDto> fList = new ArrayList<FileDto>();
//		for (int i = 0; i < 3; i++) {
//			fList.add(new FileDto(null, "멋쟁이토마토"+i, "멋쟁이토맛토마토"+i, i));
//		}
//		
//		boolean isc = dao.insertBoard(dto2, fList);
//		assertTrue(isc);
		
//		BoardDto2 dto3 = dao.getOneBoard("1");
//		assertNotNull(dto3);
		
		// 답글 입력
		ReplyDto rDto = new ReplyDto(1, "답글", "답글작성합니다.");
		boolean isc = dao.insertReply(rDto);
		assertTrue(isc);
		
	}

}
