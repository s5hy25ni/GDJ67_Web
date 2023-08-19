package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.BoardDto2;
import com.min.edu.dto.FileDto;
import com.min.edu.model.BoardImpl;
import com.min.edu.model.IBoard;

public class FileWrite extends HttpServlet {

	private static final long serialVersionUID = -6785856769731092059L;
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>> FileList doGet");
		req.getRequestDispatcher("/WEB-INF/views/fileWrite.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>> FileList doPost");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		BoardDto2 bDto = new BoardDto2(title, writer, content);
		List<FileDto> fList = new ArrayList<FileDto>();
		fList.add(new FileDto("test01.png", "testtesttest01", 101));
		fList.add(new FileDto("test02.png", "testtesttest02", 102));
		
		IBoard dao = new BoardImpl();
		boolean isc = dao.insertBoard(bDto, fList);
		if(isc) {
			int seq = bDto.getBSeq();
			resp.sendRedirect("./fileDetail.do?seq="+seq);
		}
	}
}
