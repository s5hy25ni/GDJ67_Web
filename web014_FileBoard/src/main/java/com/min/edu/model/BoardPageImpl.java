package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.BoardDto;

public class BoardPageImpl implements IBoardPage {

	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.BoardPageImpl.";
	private SqlSessionFactory manager;
	
	public BoardPageImpl() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
	@Override
	public List<BoardDto> pageList(Map<String, Object> map) {
		logger.info("pageList 페이지 리스트 범위 : "+map.get("first") + "~" + map.get("last"));
		SqlSession session = manager.openSession();
		
		return session.selectList(NS+"pageList", map);
	}
	
	@Override
	public int countMyBoard() {
		logger.info("countMyBoard 총 글 개수 조회");
		SqlSession session = manager.openSession();
		
		return session.selectOne(NS+"countMyBoard");
	}
	
}
