package com.min.edu;

import java.io.FileInputStream;
import java.io.IOException;

public class IO_02 {

	/*
	 * InputStream 데이터를 읽어 오는 객체
	 * 파일을 읽어 옴
	 * ByteStream 바이트 단위로 바이너리 값을 읽는 스트림
	 * 
	 * InputStream
	 * 	- FileStream
	 * 	- DataStream -> 형변환
	 * 
	 * 	-- 실습 --
	 * 	물리적인주소(절대경로) java의 문법오류(Escape 문자)가 발생하기 때문에 문자형태로 읽을 수 있는 주소로 만들어줘야 함
	 * 	C:\eclipse_web\eclipse\eclipse.txt
	 * 	위 파일을 읽어 console에 출력
	 * 
	 * 	※※※
	 * 		절대경로 : 고정값의 주소로 변하지 않는 주소를 가지고 있다.
	 * 		상대경로 : 주소가 계속해서 변경되어 사용되는 것(./)
	 */
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("C:\\eclipse_web\\eclipse\\eclipse.txt");
			// InputStream의 객체가 읽어오면 byte크기의 데이터를 읽어서 문자형으로 변환
			// read() : 읽는 메소드
			
			int v = 0;
//			int r = file.read();
//			System.out.println((char)r);
			
			while ((v=file.read()) != -1) {
				System.out.print((char)v);
			}
			
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
