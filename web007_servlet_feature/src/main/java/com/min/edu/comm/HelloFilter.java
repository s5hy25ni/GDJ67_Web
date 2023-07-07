package com.min.edu.comm;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

public class HelloFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 2340754969684932600L;

	public void destroy() {
		System.out.println("Hello Filter destory");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Param flag = 2가 들어 오면 정상 흐름
		// 아니라면 모두가 errorpage로 처리한다
		HttpServletRequest req = (HttpServletRequest)request;
		String flag = req.getParameter("flag");
		if(flag.equals("2")) {			
			chain.doFilter(request, response);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/error404.html").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Hello filter Initial");
	}

}
