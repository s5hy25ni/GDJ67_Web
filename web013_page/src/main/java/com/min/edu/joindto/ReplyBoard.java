package com.min.edu.joindto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class ReplyBoard {
	private String seq;
	private int ref;
	private String title;
	private String regdate;
}
