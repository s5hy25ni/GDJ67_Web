package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.Dept_DTO;
import com.min.edu.dto.Dept_DTO5;
import com.min.edu.model.CompanyDaoImpl;
import com.min.edu.model.ICompanyDao;

public class MyBatisJoinController extends HttpServlet {

	private static final long serialVersionUID = -5363030570604979040L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ICompanyDao dao = new CompanyDaoImpl();
		
		List<Dept_DTO> lists02 = dao.joinCombine02();
		req.setAttribute("lists02", lists02);
		
		List<Dept_DTO> lists03 = dao.joinCombine03();
		req.setAttribute("lists03", lists03);
		
		List<Dept_DTO5> lists05 = dao.joinCombine05();
		req.setAttribute("lists05", lists05);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);

	}
	
}
