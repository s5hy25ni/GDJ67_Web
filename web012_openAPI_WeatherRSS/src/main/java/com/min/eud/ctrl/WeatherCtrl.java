package com.min.eud.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherCtrl extends HttpServlet{

	private static final long serialVersionUID = 6322478711502198791L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("사용되는 Protocol : {}", "doGet");
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("사용되는 Protocol : {}", "doPost");
		doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {		
		logger.info("사용되는 처리 메소드 : {}", "doProcess");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String code = req.getParameter("zone");
		logger.info("전달 받은 요청 값 : {}", code);
		PrintWriter out = resp.getWriter();
		
		//TODO 1) 일반 문자열로 보냄
//		out.print("ajax로 보냄"); // text, text(JSON), JSONobject(text)
		
		//TODO 2) JSON 형태의 문자열로 보내줌 
//		out.print("{\"rdata\":\"ajax로 보냄\"}");
		
		//TODO 3) JSON 라이브러리를 사용하여 보냄
//		JSONObject obj = new JSONObject();
//		obj.put("rdata", "클레오파트라");
//		System.out.println("object : "+obj.toString());
//		out.print(obj.toString()); // dataType이 text
		
		//TODO 4) JSON 라이브러리를 사용해서 Map 객체를 전송
		Map<String, String> map = new HashMap<String, String>();
		map.put("rdata", "test");
		JSONObject obj = new JSONObject(map);
		out.print(obj.toString());
		
		// 기상청 RSS를 호출하고 값을 text의 형태로 변경하는 JSP로 만듦
		req.setAttribute("zone", code);
		req.getRequestDispatcher("/weatherInfo.jsp").forward(req, resp);
	}
	
}
