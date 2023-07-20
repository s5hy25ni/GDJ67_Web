package com.min.eud.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Webtoon extends HttpServlet {

	private static final long serialVersionUID = 2142867866029000556L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String url ="https://comic.naver.com/webtoon/detail?titleId=650305&no=393";
		
		Document doc = Jsoup.connect(url).timeout(3000).get();
		Elements ele = doc.select("#comic_view_area");
		Elements ele1 = ele.select("div>img");
		
		List<Object> wLists = new ArrayList<Object>();
		
		System.out.println(ele1.size());
		for(Element el : ele1) {
//			System.out.println(el.attr("src")); // 주소만 가져오기
			wLists.add(el);
		}
		System.out.println(wLists);
		req.setAttribute("wLists", wLists);
		req.getRequestDispatcher("/myWebtoon.jsp").forward(req, resp);
	}
}
