package com.test.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.min.edu.dao.EmpDaoImpl;
import com.min.edu.dao.IEmpDao;
import com.min.edu.dto.Emp_Dto;

public class JDBC_JUnit {

	private IEmpDao dao;
	
	@Test
	public void test() {
		dao = new EmpDaoImpl();
		List<Emp_Dto> lists = dao.getAllEmp();
		System.out.println(lists);
		assertNotNull(lists);
	}

}
