package com.min.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.db.SqlSessionFactoryManager;
import com.min.edu.dto.BoardDto;
import com.min.edu.dto.FileBoardDto;
import com.min.edu.model.BoardFileImpl;
import com.min.edu.model.IBoardFile;

public class FileBoardJUnit {

	@Test
	public void test() {
//		SqlSessionFactory manager = SqlSessionFactoryManager.getFactroy();
//		SqlSession session = manager.openSession();
//		assertNotNull("sql생성",session);
		
		IBoardFile dao = new BoardFileImpl();
//		List<BoardDto> lists = dao.getAllList();
//		assertNotNull(lists);
		
//		BoardDto bDto = new BoardDto();
//		bDto.setId("koko");
//		bDto.setTitle("글 작성 및 파일 업로드");
//		bDto.setContent("파일 업로드 기능 적용 중");
//		
//		FileBoardDto fDto = new FileBoardDto();
//		fDto.setWriter("koko");
//		fDto.setOrigin_fname("보노보노.png");
//		fDto.setStored_fname("sadfiosjdlfkjs");
//		fDto.setFile_size(123);
//		
//		boolean isc = dao.insertBoard(bDto, fDto);
//		assertTrue(isc);
		
//		FileBoardDto dto = dao.getFile("308");
//		assertNotNull(dto);
		
		List<BoardDto> lists = dao.getBoard("308");
		System.out.println(lists.size());
		for(FileBoardDto fDto : lists.get(0).getFiledto()) {
			System.out.println("파일명 : "+fDto.getOrigin_fname());
		}
		assertNotNull(lists);
		
	}

}
