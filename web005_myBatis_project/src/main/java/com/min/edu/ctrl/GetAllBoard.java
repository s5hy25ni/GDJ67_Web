package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

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

public class GetAllBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardDao dao;
	private Logger logger = Logger.getLogger(GetAllBoard.class);
	
    public GetAllBoard() {
    	dao = new BoardDaoImpl();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("GetAllBoard doGet");
		List<BoardDto> lists = dao.getAllBoard();
		request.setAttribute("all", lists);
		Comm.forward(request, response, "/WEB-INF/views/ListBoard.jsp");
	}

}
