package com.min.edu.dto;

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
public class ReplyDto {
	private int rSeq;
	private int bSeq;
	private String rWriter;
	private String rContent;
	private String rRegdate;
	private String rDelflag;
	public ReplyDto(int bSeq, String rWriter, String rContent) {
		this.bSeq = bSeq;
		this.rWriter = rWriter;
		this.rContent = rContent;
	}
	
	
}
