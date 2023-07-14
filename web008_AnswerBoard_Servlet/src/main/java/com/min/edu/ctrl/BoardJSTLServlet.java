package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.model.AnswerboardImpl;
import com.min.edu.model.IAnswerboardDao;

public class BoardJSTLServlet extends HttpServlet {

	private static final long serialVersionUID = 4743717763404647813L;
	private Logger logger = Logger.getLogger(BoardJSTLServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("MainServlet doGet");

		IAnswerboardDao dao = new AnswerboardImpl();
		List<AnswerboardDto> lists = dao.selectAllBoard();
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/boardListJSTL.jsp").forward(req, resp);
	}

}
