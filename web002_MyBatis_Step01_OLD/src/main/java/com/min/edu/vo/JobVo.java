package com.min.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JobVo {
	// Java.NET Object
	// ct+st+a -> 소문자
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;


	
	
}
