package com.min.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.dto.Board_DTO;
import com.min.dto.UserInfo_DTO;

public class FirstController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8998846524590829600L;

	// put : 값 입력 post, delete : 값 삭제 post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id"); // html tag name 속성
		String pw = req.getParameter("pwd");
		// service -> dao -> myBatis -> 결과 반환(로그인 정보, 게시글 조회)
		
		// 로그인 정보
		UserInfo_DTO info = new UserInfo_DTO("스위스", id, "알프스산맥", "A");
		
		// 게시판글
		List<Board_DTO> lists = new ArrayList<Board_DTO>();
		lists.add(new Board_DTO("글작성1","우영우","2023-04-04"));
		lists.add(new Board_DTO("글작성2","우일우","2023-04-06"));
		lists.add(new Board_DTO("글작성3","우이우","2023-04-07"));
		lists.add(new Board_DTO("글작성4","우삼우","2023-04-09"));
		
		req.setAttribute("login", info);
		req.setAttribute("board", lists);
		
//		resp.getWriter(); // 리다이렉트
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main.jsp");
		dispatcher.forward(req, resp);
	}
}
