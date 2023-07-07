package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.comm.Comm;
import com.min.edu.dao.BoardDaoImpl;
import com.min.edu.dao.IBoardDao;
import com.min.edu.dto.BoardDto;

public class SetInsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardDao dao;
	private Logger logger = Logger.getLogger(SetInsertBoard.class);

    public SetInsertBoard() {
    	dao = new BoardDaoImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	logger.info("SetInsertBoard doGet");
    	Comm.forward(req, resp, "/WEB-INF/views/InsertForm.jsp");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		logger.info("SetInsertBoard doPost");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDto inDto = new BoardDto(writer, title, content);
		boolean isc = dao.setInsertBoard(inDto);		
		
		if(isc==true) {
			List<BoardDto> lists = dao.getAllBoard();
			String newSeq = lists.get(0).getSeq();
			response.sendRedirect("./getOneBoard.do?seq="+newSeq);
		} else {
			Comm.forward(request, response, "/WEB-INF/views/InsertForm.jsp");
		}
		
	}

}
