package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.BoardDto;
import com.min.edu.dto.Paging;
import com.min.edu.model.BoardPageImpl;
import com.min.edu.model.IBoardPage;

public class PageController extends HttpServlet {

	private static final long serialVersionUID = 4743717763404647813L;
	private Logger logger = Logger.getLogger(PageController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("pageController doGet");
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("pageController doPost");
		doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		logger.info("pageController doProcess");
		IBoardPage dao = new BoardPageImpl();
		
		// 처음에 doGet으로 호출이 되면 첫 페이지 출력
		// request 받은 적 없음 -> request.parameter("page")를 확인해서 없으면 nul
		String page = req.getParameter("page");
	      if(page == null) {
	         page="1";
	      }
	      int selectPage = Integer.parseInt(page);
	      logger.info("$$$ 현재 페이지 $$$"+selectPage);
	      
	      Paging p = new Paging();
	      
	      //총 게시물의 갯수
	      p.setTotalCount(dao.countMyBoard());
	      
	      //출력될 총 게시글의 갯수
	      p.setCountList(5);
	      
	      //화면에 몇개의 페이지그룹
	      p.setCountPage(5);
	      
	      // 총 페이지의 갯수
	      p.setTotalPage(p.getTotalCount());
	      
	      // 요청되는 페이지
	      p.setPage(selectPage);
	      
	      // 시작, 끝 페이지 번호
	      p.setStartPage(selectPage);
	      p.setEndPage(selectPage);
	      
	      
	      // 게시글 가져오기
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("first", p.getPage()*p.getCountList()-(p.getCountList()-1));
	      map.put("last", p.getPage()*p.getCountList());
	      
	      List<BoardDto> lists = dao.pageList(map);
	      req.setAttribute("lists", lists);
	      
	      // Paging 객체 startPage; endPage
	      req.setAttribute("page", p);
	      
	      req.getRequestDispatcher("/allBoardPage.jsp").forward(req, resp);
	      

	}

}
