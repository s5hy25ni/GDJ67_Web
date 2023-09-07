package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.vo.FileVo;
import com.min.edu.vo.PageVo;
import com.min.edu.vo.ReplyVo;
import com.min.edu.vo.RootVo;

public class BoardPageImpl implements IBoardPage {
	private Logger logger = LoggerFactory.getLogger(BoardPageImpl.class);
	private final String NS = "com.min.edu.model.BoardPageImpl.";
	private SqlSessionFactory manager;
	
	public BoardPageImpl() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
	@Override
	public List<RootVo> getDetail(Map<String, Object> map) {
		logger.info(">>>>> 게시글 상세 조회 : {}", map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getDetail",map);
	}

	@Override
	public PageVo getReplyCnt(String ref) {
		logger.info(">>>>> 댓글 총 개수 : {}", ref);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getReplyCnt",ref);
	}

	@Override
	public boolean insertRoot(RootVo rtVo, FileVo fVo) {
		logger.info(">>>>> 게시글 작성 : {}, {}", rtVo, fVo);
		SqlSession session = manager.openSession();		
		int cnt = 0;
		
		try {
			cnt += session.insert(NS+"insertRoot", rtVo);
			
			if(fVo != null) {	
				fVo.setBSeq(rtVo.getSeq());
				fVo.setWriter(rtVo.getId());
				
				cnt += session.insert(NS+"insertFile", fVo);
			}
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt>0?true:false;
	}
	
	@Override
	public FileVo getFname(String bSeq) {
		logger.info(">>>>> 파일 다운로드 : {}", bSeq);
		SqlSession session = manager.openSession();	
		return session.selectOne(NS+"getFname", bSeq);
	}

}