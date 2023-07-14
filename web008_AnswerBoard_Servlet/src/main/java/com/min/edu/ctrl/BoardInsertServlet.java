package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.comm.JsFlow;
import com.min.edu.dto.AnswerboardDto;
import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerboardImpl;
import com.min.edu.model.IAnswerboardDao;

public class BoardInsertServlet extends HttpServlet {

	private static final long serialVersionUID = 3645428190591430399L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardInsertServlet doGet");
		
		HttpSession session = req.getSession();
		UserVo loginVo = (UserVo)session.getAttribute("loginInfo");
		
		if(loginVo==null) {
			String strHTML = JsFlow.JsForward("로그인하세용", "./boardLogin.do");
			resp.getWriter().print(strHTML);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/boardInsert.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");

		logger.info("BoardInsertServlet doPost");
		
		HttpSession session = req.getSession();
		UserVo loginVo = (UserVo)session.getAttribute("loginInfo");
		
		String id = loginVo.getId();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		
		content = content.replaceAll("(\r\n|\r|\n|\n\r)","<br>"); content =
		content.replaceAll("(>)","&gt;"); 
		content = content.replaceAll("(<)","&lt;");
		 
		
		AnswerboardDto dto = new AnswerboardDto();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		
		IAnswerboardDao dao = new AnswerboardImpl();
		boolean isc = dao.insertBoard(dto);
		if(isc) {
			resp.sendRedirect("./detailBoard.do?seq="+dto.getSeq());
		} else {
			resp.sendRedirect("./logout.do");
		}
		logger.info("BoardInsertServlet doPost : \n" + content );
		
	}
}
