package com.min.edu.dto;

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
public class UserVo {
	private String id;
	private String name;
	private String password;
	private String email;
	private String auth;
	private String delflag;
	private String joindate;
	
	public UserVo(String id, String name, String auth) {
		super();
		this.id = id;
		this.name = name;
		this.auth = auth;
	}
}
