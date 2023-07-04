package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

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

public class GetAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginLogoutServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("GetAllUserServlet doGet");
		IUserDao dao = new UserDaoImpl();
		List<UserDto> lists = dao.getAllUser();
		request.setAttribute("lists", lists);
		forward(request, response, "/WEB-INF/views/userList.jsp");
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
