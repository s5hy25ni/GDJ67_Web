package com.min.edu.dto;

public class BoardDto {
	private String seq    ;
	private String writer ;
	private String title  ;
	private String content;
	private String regdate;
	private String delfalg;
	
	public BoardDto() {
	}
	
	public BoardDto(String writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDelfalg() {
		return delfalg;
	}
	public void setDelfalg(String delfalg) {
		this.delfalg = delfalg;
	}
	@Override
	public String toString() {
		return "BoardDto [seq=" + seq + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", delfalg=" + delfalg + "]";
	}
	
	
}
