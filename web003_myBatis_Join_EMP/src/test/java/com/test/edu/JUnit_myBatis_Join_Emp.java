package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.min.edu.dto.Dept_DTO;
import com.min.edu.dto.Dept_DTO5;
import com.min.edu.model.CompanyDaoImpl;
import com.min.edu.model.ICompanyDao;

public class JUnit_myBatis_Join_Emp {
	
	private ICompanyDao dao = new CompanyDaoImpl();

//	@Test
	public void joinCombine02() {
	 List<Dept_DTO> lists = dao.joinCombine02();
	 assertNotNull(lists);
	}
	
//	@Test
	public void joinCombine03() {
	 List<Dept_DTO> lists = dao.joinCombine03();
	 assertNotNull(lists);
	}
	
	@Test
	public void joinCombine05() {
	 List<Dept_DTO5> lists = dao.joinCombine05();
	 System.out.println(lists);
	 assertNotNull(lists);
	}

}
