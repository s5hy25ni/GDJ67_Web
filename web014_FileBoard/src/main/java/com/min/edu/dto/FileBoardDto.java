package com.min.edu.dto;

import java.io.Serializable;

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
public class FileBoardDto implements Serializable{

	private static final long serialVersionUID = -465723556673680310L;
	
	private int f_seq;
	private int b_seq;
	private String writer;
	private String origin_fname;
	private String stored_fname;
	private int file_size;
	private String f_regdate;
	private String f_delflag;
}
