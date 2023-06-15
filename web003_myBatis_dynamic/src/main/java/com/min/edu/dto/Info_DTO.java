package com.min.edu.dto;

import java.io.Serializable;

public class Info_DTO implements Serializable{

	private static final long serialVersionUID = 2116757944846181671L;
	private int seq;
	private String name;
	private String phone;
	private String auth;
	private String regdate;
	
	public Info_DTO(int seq, String name, String phone, String auth, String regdate) {
		super();
		this.seq = seq;
		this.name = name;
		this.phone = phone;
		this.auth = auth;
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Info_DTO [seq=" + seq + ", name=" + name + ", phone=" + phone + ", auth=" + auth + ", regdate="
				+ regdate + "]";
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
