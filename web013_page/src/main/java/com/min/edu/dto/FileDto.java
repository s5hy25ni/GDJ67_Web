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
public class FileDto {
	private int fSeq;
	private int bSeq;
	private String bWriter;
	private String originFname;
	private String storedFname;
	private int fileSize;
	private String fRegdate;
	private String fDelflag;
	public FileDto(String originFname, String storedFname, int fileSize) {
		this.originFname = originFname;
		this.storedFname = storedFname;
		this.fileSize = fileSize;
	}
	
	
}
