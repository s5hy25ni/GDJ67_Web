package com.min.edu.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("~~~어플리케이션 종료~~~");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("###어플리케이션 시작###");
		ServletContext context = sce.getServletContext();
		System.out.println("애플리케이션 서버 정보 : "+context.getServerInfo());
	}
}
