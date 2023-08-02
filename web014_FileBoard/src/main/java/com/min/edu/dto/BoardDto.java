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
public class BoardDto {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String regdate;
	
	private List<FileBoardDto> filedto;	
}
