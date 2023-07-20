package com.min.eud.ctrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherXMLCtrl extends HttpServlet {

	private static final long serialVersionUID = -3678421643520681101L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req, resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req, resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {
		logger.info("doProcess 요청");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1156055000";
		
		// 1) 접속
	 	Document doc = Jsoup.connect(url).get();
//		System.out.println(doc);
		
	 	// 2) 선택
		Elements ele1 = doc.select("body>data");
		System.out.println(ele1.size());
		
		// 3) 출력
		for (Element ele : ele1) {
			System.out.println(ele.select("hour").text()+"/"+ele.select("wfKor").text());
		}
		
		// 2) JSON 형태로 반환할 때
		URL u = new URL("url");
		HttpURLConnection conn = (HttpURLConnection)u.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.connect();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer();
		String line="";
		while ((line=br.readLine()) != null) {
			sb.append(line);
		}
		JSONObject obj = (JSONObject)new JSONParser().parse(sb.toString());
		
		obj.get("name");
	}
}
