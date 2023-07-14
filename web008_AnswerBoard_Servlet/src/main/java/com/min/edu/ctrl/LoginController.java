package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 4478070591477592798L;
	
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청된 주소의 값의 name을 호출하면 값을 확인할 수 있음, 값은 무조건 문자열 => parameter
		String loc = req.getParameter("loc");
		
		logger.info("주소에 의해서 전달 받은 parameter 값 : "+loc);
		
		//WEB-INF의 하위에 있는 파일에 요청 -> 요청 위치는 java의 값이면 모두 forward
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/HTML; charset=UTF-8;");
		
		HttpSession session = req.getSession();
		
		String loc = req.getParameter("loc"); // 1JSP -> 2JSP -> 3JSP
		logger.info("doPost 주소에 의해서 전달 받은 parameter 값 : "+loc);
		
		// 요청값 처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		logger.info("doPost 주소에 의해서 전달 받은 parameter 값 : "+id+" / "+pw);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		
		//dao 실행
		IUserDao dao = new UserDaoImpl();
		UserVo loginVo = dao.loginSelect(map);
		
		logger.info("loginSelect 실행 결과 : "+loginVo);
		
		// session 처리 및 이동흐름
		if(loginVo == null) {
			resp.sendRedirect("./loginForm.jsp");
		} else {
			session.setAttribute("loginInfo", loginVo);
			resp.sendRedirect("./main.do");
		}
	}
}
