package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Job_DTO;

public interface IDynamicDao {

	public List<Job_DTO> getJobIf(Map<String, Object> map);
}
