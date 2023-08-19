package com.test.page;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.joindto.RootBoard;

public class OneToManyTest {

	@Test
	public void test() {
		SqlSessionFactory factory = SqlSessionFactoryManager.getFactory();
		SqlSession session = factory.openSession();
		RootBoard resultDto =  session.selectOne("OneToMany.oneToMany");
		System.out.println(resultDto);
		assertNotNull(resultDto);
	}

}
