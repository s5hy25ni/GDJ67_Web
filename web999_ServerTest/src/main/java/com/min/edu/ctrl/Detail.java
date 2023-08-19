package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.model.BoardPageImpl;
import com.min.edu.model.IBoardPage;
import com.min.edu.vo.PageVo;
import com.min.edu.vo.RootVo;

public class Detail extends HttpServlet{

	private static final long serialVersionUID = 3520908187435430286L;
	private Logger logger = LoggerFactory.getLogger(Detail.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		String page = req.getParameter("page");
		logger.info(">>>>>>>>>> Detail doGet : {}, {}", seq, page);

		IBoardPage dao = new BoardPageImpl();
		PageVo pVo = dao.getReplyCnt(seq);
		pVo.setCntReply(3);
		pVo.setCntPage(5);
		pVo.setTotalPage(0);
		pVo.setCurPage(Integer.parseInt(page));
		pVo.setStartPage(0);
		pVo.setEndPage(0);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("start", (pVo.getCurPage()-1)*pVo.getCntReply()+1);
		map.put("end", (pVo.getCurPage()-1)*pVo.getCntReply()+3);
		List<RootVo> rtVo = dao.getDetail(map);
		
		
		System.out.println(pVo);
		req.setAttribute("rtVo", rtVo.get(0));
		req.setAttribute("pVo", pVo);
		req.getRequestDispatcher("/WEB-INF/views/detailBoard.jsp").forward(req, resp);
	}
}
