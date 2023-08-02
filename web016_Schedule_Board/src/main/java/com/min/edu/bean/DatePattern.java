package com.min.edu.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

//property
public final class DatePattern {
	private String toDate;

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getToDate() {
		// SELECT TO_CHAR(TO_DATE('202307281200','yyyy.MM.dd HH:MI'),'MM') FROM DUAL;
		// SELECT EXTRACT(MONTH FROM TO_DATE('202307281200','yyyy.MM.dd HH:MI')) FROM DUAL;
		
		// 202307281200 -> 2023-07-28 12:00:00
		StringBuffer sb = new StringBuffer();
		sb.append(toDate.substring(0, 4));
		sb.append("-");
		sb.append(toDate.substring(4, 6));
		sb.append("-");
		sb.append(toDate.substring(6, 8));
		sb.append(" ");
		sb.append(toDate.substring(8, 10));
		sb.append(":");
		sb.append(toDate.substring(10));
		sb.append(":00");
		
		System.out.println("수정된 Date Pattern : "+sb.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date d = new Date();
		System.out.println(sdf.format(d));
		Timestamp tm = Timestamp.valueOf(sb.toString());
		System.out.println(sdf.format(tm));
		
		return sdf.format(tm);
	}

}
