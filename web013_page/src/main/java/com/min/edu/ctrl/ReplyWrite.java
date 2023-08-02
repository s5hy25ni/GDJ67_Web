package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.ReplyDto;
import com.min.edu.model.BoardImpl;
import com.min.edu.model.IBoard;

public class ReplyWrite extends HttpServlet {

	private static final long serialVersionUID = 3012052152788556509L;
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>> ReplyWrite doGet");
		String seq = req.getParameter("seq");
		System.out.println(seq);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>> ReplyWrite doPost");
		String reply = req.getParameter("reply");
		Map<String, Object> map = new HashMap<String, Object>();
		String seq = req.getParameter("seq");
		map.put("seq", seq);
		map.put("start", "1");
		map.put("end", "3");
		String writer = req.getParameter("writer");
		ReplyDto rDto = new ReplyDto(Integer.parseInt(seq), writer, reply);
	
		IBoard dao = new BoardImpl();
		boolean isc = dao.insertReply(rDto);
		ReplyDto dto = dao.getOneBoard(map).getReplyDto().get(dao.getOneBoard(map).getReplyDto().size()-1);
		if(isc) {
			System.out.println("답글 입력 완료");
			resp.getWriter().print("{\"writer\":\""+dto.getRWriter()+"\",\"content\":\""+dto.getRContent()+"\",\"regdate\":\""+dto.getRRegdate()+"\"}");			
		} else {
			System.out.println("답글 입력 실패");
		}
	}
}
