package com.min.edu.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.CalendarDto;

public class CalboardDaoImpl implements ICalboardDao {
	
	private Logger logger = LoggerFactory.getLogger(CalboardDaoImpl.class);
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.CalboardDaoImpl.";

	@Override
	public List<CalendarDto> getCalViewList(Map<String, Object> map) {
		logger.info("각 달 일별 리스트(3개씩) : {}",map);
		SqlSession session = manager.openSession();
		
		return session.selectList(NS+"getCalViewList",map);
	}

	@Override
	public int insertCalBoard(CalendarDto dto) {
		logger.info("일정 추가 : {}", dto);
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertCalBoard",dto);
	}

	@Override
	public List<CalendarDto> getCalList(Map<String, Object> map) {
		logger.info("일별 게시글 조회 : {}", map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getCalList", map);
	}

	@Override
	public int getCalCount(Map<String, Object> map) {
		logger.info("일정 개수 : {}", map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getCalCount",map);
	}

	@Override
	public CalendarDto getCalDetail(Map<String, Object> map) {
		logger.info("게시글 상세 : {}",map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getCalDetail",map);
	}

	@Override
	public boolean multiDel(String[] seq) {
		logger.info("게시글 삭제 : {}", Arrays.toString(seq));
		int cnt = 0;
		SqlSession session = manager.openSession(false);
		try {
			for (String s : seq) {
				cnt += session.delete(NS+"multiDel",s);
			}
			session.commit();
			session.close();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return cnt>0?true:false;
	}

}
