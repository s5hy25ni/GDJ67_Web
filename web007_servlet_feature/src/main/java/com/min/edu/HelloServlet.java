package com.min.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 9173344449137691064L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String initParam = getServletConfig().getInitParameter("webInit");
		System.out.println("web.xml에서 servlet 클래스를 호출할 때 입력받은 초기값 : "+initParam);
		
		String contextParam = getServletContext().getInitParameter("spring");
		System.out.println("web.xml에서 프로젝트 전체에서 사용할 수 있는 값 : "+contextParam);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/servlet2.jsp").forward(req, resp);
	}
}