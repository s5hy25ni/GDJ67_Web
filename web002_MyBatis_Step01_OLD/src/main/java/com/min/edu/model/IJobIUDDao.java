package com.min.edu.model;

import java.util.Map;

import com.min.edu.vo.JobVo;

public interface IJobIUDDao {
	public int insert01(JobVo vo);
	public int delete01(Map<String, Object> map);
	public boolean update01(Map<String, Object> map);
}
