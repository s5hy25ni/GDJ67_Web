package com.test.mybatis;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.mybatis.SqlDaoSupport;

public class MyBatis_JUnit {

	@Test
	public void test() {
		SqlSessionFactory manager = SqlDaoSupport.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}

}
