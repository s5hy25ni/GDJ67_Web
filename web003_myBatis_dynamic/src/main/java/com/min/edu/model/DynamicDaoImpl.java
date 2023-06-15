package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.Job_DTO;
import com.min.edu.mybatis.SqlDaoSupport;

public class DynamicDaoImpl implements IDynamicDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.DynamicDaoImpl.";
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	
	@Override
	public List<Job_DTO> getJobIf(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		List<Job_DTO> lists = session.selectList(NS+"getJobIf", map);
		return lists;
	}
}
