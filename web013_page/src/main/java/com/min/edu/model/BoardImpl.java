package com.min.edu.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.BoardDto2;
import com.min.edu.dto.FileDto;
import com.min.edu.dto.ReplyDto;

public class BoardImpl implements IBoard {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.BoardImpl.";
	private SqlSessionFactory manager;
	
	public BoardImpl() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
	@Override
	public List<BoardDto2> getAllBoard() {
		logger.info("게시글 목록 조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllBoard");
	}

	@Override
	public boolean insertBoard(BoardDto2 dto2,List<FileDto> fList) {
		logger.info("게시글 작성");
		SqlSession session = manager.openSession();
		int cnt = 0;
		try {
			cnt += session.insert(NS+"insertBoard",dto2);
			for (FileDto fileDto : fList) {
				fileDto.setBSeq(dto2.getBSeq());
				fileDto.setBWriter(dto2.getBWriter());
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("fDtos", fList);
			cnt += session.insert(NS+"insertFile", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt>0?true:false;
	}

	@Override
	public BoardDto2 getOneBoard(Map<String, Object> map) {
		logger.info("게시글 상세 조회");
		SqlSession session = manager.openSession();
		BoardDto2 bDto2 =  session.selectOne(NS+"getOneBoard", map);
		System.out.println(bDto2);
		return bDto2;
	}
	
	@Override
	public boolean insertReply(ReplyDto rDto) {
		logger.info("답글 입력");
		SqlSession session = manager.openSession(true);
		int n = session.insert(NS+"insertReply",rDto);
		return n>0?true:false;
	}
	
	@Override
	public int getRCnt(String seq) {
		logger.info("답글 갯수");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getRCnt",seq);
	}
}
