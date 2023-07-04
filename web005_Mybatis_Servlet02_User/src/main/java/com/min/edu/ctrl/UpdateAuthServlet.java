package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDto;

public class UpdateAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginLogoutServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		IUserDao dao = new UserDaoImpl();
		UserDto dto = dao.getUserInfo(seq);
		request.setAttribute("dto", dto);
		forward(request, response, "/WEB-INF/views/updateAuthForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		String role = request.getParameter("role");
		System.out.println("seq : "+seq+" role : "+role);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("auth", role);
		map.put("seq", seq);
		
		IUserDao dao = new UserDaoImpl();
		int n = dao.updateAuthUser(map);
		
		if(n>0){
			response.sendRedirect("./getAllUser.servlet");
		} else {
			response.sendRedirect("./updateAuth.servlet?seq="+seq);
		}
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
