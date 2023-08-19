package com.min.edu.util;

import java.util.List;

import com.min.edu.dto.CalendarDto;

public class CalendarUtil {

	// 한 자리의 숫자를 두 자리의 문자형 숫자로 만들어주는 메소드
	public static String iTwoWord(int month) {
		String m = String.valueOf(month);
		String.format("%2s", m);
//		System.out.println(String.format("%2s", m));
		return m.length()==2?m:"0"+m;
	}
	
	// 날짜별 글자색 표기 (토요일:파랑, 일요일:빨강, 평일:검정)
	public static String fontColor(int date, int dayOfWeek) {
		int dayCal = (date-1+dayOfWeek)%7;
		if(dayCal==0) {
			return "blue";
		} else if(dayCal==1) {
			return "red";
		} else {
			return "black";
		}
	}
	
	// 해당일에 포함된 게시글을 붙여 넣기 위해 HTML 태그를 만듦
	// i : 달력의 일, cList : 해당 월의 전체 글 목록
	public static String getCalView(int i, List<CalendarDto> cList) {
		String d = iTwoWord(i);
		StringBuffer sb = new StringBuffer();
		for(CalendarDto dto : cList) {
			if(dto.getMdate().substring(6, 8).equals(d)) {
				sb.append("<p title='"+dto.getTitle()+"'>");
				
				// title의 문자열 길이표기법 변경
				if(dto.getTitle().length()>6) {
					sb.append(dto.getTitle().subSequence(0, 6));
					sb.append("...");
				} else {
					sb.append(dto.getTitle());
				}
				
				sb.append("</p>");
			}
			
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
