package com.min.edu.ctrl;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.dto.CalendarDto;
import com.min.edu.model.CalboardDaoImpl;
import com.min.edu.model.ICalboardDao;
import com.min.edu.util.CalendarUtil;

public class CalController extends HttpServlet {

	private static final long serialVersionUID = 6483701772520000145L;
	private Logger logger = LoggerFactory.getLogger(CalController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		ICalboardDao dao = new CalboardDaoImpl();
		
		String command = req.getParameter("command");
		logger.info(">>>>> command: {}", command);
		
		if(command.equalsIgnoreCase("sessionDel")) {
			logger.info(">>>>>>>>>> 세션 삭제");
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect("./");
		} else if(command.equalsIgnoreCase("calList")) {
			
			String year = req.getParameter("year");
			String month = String.format("%2s", req.getParameter("month")).replace(" ", "0");
			String date = String.format("%2s", req.getParameter("date")).replace(" ", "0");
			
			logger.info(">>>>>>>>>> calList : {}, {}, {}", year, month, date);
			
			HttpSession session = req.getSession();
			String id = (String)session.getAttribute("id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("yyyymmdd", year+month+date);
			List<CalendarDto> lists = dao.getCalList(map);
			
			req.setAttribute("lists", lists);
			req.getRequestDispatcher("./calList.jsp").forward(req, resp);
		} else if(command.equalsIgnoreCase("calForm")) {
			String year = req.getParameter("year");
			String month = req.getParameter("month");
			String date = req.getParameter("date");
			logger.info(">>>>>>>>>> calForm : {}, {}, {}", year, month, date);
						
			Calendar cal = new GregorianCalendar();
			cal.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(date));
			int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);
			minute = (minute/10)*10;

			req.setAttribute("maxDay", maxDay);
			req.setAttribute("hour", hour);
			req.setAttribute("minute", minute);
			req.getRequestDispatcher("./calForm.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		ICalboardDao dao = new CalboardDaoImpl();
		
		String command = req.getParameter("command");
		logger.info(">>>>> command: {}", command);
		
		if(command.equalsIgnoreCase("calendar")) {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			logger.info(">>>>>>>>>> calendar : {}, {}", id, name);
			
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);

			logger.info(">>>>>>>>>>>>>>> 세션 저장 아이디 : {}, 성명 : {}", session.getAttribute("id"), session.getAttribute("name"));
			
			resp.sendRedirect("./calendar.jsp");
		} else if(command.equalsIgnoreCase("calInsert")) {			
			HttpSession session = req.getSession();
			String id = (String)session.getAttribute("id");
			String year = req.getParameter("year");
			String month = req.getParameter("month");
			month = CalendarUtil.iTwoWord(Integer.parseInt(month));
			String date = req.getParameter("date");
			date = CalendarUtil.iTwoWord(Integer.parseInt(date));
			String hour = req.getParameter("hour");
			hour = CalendarUtil.iTwoWord(Integer.parseInt(hour));
			String minute = req.getParameter("minute");
			minute = CalendarUtil.iTwoWord(Integer.parseInt(minute));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			logger.info(">>>>>>>>>> calInsert : {}, {}, {}, {}", id, year+month+date+hour+minute, title, content);
			CalendarDto dto = new CalendarDto(id, title, content, year+month+date+hour+minute);
			int n = dao.insertCalBoard(dto);
			if(n>0) {
				resp.sendRedirect("./calendar.jsp?year="+year+"&month="+month);
			}
		} else if(command.equalsIgnoreCase("getMaxDay")) {
			String month = req.getParameter("month");
			String year = req.getParameter("year");
			
			Calendar cal = new GregorianCalendar();
			cal.set(Integer.parseInt(year), Integer.parseInt(month)-1, 1);
			int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			resp.getWriter().print(maxDay);
		}
	}
}
