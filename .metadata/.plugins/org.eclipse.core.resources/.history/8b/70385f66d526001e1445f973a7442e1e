package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUser;
import com.min.edu.model.UserImpl;

public class LoginCtrl extends HttpServlet {

	private static final long serialVersionUID = -7209686893853257365L;
	HttpSession session;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		session.removeAttribute("loginInfo");
		
		resp.sendRedirect("./");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		IUser dao = new UserImpl();
        UserDto dto = dao.login(map);
        

        session = req.getSession();
        session.setAttribute("loginInfo", dto);
        
        req.getRequestDispatcher("/").forward(req, resp);
	}
	
}
