package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.BikeDto;
import com.min.edu.model.BikeDaoImpl;
import com.min.edu.model.IBikeDao;

public class BikeController extends HttpServlet {

	private static final long serialVersionUID = -1004121868493936836L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");
		logger.info("요청받은 command : "+command);
		
		if(command.trim().equalsIgnoreCase("first")) {
			resp.sendRedirect("./bikeview/bike01.jsp");
		} else if(command.trim().equalsIgnoreCase("second")) {
			req.getRequestDispatcher("/WEB-INF/views/bike/bike02.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String command = req.getParameter("command");
		System.out.println("요청받은 doPost값 : "+command);
		
		if(command.equalsIgnoreCase("first_db")) {
			String[] bikes = req.getParameterValues("bike");
			List<BikeDto> dtos = new ArrayList<BikeDto>();
			for (String bike : bikes) {
				int idx = 0;
				String[] temp = bike.split("/");
				// 광진구/500/어린이대공원역 3번출구 앞/10/37.54707/127.074272/화양동 169-1
				// 화양동 169-1/500/광진구/127.074272/10/37.54707/어린이대공원역 3번출구 앞"
				BikeDto dto = new BikeDto(temp[idx++], 
						Integer.parseInt(temp[idx++]), 
						temp[idx++], 
						Double.parseDouble(temp[idx++]), 
						Integer.parseInt(temp[idx++]), 
						Double.parseDouble(temp[idx++]), 
						temp[idx++]);
				dtos.add(dto);
			}
			IBikeDao dao = new BikeDaoImpl();
			int cnt = dao.bikeInsert(dtos);
			if(cnt>0) {
				logger.info("DB 저장에 성공하였습니다.");
			} else {
				logger.info("DB 저장에 실패하였습니다.");				
			}
		}
	}
}
