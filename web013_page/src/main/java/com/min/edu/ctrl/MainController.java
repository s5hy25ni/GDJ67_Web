package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.IUser;
import com.min.edu.model.UserImpl;

public class MainController extends HttpServlet {

	private static final long serialVersionUID = -6857892590821369605L;
	
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("$$$메인 컨트롤러 doGet실행$$$");
		IUser udao = new UserImpl();
		int n = udao.getMyUser();
		logger.info("$$$UserImpl에 getMyUser 실행 결과 :"+n+"$$$");
		req.setAttribute("userCnt", n);
		req.getRequestDispatcher("./WEB-INF/views/index.jsp").forward(req, resp);
	}
}
