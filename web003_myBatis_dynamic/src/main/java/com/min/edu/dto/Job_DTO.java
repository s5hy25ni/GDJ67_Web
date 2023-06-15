package com.min.edu.dto;

import java.io.Serializable;

public class Job_DTO implements Serializable{

	private static final long serialVersionUID = -5405586042498868981L;
	private String jobId; // JOB_ID와 매핑
	private String jobTitle; // JOB_TITLE와 매핑
	private String minSalary; // MIN_SALARY와 매핑
	private String maxSalary; // MAX_SALARY와 매핑
	
	public Job_DTO(String jobId, String jobTitle, String minSalary, String maxSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
	
	@Override
	public String toString() {
		return "Job_DTO [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	public String getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

}
