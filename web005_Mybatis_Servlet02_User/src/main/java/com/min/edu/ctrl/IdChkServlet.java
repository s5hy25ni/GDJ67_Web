package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;

public class IdChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserDao dao;
	
    public IdChkServlet() {
    	dao = new UserDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int n = dao.duplicateId(id);
		boolean isc = false;
		if(n==1){
			isc = true;
		}
		forward(request, response, "/WEB-INF/views/idChk.jsp?isc="+isc);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
