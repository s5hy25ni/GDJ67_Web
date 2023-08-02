package com.min.edu.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.model.CalboardDaoImpl;
import com.min.edu.model.ICalboardDao;

import net.sf.json.JSONObject;

public class CalListAjax extends HttpServlet {

	private static final long serialVersionUID = 8350248535300711807L;
	private Logger logger = LoggerFactory.getLogger(CalListAjax.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		String yyyymmdd = req.getParameter("yyyymmdd");
		
		logger.info("Ajax 전달 id {}, yyyymmdd {}", id, yyyymmdd);
		
		// dao 실행
		Map<String, Object> iMap = new HashMap<String, Object>();
		iMap.put("id", id);
		iMap.put("yyyymmdd", yyyymmdd);
		
		ICalboardDao dao = new CalboardDaoImpl();
		int n = dao.getCalCount(iMap);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// return JSON 형태의 문자열
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("calCount", n);
		
		// map을 자동으로 JSON으로 변환
		JSONObject obj = JSONObject.fromObject(map);
		System.out.println(obj.toString());
		
		PrintWriter out =resp.getWriter();
		out.print(obj);
	}
}
