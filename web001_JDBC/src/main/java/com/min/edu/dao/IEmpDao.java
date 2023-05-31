package com.min.edu.dao;

import java.util.List;

import com.min.edu.dto.Emp_Dto;

public interface IEmpDao {

	public List<Emp_Dto> getAllEmp();
	public Emp_Dto getOneEmp(int empno);
	
}
