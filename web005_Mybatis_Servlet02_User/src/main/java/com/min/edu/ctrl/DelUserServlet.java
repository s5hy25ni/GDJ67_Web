package com.min.edu.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDto;

public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String seq = String.valueOf(((UserDto)session.getAttribute("loginDto")).getSeq());
		IUserDao dao = new UserDaoImpl();
		dao.delUser(seq);
		int n = dao.delUser(seq);
		if(n>0){
			response.sendRedirect("./loginLogout.servlet");
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}

}
