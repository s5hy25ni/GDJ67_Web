package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.CalendarDto;

public interface ICalboardDao {
	
//	각 달력별 리스트        
	public List<CalendarDto> getCalViewList(Map<String, Object> map);
	
//	일정 추가               
	public int insertCalBoard(CalendarDto dto);
	
//	일별 게시글 조회        
	public List<CalendarDto> getCalList(Map<String, Object> map);
	
//	일정 개수               
	public int getCalCount(Map<String, Object> map);
	
//	게시글 상세             
	public CalendarDto getCalDetail(Map<String, Object> map);
	
//	게시글 삭제			    
	public boolean multiDel(String[] seq);

}
