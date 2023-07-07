package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.comm.Comm;
import com.min.edu.dao.BoardDaoImpl;
import com.min.edu.dao.IBoardDao;
import com.min.edu.dto.BoardDto;

public class SetUpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardDao dao;
	private Logger logger = Logger.getLogger(SetUpdateBoard.class);

    public SetUpdateBoard() {
    	dao = new BoardDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("SetUpdateBoard doGet");
		String seq = request.getParameter("seq");
		
		BoardDto dto = dao.getOneBoard(seq);
		request.setAttribute("one", dto);
		Comm.forward(request, response, "/WEB-INF/views/ModifyForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		logger.info("SetUpdateBoard doPost");
		String seq = request.getParameter("seq");
		String content = request.getParameter("content");	
		
		Map<String, Object> inMap = new HashMap<String, Object>();
		inMap.put("seq", seq);
		inMap.put("content", content);
		
		boolean isc = dao.setUpdateBoard(inMap);
		
		if(isc==true) {
			response.sendRedirect("./getOneBoard.do?seq="+seq);
		} else {
			response.sendRedirect("./setUpdateBoard.do?seq="+seq);
		}
	}

}
