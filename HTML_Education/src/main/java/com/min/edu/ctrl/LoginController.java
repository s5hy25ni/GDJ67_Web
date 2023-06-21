package com.min.edu.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		System.out.println("doGet 호출");
		String reqName = request.getParameter("name");
		System.out.println(reqName);
		response.getWriter().print("<h1>나의 이름은? "+reqName+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String user = request.getParameter("user");
		String pw = request.getParameter("pw");
		
		System.out.println("doPost 프로토콜 실행");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>새로운 페이지</title>");
		sb.append("</head>");
		sb.append("<body>");
			sb.append("<h1>로그인된 정보는 "+user+"</h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		response.getWriter().print(sb.toString());
	}

}
