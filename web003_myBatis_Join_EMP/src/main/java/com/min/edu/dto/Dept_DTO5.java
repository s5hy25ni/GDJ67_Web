package com.min.edu.dto;

import java.util.List;

public class Dept_DTO5 {
	private int deptno;
	private String dname;
	private String loc;
	private List<Emp_DTO> edto;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<Emp_DTO> getEdto() {
		return edto;
	}
	public void setEdto(List<Emp_DTO> edto) {
		this.edto = edto;
	}
	
	@Override
	public String toString() {
		return "Dept_DTO5 [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", edto=" + edto + "]";
	}

}
