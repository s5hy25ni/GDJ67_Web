package com.min.edu;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedList_Queue {

	public void linkedList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// 마지막에 입력
		list.add(3);
		list.add(10);
		list.addFirst(1);
		list.addLast(4);
		// list.add(idx(위치), value);
		list.add(1,99);
		
		System.out.println(list);
	}
	
	public void queue() {
		Queue<String> q = new LinkedList<String>();
		String str1="자바";
		String str2="디비";
		String str3="웹";
		String str4="서버";
		
		// add는 try-catch 해줘야 함 offer 사용
		q.offer(str1);
		q.offer(str2);
		q.offer(str3);
		q.offer(str4);
		
		System.out.println("peek() = "+q.peek());
		
//		while(q.peek()!=null) {
			// element는 값을 제거하지 않음
//			System.out.println(q.element());
//		}
		
		while(q.peek() !=null) {
			// poll은 값을 제거함
			System.out.println(q.poll());
		}
		
	}
}
