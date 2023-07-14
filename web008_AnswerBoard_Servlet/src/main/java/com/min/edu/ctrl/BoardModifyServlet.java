package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerboardImpl;
import com.min.edu.model.IAnswerboardDao;

public class BoardModifyServlet extends HttpServlet {

	private static final long serialVersionUID = -7303674362118819017L;
	private Logger logger = Logger.getLogger(BoardModifyServlet.class);
	
	// boardDetail 화면에서 수정폼 화면으로 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardModifyServlet doGet");
		String seq = req.getParameter("seq");
		
		UserVo loginVo = (UserVo)req.getSession().getAttribute("loginInfo");
		
		logger.info("BoardModifyServlet doGet 요청 받은 값 : "+seq);
		IAnswerboardDao dao = new AnswerboardImpl();
		AnswerboardDto dto = dao.selectDetailBoard(seq);
		
		if(loginVo.getId().equals(dto.getId())) {
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("/WEB-INF/views/boardModify.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("./logout.do");
		}
		
	}
	// 화면에서 요청받은(수정된) 값을 DB에 적용하는 요청	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		logger.info("BoardModifyServlet doPost");
		String seq = req.getParameter("seq");
		String content = req.getParameter("content");
		
		logger.info("BoardModifyServlet 요청값 : "+seq);
		logger.info("BoardModifyServlet 요청값 : "+content);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq",seq);
		map.put("content",content);
		
		IAnswerboardDao dao = new AnswerboardImpl();
		boolean isc = dao.modifyBoard(map);
		if(isc) {
			resp.sendRedirect("./detailBoard.do?seq="+seq);
		} else {
			resp.sendRedirect("./main.do");
		}
	}

}
