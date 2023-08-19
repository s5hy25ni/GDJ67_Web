package com.min.edu;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO_01 {

	/*
	 * java.io.*
	 * 1) java에서 데이터를 읽고 쓰고 하는 기능을 가진 package ex) System.out / System.in => Stream 객체
	 * 2) java.io는 IOException이 필수이다. : 외부에서 파일을 읽어온다.
	 * 3) java 스트림 객체
	 * 
	 * JAVA의 스트림이란?
	 * 	- java의 스트림은 입출력장치와 프로그램을 연결하여 이들 사이의 데이터를 처리 하는 것
	 * 	- 입력스트림(InputStream) / 출력스트림(OutputStream)
	 * 	- 기본크기 1byte(8bit)
	 * 	- 연속적으로 전송하는 데이터의 크기를 보완하기 위해서 Buffer와 Filter 사용 <= 사트림을 도와주는 객체
	 *	- 출력스트림(fifo)
	 */
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String line = scan.nextLine();
//		System.out.println(line);
		
		// 메모리에서 읽어오는데(System.in), 문자열(Reader)로 읽어(InputStream)오겠다.
		InputStreamReader reader = new InputStreamReader(System.in);
		
		try {
			int n = reader.read();
			reader.close();
			System.out.println(n);
			System.out.println((char)n);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
