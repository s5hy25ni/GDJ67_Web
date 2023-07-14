package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.model.AnswerboardImpl;
import com.min.edu.model.IAnswerboardDao;

public class BoardDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 5439537080009220204L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardDetailServlet doGet");
		String seq = req.getParameter("seq");
		logger.info("BoardDetailServlet doGet 요청값 : "+seq);
		
		IAnswerboardDao dao = new AnswerboardImpl();
		AnswerboardDto dto = dao.selectDetailBoard(seq);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/views/boardDetail.jsp").forward(req, resp);
	}
}
