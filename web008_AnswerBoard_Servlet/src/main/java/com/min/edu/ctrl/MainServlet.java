package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerboardImpl;
import com.min.edu.model.IAnswerboardDao;

public class MainServlet extends HttpServlet{

	private static final long serialVersionUID = -5877269302886917396L;
	
	private Logger logger = Logger.getLogger(MainServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("MainServlet doGet");
		
		//TEST index.jsp
//		HttpSession session = req.getSession();
//		session.setAttribute("loginInfo", new UserVo("두꺼비", "진로", "U"));
//		resp.sendRedirect("./index.jsp");
		
		//TODO 004 로그인이 된 후 첫번째 페이지인 모든 글 보기 화면으로 이동
		IAnswerboardDao dao = new AnswerboardImpl();
		List<AnswerboardDto> lists = dao.selectAllBoard();
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/boardMain.jsp").forward(req, resp);
	}
	
}
