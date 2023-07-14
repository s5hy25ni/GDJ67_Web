package com.min.edu.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.AnswerboardDto;

public class AnswerboardImpl implements IAnswerboardDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.AnswerboardImpl.";
	private SqlSessionFactory manager;
	
	public AnswerboardImpl() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
	@Override
	public List<AnswerboardDto> selectAllBoard() {
		logger.info("selectAllBoard 전체검색");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"selectAllBoard");
	}

	@Override
	public AnswerboardDto selectDetailBoard(String seq) {
		logger.info("selectDetailBoard 상세조회");
		SqlSession session = manager.openSession();
		return (AnswerboardDto)session.selectList(NS+"selectDetailBoard",seq).get(0);
	}

	@Override
	public boolean reply(AnswerboardDto dto) {
		logger.info("reply 답글작성 : 부모의 seq"+dto.getSeq()+" / "+dto);
		SqlSession session = manager.openSession();
		int replyUp = session.update(NS+"replyUpdate",dto);
		int replyIn = session.insert(NS+"replyInsert",dto);
		logger.info("답글결과 : "+replyUp + "/"+replyIn);
		session.commit();
		return replyUp+replyIn>0?true:false;
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		logger.info("modifyBoard 글수정 : "+map);
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"modifyBoard", map);
		return row>0?true:false;
	}

	@Override
	public boolean deleteBoard(String[] seq) {
		logger.info("deleteBoard 글 삭제 : "+Arrays.toString(seq));
		SqlSession session = manager.openSession();
		int cnt = 0;
		for(int i=0; i<seq.length; i++) {
			// 중간에 다른 사람이 완전삭제했을 경우 값이 달라질 수 있음
			cnt += session.update(NS+"deleteBoard", seq[i]);
		}
		session.commit();
		return cnt==seq.length;
	}

	@Override
	public boolean insertBoard(AnswerboardDto dto) {
		logger.info("insertBoard root글 작성 : "+dto);
		SqlSession session = manager.openSession(true);
		int row = session.insert(NS+"insertBoard", dto);
		return row>0?true:false;
	}

	@Override
	public boolean deleteBoardReal(String seq) {
		logger.info("deleteBoardReal DB글삭제 : "+seq);
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteBoardReal",seq);
		return row>0?true:false;
	}

	@Override
	public int multiDelete2(Map<String, String[]> map) {
		logger.info("multiDelete2 다중삭제 : "+map);
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"multiDelete2",map);
		return row;
	}
	
}
