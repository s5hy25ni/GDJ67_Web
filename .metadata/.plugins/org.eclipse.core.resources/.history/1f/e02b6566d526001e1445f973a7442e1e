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
import com.min.edu.dto.UserDto;
import com.min.edu.model.BoardPageImpl;
import com.min.edu.model.IBoardPage;
import com.min.edu.model.IUser;
import com.min.edu.model.UserImpl;

public class UserList extends HttpServlet {

	private static final long serialVersionUID = -3000073987543223252L;
	
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

		logger.info("user doProcess");
		IUser dao = new UserImpl();

		String page = req.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int selectPage = Integer.parseInt(page);
		logger.info("$$$ 현재 페이지 $$$" + selectPage);

		Paging p = new Paging();

		p.setTotalCount(dao.getMyUser());
		p.setCountList(5);
		p.setCountPage(5);
		p.setTotalPage(p.getTotalCount());
		p.setPage(selectPage);
		p.setStartPage(selectPage);
		p.setEndPage(selectPage);

		// 유저 가져오기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", p.getPage() * p.getCountList() - (p.getCountList() - 1));
		map.put("last", p.getPage() * p.getCountList());
		logger.info(map.get("first"));
		logger.info(map.get("last"));
		List<UserDto> lists = dao.allUser(map);
		req.setAttribute("lists", lists);

		// Paging 객체 startPage; endPage
		req.setAttribute("page", p);

		req.getRequestDispatcher("/allUserPage.jsp").forward(req, resp);
	      

	}
}
