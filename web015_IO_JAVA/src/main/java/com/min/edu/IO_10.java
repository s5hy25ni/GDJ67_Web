package com.min.edu;

import java.io.File;
import java.util.Date;

public class IO_10 {

	/*
	 * 파일(java.io.File) 클래스 활용
	 * 파일 클래스를 통해서 : 타입, 크기, 디렉터리, 파일의 이름
	 */
	public static void main(String[] args) {

		File f1 = new File("c:\\windows\\system.ini");
		File f2 = new File("c:\\eclipse_web\\temp");
		File f3 = new File("c:\\eclipse_web");
		
		// 1) 파일 여부 판단(파일:확장자O, 디렉토리:확장자X)
		String res = "";
		if(f3.isFile()) {
			res = "파일입니다.";
		} else {
			res = "파일이 아닙니다.";
		}
		System.out.println(res);
		
		// 2) 폴더 생성
		if(!f2.exists()) {
			if(f2.mkdirs()) {
				System.out.println("폴더를 생성했습니다.");
			} else {
				System.out.println("폴더 생성에 실패했습니다.");
			}
		} else {
			System.out.println("디렉토리가 존재합니다.");
		}
		
		// 3) 폴더명 변경
		f2.renameTo(new File("c:\\eclipse_web\\tmp"));
		
		// 4) 정보 확인
		String[] fileNames = f3.list(); // 파일의 위치, listFile() -> File[] 파일 객체
		for(String s : fileNames) { // s객체는 이름만 가지고 있음
//			System.out.println(s);
			File f = new File(f3, s);
			long t = f.lastModified();
			long l = f.length();
			String n = f.getName();
			
			System.out.println("마지막 수정 일자 : "+t);
			System.out.println("파일의 크기 : "+l);
			System.out.println("파일의 이름 : "+n);
			System.out.printf("수정시간 : %tb, %td, %ts, %tT \n",t,t,t,t);
			
			Date date = new Date();
			System.out.println(date.toString());
			
			System.out.println("---------------------------------");
		}
	}

}
