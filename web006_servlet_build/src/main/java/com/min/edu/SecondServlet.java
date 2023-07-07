package com.min.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO 007 assembly로 되어 있는 위치 중 파일을 위치시켜 server를 통해서 접근
public class SecondServlet extends HttpServlet {

	private static final long serialVersionUID = 8043359260383306091L;

	@Override
	public void init() throws ServletException {
		System.out.println("second init");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String nickName = req.getParameter("nickname");
		String val = (String)req.getAttribute("val");
		
		System.out.printf("요청 받은 파라미터 : %s, %s, %s\n", name, nickName, val);
		req.setAttribute("val", "서버에서 전송하는 값");
		req.getRequestDispatcher("/WEB-INF/views/serverVal.jsp").forward(req,resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("second destory");
	}
}
