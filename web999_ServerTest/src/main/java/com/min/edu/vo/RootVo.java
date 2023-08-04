package com.min.edu.vo;

import java.util.List;

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
public class RootVo {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String regdate;
	
	private FileVo fileVo;
	private List<ReplyVo> replyVo;
	
	public RootVo(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
}
