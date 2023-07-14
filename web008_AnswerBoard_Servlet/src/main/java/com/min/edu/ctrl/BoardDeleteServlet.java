package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerboardImpl;
import com.min.edu.model.IAnswerboardDao;

public class BoardDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = -7115106910661393794L;
	private Logger logger = Logger.getLogger(MainServlet.class);

	// 상세에서 단일 삭제를 위한 get 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardDeleteServlet doGet");
		
		UserVo loginVo = (UserVo)req.getSession().getAttribute("loginInfo");
		if(loginVo.getAuth().equalsIgnoreCase("A")) {
			IAnswerboardDao dao = new AnswerboardImpl();
			
			//DB에서 글 삭제
//			String seq = req.getParameter("seq");
//			boolean isc = dao.deleteBoardReal(seq);
			
			// myBatis Dynamic 쿼리를 통한 다중 삭제
			String[] seqs = req.getParameterValues("seq");
			Map<String, String[]> map = new HashMap<String, String[]>();
			map.put("seqs", seqs);
			int n = dao.multiDelete2(map);
			
			resp.sendRedirect("./main.do");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/boardError.jsp").forward(req, resp);
		}
	}
	
	// 전체글 보기에서 다중삭제 POST 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); // 값을 받을 때
		resp.setContentType("text/HTML; charset=UTF-8;"); // 응답해줄때
		logger.info("BoardDeleteServlet doPost");
		
		String[] seqs = req.getParameterValues("ch");
		logger.info("BoardDeleteServlet doPost 전달 받은 요청 값 : "+Arrays.toString(seqs));
		
		IAnswerboardDao dao = new AnswerboardImpl();
		boolean isc = dao.deleteBoard(seqs);
		
		if(isc) {
			StringBuffer sb = new StringBuffer();
			sb.append("<script>");
			sb.append("alert('삭제가 완료되었습니다.');");
			sb.append("location.href='./main.do';");
			sb.append("</script>");
			resp.getWriter().println(sb.toString());
		} else {
			req.getRequestDispatcher("/WEB-INF/views/boardError.jsp").forward(req, resp);
		}
	}

}
