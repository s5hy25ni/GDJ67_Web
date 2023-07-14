package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class UserController extends HttpServlet{

	private static final long serialVersionUID = 8069945146676880444L;

	private Logger logger = Logger.getLogger(UserController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("UserController doGet");
		
		HttpSession session = req.getSession();
//		session.invalidate(); // 사용되고 있는 session 객체 자체를 지움
		session.removeAttribute("loginInfo"); // session에 있는 key에 맞는 값을 지움
		
		resp.sendRedirect("./loginForm.jsp");
	}
}
