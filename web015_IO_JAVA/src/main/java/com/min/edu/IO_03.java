package com.min.edu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tomcat.jni.File;

/*
 * input은 입력 / output은 출력
 */
public class IO_03 {
	public static void main(String[] args) {
		int[] num = {1, 44, -1, 55, 99};
		byte[] b = {53, 54, 55, 56, 57};
		
		try {
			FileOutputStream fileOut = new FileOutputStream("out.txt");
			for (int i = 0; i < num.length; i++) {
				fileOut.write(num[i]);
			}
			for (int i = 0; i < b.length; i++) {
				fileOut.write(b[i]);
			}
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------------file");
		// 위에서 저장된 out.txt 파일을 읽어서 출력해보자
		try {
			FileInputStream fileIn = new FileInputStream("out.txt");
			int c = 0;
			while ((c=fileIn.read()) != -1) {
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		// data의 타입에 맞춰 표현
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream("dataType.txt"));
			out.writeInt(128);
			out.writeInt(-1);
			out.writeBoolean(false);
			out.writeDouble(3.14);
			out.writeChar('가');
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------------data");
		
		try {
			DataInputStream in = new DataInputStream(new FileInputStream("C:\\eclipse_web\\workspace_web\\web015_IO_JAVA\\dataType.txt"));
			System.out.println(in.readInt()); 
			System.out.println(in.readInt());
			System.out.println(in.readBoolean());
			System.out.println(in.readDouble());
			System.out.println(in.readChar());
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
