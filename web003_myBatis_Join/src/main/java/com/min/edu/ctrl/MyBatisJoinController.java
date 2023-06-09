package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Player_DTO4;
import com.min.edu.dto.Team_DTO;
import com.min.edu.dto.Team_DTO5;
import com.min.edu.model.ISoccerDao;
import com.min.edu.model.SoccerDaoImpl;

public class MyBatisJoinController extends HttpServlet {

	private static final long serialVersionUID = -5363030570604979040L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 이동 흐름(redirect, forward)
//		req.setAttribute("requestValue", "값전송");
//		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		ISoccerDao dao = new SoccerDaoImpl();
		
		//TODO 01-03 joinCombine01() Controller에서 JSP로 값 전달
		List<All_Dto> lists = dao.joinCombine01();
		req.setAttribute("listsOne", lists);
				
		//TODO 02-03 joinCombine02() Controller에서 JSP로 값 전달
		List<Team_DTO> lists_02 = dao.joinCombine02();
		req.setAttribute("listsTwo", lists_02);
		
		//TODO 03-03 joinCombine03() Controller에서 JSP로 값 전달
		List<Team_DTO> lists_03 = dao.joinCombine03();
		req.setAttribute("listsThree", lists_03);
		
		//TODO 04-03 joinCombine04() Controller에서 JSP로 값 전달
		List<Player_DTO4> lists_04 = dao.joinCombine04();
		System.out.println(lists_04.size());
		req.setAttribute("listsFour", lists_04);
		
		
		//TODO 05-03 joinCombine05() Controller에서 JSP로 값 전달
		List<Team_DTO5> lists_05 = dao.joinCombine05();
		System.out.println(lists_05.size());
		req.setAttribute("listsFive", lists_05);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
}
