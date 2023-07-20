package com.min.eud.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupCtrl extends HttpServlet {

	private static final long serialVersionUID = -2678401893349645891L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String url="https://simplehtmldom.sourceforge.io/";
		// 처리 방식이 get
		Document doc = Jsoup.connect(url).get();
//		System.out.println(doc);
//		System.out.println(doc.html()); // document의 HTML+TEXT
//		System.out.println(doc.text()); // document의 TEXT
		Elements ele1 = doc.select("#php-simple-html-dom-parser");
//		Elements ele2 = doc.select(".content");
//		Elements ele3 = doc.select("ul");
		System.out.println(ele1.size());
		
		for(Element el : ele1) {
			System.out.println(el.text());
		}
	}
}
