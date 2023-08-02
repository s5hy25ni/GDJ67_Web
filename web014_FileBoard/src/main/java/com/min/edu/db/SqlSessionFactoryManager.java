package com.min.edu.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class SqlSessionFactoryManager {
	private static SqlSessionFactory factroy;

	public static SqlSessionFactory getFactroy() {
		return factroy;
	}
	
	static {
		String path="mybatis/Configuration.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			factroy = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("SqlSessionFactory 생성");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
