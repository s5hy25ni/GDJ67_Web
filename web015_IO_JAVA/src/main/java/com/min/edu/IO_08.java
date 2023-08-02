package com.min.edu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO_08 {
	
	// 파일 복제
	public static void main(String[] args) {
		// 파일 읽는 객체
		FileInputStream fIs = null;
		BufferedInputStream bIs = null;
		
		// 파일 작성 객체
		FileOutputStream fOs = null;
		BufferedOutputStream bOs = null;
		
		try {
			// 1) 파일을 byte로 읽는다.
			fIs = new FileInputStream("gartner_report.txt");
			
			// 2) 읽은 데이터를 buffer로 감싼다.
			bIs = new BufferedInputStream(fIs);
			
			// 3) 저장할 파일을 생성한다.
			fOs = new FileOutputStream("gartner_report_copy.txt");
			
			// 4) 쓰여질 데이터를 처리할 Buffer로 감싼다.
			bOs = new BufferedOutputStream(fOs);
			
			int c = 0;
			while ((c=bIs.read()) != -1) {
				bOs.write(c);
			}
			
			bOs.flush();
			bOs.close();
			fOs.close();
			bIs.close();
			fIs.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
