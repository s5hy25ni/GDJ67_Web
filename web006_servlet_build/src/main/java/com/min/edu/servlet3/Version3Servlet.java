package com.min.edu.servlet3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO 009 Servlet 3.x에서는 web.xml에 작성하는 것이 아닌 사용되는 클래스 위에 @WebServlet("매핑명")을 작성한다.
@WebServlet("/Version3Servlet.do")
public class Version3Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 받을 때 화면에 쓰여진 encoding
		/*
		 * MINE 타입에 의해 정의되는 것은 응답(response)의 문서 타입을 정의
		 * ex) text/html 작성된 글자를 html로 인식해서 번역해라
		 */
		response.setContentType("text/html; charset=UTF-8;"); // 보낼때
		String name = request.getParameter("name");
		System.out.print("요청받은 param 값 : "+name);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.print("요청받은 param 값 : "+name);
	}

}
