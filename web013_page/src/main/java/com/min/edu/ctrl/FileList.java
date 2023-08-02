package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.BoardDto2;
import com.min.edu.model.BoardImpl;
import com.min.edu.model.IBoard;

public class FileList extends HttpServlet {
	
	private static final long serialVersionUID = 1354939054299516073L;
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>> FileList doGet");
		IBoard dao = new BoardImpl();
		List<BoardDto2> bList = dao.getAllBoard();
		req.setAttribute("bList", bList);
		req.getRequestDispatcher("/WEB-INF/views/fileList.jsp").forward(req, resp);
		
	}
}
