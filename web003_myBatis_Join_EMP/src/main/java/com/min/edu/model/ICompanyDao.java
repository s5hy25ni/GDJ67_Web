package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.Dept_DTO;
import com.min.edu.dto.Dept_DTO5;

public interface ICompanyDao {

	public List<Dept_DTO> joinCombine02();
	
	public List<Dept_DTO> joinCombine03();
	
	public List<Dept_DTO5> joinCombine05();
}
