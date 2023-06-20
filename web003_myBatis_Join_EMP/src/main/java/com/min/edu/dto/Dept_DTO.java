package com.min.edu.dto;

public class Dept_DTO {
	private int deptno;
	private String dname;
	private String loc;
	
	private Emp_DTO edto;
	public Emp_DTO getEdto() {
		return edto;
	}
	public void setEdto(Emp_DTO edto) {
		this.edto = edto;
	}
	
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
	
	@Override
	public String toString() {
		return "Dept_DTO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", edto=" + edto + "]";
	}
	
}
