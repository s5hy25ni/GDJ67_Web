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
	
	@Override
	public List<Job_DTO> getJobList(List<String> list) {
		logger.info("전달받은 요청 값: " + list);
		SqlSession session = manager.openSession();
		List<Job_DTO> lists = session.selectList(NS+"getJobList", list);
		return lists;
	}
	
	@Override
	public List<Job_DTO> getJobMap(Map<String, String[]> map) {
		logger.info("전달받은 요청 값: " + map);
		SqlSession session = manager.openSession();
		List<Job_DTO> lists = session.selectList(NS+"getJobMap", map);
		return lists;
	}
	
	@Override
	public List<Job_DTO> getJobChoose(Job_DTO dto) {
		logger.info("전달받은 요청 값 (id) : " + dto.getJobId());
		logger.info("전달받은 요청 값 (title) : " + dto.getJobTitle());
		SqlSession session = manager.openSession();
		List<Job_DTO> lists = session.selectList(NS+"getJobChoose", dto);
		return lists;
	}
	
	@Override
	public List<Job_DTO> getJobTrim(Job_DTO dto) {
		logger.info("전달받은 요청 값 (id) : " + dto.getJobId());
		logger.info("전달받은 요청 값 (title) : " + dto.getJobTitle());
		SqlSession session = manager.openSession();
		List<Job_DTO> lists = session.selectList(NS+"getJobTrim", dto);
		return lists;
	}
	
	@Override
	public boolean updateJobSet(Job_DTO dto) {
		logger.info("전달받은 요청 값 (id) : " + dto.getJobId());
		logger.info("전달받은 요청 값 (title) : " + dto.getJobTitle());
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"updateJobSet", dto);
		return (n>0)?true:false;
	}
	
	@Override
	public int updateJobTrim(Job_DTO dto) {
		logger.info("전달받은 요청 값 (title) : " + dto.getJobTitle());
		logger.info("전달받은 요청 값 (minSalary) : " + dto.getMinSalary());
		int n=0;
		try {
			SqlSession session = manager.openSession();
			n = session.update(NS+"updateJobTrim", dto);
			session.commit();
		} catch (Exception e) {
//			e.printStackTrace();
			logger.warn(e.getMessage());
		}
		logger.info("오류가 발생되었을까요?");// try-catch 를 하면 멈추지 않고 넘어 감 
		return n;
	}
}
