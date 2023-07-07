package com.min.edu.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.comm.Comm;
import com.min.edu.dao.BoardDaoImpl;
import com.min.edu.dao.IBoardDao;

public class SetDeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardDao dao;
	private Logger logger = Logger.getLogger(SetDeleteBoard.class);

    public SetDeleteBoard() {
    	dao = new BoardDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("SetDeleteBoard doGet");
		String seq = request.getParameter("seq");
		boolean isc = dao.setDeleteBoard(seq);
		
		if(isc == true) {
			System.out.println(seq);
			response.sendRedirect("./getAllBoard.do");
		} else {
			response.sendRedirect("./setUpdateBoard.do?seq="+seq);
		}
	}

}
