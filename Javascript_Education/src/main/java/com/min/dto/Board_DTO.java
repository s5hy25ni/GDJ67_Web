package com.min.dto;

public class Board_DTO {

	private String title;
	private String writer;
	private String regate;
	
	public Board_DTO() {
	}

	public Board_DTO(String title, String writer, String regate) {
		super();
		this.title = title;
		this.writer = writer;
		this.regate = regate;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegate() {
		return regate;
	}
	public void setRegate(String regate) {
		this.regate = regate;
	}
	
	
}


