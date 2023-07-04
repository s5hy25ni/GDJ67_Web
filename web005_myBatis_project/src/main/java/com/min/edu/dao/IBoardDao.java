package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.BoardDto;

public interface IBoardDao {
	
	/**
	 * 전체 게시글 조회
	 * @return 전체 게시글
	 */
	public List<BoardDto> getAllBoard();
	
	/**
	 * 1개 게시글 상세 조회
	 * @return 1개 게시글
	 */
	public BoardDto getOneBoard(String seq);
	
	/**
	 * 새글 작성
	 * @param inDto WRITER, TITLE, CONTENT
	 * @return 성공 1, 실패 0
	 */
	public boolean setInsertBoard(BoardDto inDto);
	
	/**
	 * 수정
	 * @param inMap TITLE, CONTENT, SEQ
	 * @return 성공 1, 실패 0
	 */
	public boolean setUpdateBoard(Map<String, Object> inMap);
	
	/**
	 * 삭제(UPDATE DELFALG='Y')
	 * @param seq SEQ
	 * @return 성공 1, 실패 0
	 */
	public boolean setDeleteBoard(String seq);
}
