package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.model.CalboardDaoImpl;
import com.min.edu.model.ICalboardDao;

public class DelController extends HttpServlet {

	private static final long serialVersionUID = -6375643503701051610L;
	private Logger logger = LoggerFactory.getLogger(DelController.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		ICalboardDao dao = new CalboardDaoImpl();

		logger.info(">>>>> DelController doPost");
		String[] chks = req.getParameterValues("chk");
		String year = req.getParameter("year");
		String month = req.getParameter("month");
		if (month.substring(0, 1).equals("0")) {
			month = month.replace("0", "");
		}
		String date = req.getParameter("date");
		if (date.substring(0, 1).equals("0")) {
			date = date.replace("0", "");
		}
		System.out.println("연월일 : " + year + month + date);
		boolean isc = dao.multiDel(chks); 
		if(isc) { 
			resp.sendRedirect("./CalController.do?command=calList&year="+year+"&month="+month+"&date="+date); 
		}
		
	}

}
