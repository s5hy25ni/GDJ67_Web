package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDto;

public class GetAllUserStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDao dao = new UserDaoImpl();
		List<UserDto> lists = dao.getAllUserStatus();
		request.setAttribute("lists", lists);
		forward(request, response, "/WEB-INF/views/userListStatus.jsp");
	}
	
	// 값을 가지고 다음 페이지로 이동하는 메소드 forward
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
