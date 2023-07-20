package com.min.edu.comm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePatternBean {
	
	private String regdate;
	
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	//REGDATE의 형태를 출력하기 위해서 사용
	//REGDATE String 타입 -> java.util.Date 변경 -> java.text.simpleDateFormat을 통해 변경 -> 변화된 String 출력
	public String getDatePattern() {		
		Date cDate = null;
		Date now = null;
		SimpleDateFormat fmt2 = null;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			cDate = fmt.parse(regdate);
			fmt2 = new SimpleDateFormat("yyyy년 MM월 dd일");
			now = new Date();			
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return fmt2.format(cDate).compareTo(fmt2.format(now))==0?"오늘":fmt2.format(cDate);
	}
}
