package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import org.apache.log4j.Logger;

import com.min.edu.comm.JsFlow;
import com.min.edu.dto.AnswerboardDto;
import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerboardImpl;
import com.min.edu.model.IAnswerboardDao;

public class BoardReplyServlet extends HttpServlet {

	private static final long serialVersionUID = 1143902056622500545L;
	private Logger logger = Logger.getLogger(BoardReplyServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		logger.info("BoardReplyServlet doGet");
		String seq = req.getParameter("seq");
		logger.info("BoardReplyServlet doGet 요청값 : "+seq);
		
		HttpSession session = req.getSession();
		if(session.getAttribute("loginInfo")==null) {
			String strHTML = JsFlow.JsForward("로그인을 해주세요.", "./boardLogin.do");
			resp.getWriter().print(strHTML);
		} else {
			IAnswerboardDao dao = new AnswerboardImpl();
			AnswerboardDto dto = dao.selectDetailBoard(seq);
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("/WEB-INF/views/boardReply.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		HttpSession session = req.getSession();
		UserVo loginVo = (UserVo)session.getAttribute("loginInfo");
		
		logger.info("BoardReplyServlet doPost");
		
		String pSeq = req.getParameter("seq");
		String id = loginVo.getId();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		String params = String.format("%s, %s, %s, %s", pSeq, id, title, content);
		logger.info("BoardReplyServlet doPost 요청값 : "+params);
		
		AnswerboardDto dto = new AnswerboardDto();
		dto.setSeq(Integer.parseInt(pSeq));
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		
		IAnswerboardDao dao = new AnswerboardImpl();
		boolean isc = dao.reply(dto);
		if(isc) {
			resp.sendRedirect("./detailBoard.do?seq="+dto.getSeq());
		} else {
			resp.sendRedirect("./logout.do");
		}
		
	}


























}
