package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Job_DTO;

public interface IBindingDao {
	public List<Job_DTO> binding01(Map<String, Object> map);
	public List<Job_DTO> binding02(Map<String, Object> map);
}
