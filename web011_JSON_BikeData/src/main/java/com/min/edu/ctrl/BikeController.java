package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
		} else {
			// method : POST
			// url : bikeCtrl.do
			// data : obj stringify(json 객체)
			logger.info("second_db 들어옴");
			
			String jsonObj = req.getParameter("obj"); // ajax data 항목
			logger.info("json String : "+jsonObj);
			
			JsonElement element = JsonParser.parseString(jsonObj);
			logger.info("json Element : " + element);
			
			int len = element.getAsJsonObject().get("DATA").getAsJsonArray().size();
			logger.info("JSON Element의 갯수 : "+len);
			
			String new_addr = element.getAsJsonObject().get("DATA").getAsJsonArray().get(0).getAsJsonObject().get("NEW_ADDR").getAsString();
								//{"DE~":"","DATA":""} // "DATA":"" //[{0},{1},...] // {0} //{"NEW_ADDR":"값",..." // {"NEW_ADDR":"값"} // 값
			logger.info("new_addr : "+new_addr);
			
			List<BikeDto> dtos = new ArrayList<BikeDto>();
			for(int i=0; i<len; i++) {
				JsonObject temp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
				JsonElement t1 = temp.get("NEW_ADDR");
				JsonElement t2 = temp.get("CONTENT_ID");
				JsonElement t3 = temp.get("ADDR_GU");
				JsonElement t4 = temp.get("LONGITUDE");
				JsonElement t5 = temp.get("CRADLE_COUNT");
				JsonElement t6 = temp.get("LATITUDE");
				JsonElement t7 = temp.get("CONTENT_NM");
				
				BikeDto dto = new BikeDto(t1.getAsString(), t2.getAsInt(), t3.getAsString(), t4.getAsDouble(), t5.getAsInt(), t6.getAsDouble(), t7.getAsString());
				
				dtos.add(dto);
			}
			
			IBikeDao dao = new BikeDaoImpl();
			dao.bikeDelete();
			int n = dao.bikeInsert(dtos);
			if(n>0) {
				System.out.println("DB 입력 성공");
			} else {
				System.out.println("DB 입력 실패");
			}
			
			resp.getWriter().print(n);
			// JSON 형태의 문자열로 전송하면 많은 값을 key:value 형태로 전송할 수 있다.
//			resp.getWriter().print("{\"isc\":\""+n+"\"}");
			
		}
	}
}
