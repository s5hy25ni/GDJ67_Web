package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDto;

public class TotalController extends HttpServlet {

	private static final long serialVersionUID = 8069945146676880444L;
	private Logger logger = Logger.getLogger(TotalController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet처리");
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		logger.info("doPost처리");
		doProcess(req, resp);
	}
	
	// 모든 프로토콜을 처리하는 Process
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		String cmd = request.getParameter("command");
		System.out.println("요청받은 command 값 : "+cmd);
		
		IUserDao dao = new UserDaoImpl();
		
		if(cmd == null || cmd == ""){
			response.sendRedirect("./error.jsp");
		} else if(cmd.equalsIgnoreCase("login")){
			
			
		}
			 else if(cmd.equalsIgnoreCase("logout")) {
			
			/* response.sendRedirect("./index.jsp"); */
			
		} else if(cmd.equalsIgnoreCase("getAllUserStatus")){
			
		} else if(cmd.equalsIgnoreCase("getAllUser")){
			
		} else if(cmd.equalsIgnoreCase("updateAuthForm")){
			
		} else if(cmd.equalsIgnoreCase("updateAuth")) {
			
		} else if(cmd.equalsIgnoreCase("getUserInfo")){
			
		} else if(cmd.equalsIgnoreCase("modify")){
			
		} else if(cmd.equalsIgnoreCase("updateUser")){
			
		} else if(cmd.equalsIgnoreCase("delUser")){
			
		} else if(cmd.equalsIgnoreCase("registForm")) {
			
			
		} else if(cmd.equalsIgnoreCase("insertUser")){
			

					
			
		} else if(cmd.equalsIgnoreCase("idChk")){
			
		}
	} // doProcess
	
	// 값을 가지고 다음 페이지로 이동하는 메소드 forward
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
