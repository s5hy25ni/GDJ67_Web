package com.min.edu.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.Info_DTO;
import com.min.edu.mybatis.SqlDaoSupport;

/**
 * info 테이블의 기능을 구현한 클래스
 */
public class InfoSelectKeyImpl implements IInfoSelectKey {

	private Logger logger = Logger.getLogger(InfoSelectKeyImpl.class);
	private final String NS = "com.min.edu.model.InfoSelectKeyImpl.";
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	
	// insertInfo와 selectOneInfo를 service에서 하나로 묶기 위해 dto로 받음
	
	@Override
	public int insertInfo(Info_DTO dto) {
		logger.info("insertInfo 전달 받은 입력 값 getSeq() : "+dto.getSeq());
		SqlSession session = manager.openSession(true);
		int n =session.insert(NS+"insertInfo", dto);
		logger.info("insertInfo 입력 후 생성된 getSeq() : "+dto.getSeq());
		return n;
	}
	
	@Override
	public Info_DTO selectOneInfo(Info_DTO dto) {
		logger.info("insertInfo에서 전달 받은 getSeq() : "+dto.getSeq());
		SqlSession session = manager.openSession();
		Info_DTO resultDto = session.selectOne(NS+"selectOneInfo", dto);
		return resultDto;
	}
}
