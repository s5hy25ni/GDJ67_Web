package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.db.SqlSessionFactoryManager;
import com.min.edu.dto.BoardDto;
import com.min.edu.dto.FileBoardDto;

public class BoardFileImpl implements IBoardFile {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactroy();
	private final String NS = "com.min.edu.model.BoardFileImpl.";
	
	@Override
	public List<BoardDto> getAllList() {
		logger.info("전체 조회(파일 갯수 포함)");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllList");
	}

	@Override
	public boolean insertBoard(BoardDto bDto, FileBoardDto fDto) {
		logger.info("새 글 작성 및 파일 업로드");
		SqlSession session = manager.openSession(false);
		
		int cnt = 0;
		
		try {
			cnt += session.insert(NS + "insertBoard", bDto);
			fDto.setB_seq(bDto.getSeq());
			cnt += session.insert(NS + "insertFile", fDto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt>0?true:false;
	}

	@Override
	public FileBoardDto getFile(String seq) {
		logger.info("파일 가져오기(다운로드)");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getFile",seq);
	}

	@Override
	public List<BoardDto> getBoard(String seq) {
		logger.info("게시글 상세+파일");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getBoard", seq);
	}
	
	
}
