package com.min.edu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class IO_09 {

	// 기존 파일에 내용 추가
	public static void main(String[] args) throws IOException {
		// 파일이 없으면 outStream으로 만들자
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.txt",Charset.forName("UTF-8"),true)));
		
		// 입력 인터페이스
		System.out.println("추가 글을 작성해봅니다");
		
		int c = 0;
		InputStreamReader in = new InputStreamReader(System.in);
		while ((c=in.read()) != -1) {
			out.write(c);
		}
		
		out.flush();
		out.close();
		in.close();
		
	}

}
