package com.min.edu.dto;

import java.util.List;

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
public class BoardDto2 {
	private int bSeq;
	private String title;
	private String bWriter;
	private String bContent;
	private String bRegdate;
	private String bDelflag;
	
	private List<ReplyDto> replyDto;
	private List<FileDto> fileDto;
	
	public BoardDto2(String title, String bWriter, String bContent) {
		this.title = title;
		this.bWriter = bWriter;
		this.bContent = bContent;
	}
	
	
}
