package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.BoardDto;
import com.min.edu.dto.FileBoardDto;

public interface IBoardFile {
	// 글 목록 조회
	public List<BoardDto> getAllList();
	
	// 글 입력 & 파일 입력
	public boolean insertBoard(BoardDto bDto, FileBoardDto fDto);
	
	// 파일가져오기
	public FileBoardDto getFile(String seq);
	
	// 상세보기(글+파일명)
	public List<BoardDto> getBoard(String seq);
}
