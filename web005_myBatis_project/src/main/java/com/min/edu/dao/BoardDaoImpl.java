package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.ctrl.GetOneBoard;
import com.min.edu.dto.BoardDto;
import com.min.edu.support.SqlSessionFactoryManager;

public class BoardDaoImpl implements IBoardDao {
	SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	String NS = "com.min.edu.dao.BoardDaoImpl.";
	private Logger logger = Logger.getLogger(GetOneBoard.class);

	@Override
	public List<BoardDto> getAllBoard() {
		SqlSession session = manager.openSession();
		List<BoardDto> lists = session.selectList(NS+"getAllBoard");
		return lists; 
	}

	@Override
	public BoardDto getOneBoard(String seq) {
		SqlSession session = manager.openSession();
		BoardDto dto = session.selectOne(NS+"getOneBoard", seq);
		return dto;
	}

	@Override
	public boolean setInsertBoard(BoardDto inDto) {
		SqlSession session = manager.openSession();
		int result = session.insert(NS+"setInsertBoard", inDto);
		session.commit();
		return result>0?true:false;
	}

	@Override
	public boolean setUpdateBoard(Map<String, Object> inMap) {
		SqlSession session = manager.openSession();
		int result = session.update(NS+"setUpdateBoard", inMap);
		session.commit();
		return result>0?true:false;
	}

	@Override
	public boolean setDeleteBoard(String seq) {
		SqlSession session = manager.openSession();
		int result = session.update(NS+"setDeleteBoard", seq);
		session.commit();
		return result>0?true:false;
	}

}
