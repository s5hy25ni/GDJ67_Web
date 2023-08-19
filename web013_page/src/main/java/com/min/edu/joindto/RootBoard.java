package com.min.edu.joindto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class RootBoard {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String regdate;
	
	private List<ReplyBoard> reply;
}
