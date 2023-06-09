package com.min.edu.vo;

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
public class JobVo {

	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
	
}
