package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDto;

public interface IAnswerboardDao {
	
	/**
	 * 답변형 게시판 조회
	 * @return 검색된 여러 개 row &raquo; AnswerboardDto
	 */
	public List<AnswerboardDto> selectAllBoard();
	
	/**
	 * 게시글 상세 조회
	 * @param seq
	 * @return 검색된 한 개의 row &raquo; AnswerboardDto
	 */
	public AnswerboardDto selectDetailBoard(String seq);
	
	/**
	 * 답글작성<br>
	 * Transaction을 통한 update(replyUpdate) 후 insert(replyInsert) 진행
	 * @param AnswerboardDto &raquo; 부모의 seq와 자식의 데이터 입력
	 * @return 성공한 row의 갯수를 판단하여 성공true 실패false
	 */
	public boolean reply(AnswerboardDto dto);

	/**
	 * 게시판에 입력되어 있는 글의 content 내용 수정
	 * @param map seq, content
	 * @return 성공한 row의 갯수를 판단하여 성공true 실패false
	 */
	public boolean modifyBoard(Map<String, Object> map);
	
	/**
	 * 단일/다중 삭제
	 * @param seq 삭제 대상의 String[]
	 * @return 성공한 row의 갯수를 판단하여 성공true 실패false
	 */
	public boolean deleteBoard(String[] seq);
	
	/**
	 * 새 root글 작성
	 * @param AnswerboardDto ID, TITLE, CONTENT
	 * @return 성공한 row의 갯수를 판단하여 성공true 실패false
	 */
	public boolean insertBoard(AnswerboardDto dto);
	
	/**
	 * DataBase의 row 삭제
	 * @param seq
	 * @return 성공한 row의 갯수를 판단하여 성공true 실패false
	 */
	public boolean deleteBoardReal(String seq);

	/**
	 * 다중삭제
	 * @param map seqs키에 String[]로 되어있는 값
	 * @return 성공한 row의 갯수
	 */
	public int multiDelete2(Map<String, String[]> map);

}
