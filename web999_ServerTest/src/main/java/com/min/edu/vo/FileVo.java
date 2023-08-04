package com.min.edu.vo;

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
public class FileVo {
	private int bSeq;
	private String writer;
	private String originFname;
	private String storedFname;
	private int fileSize;
	
	public FileVo(String originFname, String storedFname, int fileSize) {
		this.originFname = originFname;
		this.storedFname = storedFname;
		this.fileSize = fileSize;
	}

}
