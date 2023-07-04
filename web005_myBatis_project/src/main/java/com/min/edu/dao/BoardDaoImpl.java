package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.BoardDto;
import com.min.edu.support.SqlSessionFactoryManager;

public class BoardDaoImpl implements IBoardDao {
	SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	SqlSession session = manager.openSession();
	String NS = "com.min.edu.dao.BoardDaoImpl.";

	@Override
	public List<BoardDto> getAllBoard() {
		List<BoardDto> lists = session.selectList(NS+"getAllBoard");
		return lists; 
	}

	@Override
	public BoardDto getOneBoard(String seq) {
		BoardDto dto = session.selectOne(NS+"getOneBoard", seq);
		
		return dto;
	}

	@Override
	public boolean setInsertBoard(BoardDto inDto) {
		int result = session.insert(NS+"setInsertBoard", inDto);
		session.commit();
		return result>0?true:false;
	}

	@Override
	public boolean setUpdateBoard(Map<String, Object> inMap) {
		int result = session.update(NS+"setUpdateBoard", inMap);
		session.commit();
		return result>0?true:false;
	}

	@Override
	public boolean setDeleteBoard(String seq) {
		int result = session.update(NS+"setDeleteBoard", seq);
		session.commit();
		return result>0?true:false;
	}

}
