package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {

	private static SqlSessionFactory factory;

	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	static {
		// myBatis의 환경설정 정보 파일인 xml의 위치를 상대적인 경로로 선언
		String path="com/min/edu/mybatis/Configuration.xml";
		
		try {
			Reader reader= Resources.getResourceAsReader(path);
			factory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("SqlSessionFactory 객체 생성");
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
