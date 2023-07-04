package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDto;

public class LoginLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginLogoutServlet.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		logger.info("doGet 로그아웃 기능");
		
		HttpSession session = request.getSession();
		session.invalidate();
		forward(request, response, "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		logger.info("doPost 로그인 기능");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.printf("%s / %s", id, password);
		
		Map<String, Object> inmap = new HashMap<String, Object>();
		inmap.put("id", id);
		inmap.put("password", password);
		
		IUserDao dao = new UserDaoImpl();
		UserDto loginDto = dao.getLogin(inmap);
		
		if(loginDto != null){
			System.out.println("로그인 성공");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginDto", loginDto);
			session.setMaxInactiveInterval(60*10);
			if(loginDto.getAuth().equalsIgnoreCase("ADMIN")){
				/* response.sendRedirect("./adminMain.jsp"); */
				forward(request, response, "/WEB-INF/views/adminMain.jsp");
			} else if(loginDto.getAuth().equalsIgnoreCase("USER")){
				/* response.sendRedirect("./userMain.jsp"); */
				forward(request, response, "/WEB-INF/views/userMain.jsp");
			}

		} else {
			PrintWriter out = response.getWriter();
			StringBuffer sb = new StringBuffer();
			sb.append("<script type='text/javascript'>");
			sb.append("alert('아이디와 비밀번호를 확인하세요.');");
			sb.append("location.href='./index.jsp';" );
			sb.append("</script>");
			out.println(sb.toString());
		}
	}
	
	// 값을 가지고 다음 페이지로 이동하는 메소드 forward
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
