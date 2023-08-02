package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.BoardDto2;
import com.min.edu.dto.Paging;
import com.min.edu.model.BoardImpl;
import com.min.edu.model.IBoard;

import net.sf.json.JSONObject;

public class FileDetail extends HttpServlet {

	private static final long serialVersionUID = 6810429168988835194L;
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		logger.info(">>>>>>>>>>>>>>>>>>>>>> FileDetail doGet");
		String seq = req.getParameter("seq");
		
		IBoard dao = new BoardImpl();
		
		Paging p = new Paging();
		p.setTotalCount(dao.getRCnt(seq));
		p.setCountList(3);
		p.setCountPage(5);
		p.setTotalPage(p.getTotalCount());
		
		String page = req.getParameter("page");
		boolean first = false;
		if(page == null) {
			page = String.valueOf(p.getTotalPage());
			first = true;
		}
		int selectPage = Integer.parseInt(page);
		p.setPage(selectPage);
		p.setStartPage(1);
		p.setEndPage(1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("start", p.getPage()*p.getCountList()-(p.getCountList()-1));
		map.put("end", p.getPage()*p.getCountList());
		BoardDto2 bDto = dao.getOneBoard(map);

		if(first && bDto != null) {
			req.setAttribute("bDto", bDto);
			req.setAttribute("page", p);
			req.getRequestDispatcher("/WEB-INF/views/fileOne.jsp").forward(req, resp);
		} else {
			Map<String, Object> send = new HashMap<String, Object>();
			send.put("bDto", bDto);
			send.put("page", p);
			JSONObject obj = JSONObject.fromObject(send);

			resp.getWriter().print(obj);
		}
	}
	
}
