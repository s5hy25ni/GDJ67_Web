package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.EmpDaoImpl;
import com.min.edu.dao.IEmpDao;
import com.min.edu.dto.Emp_Dto;

public class EmpListServlet extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String reqName = req.getParameter("name");
      System.out.println("get 요청이 되었습니다 : " + reqName);
      
      IEmpDao dao = new EmpDaoImpl();
      List<Emp_Dto> lists = dao.getAllEmp();
      
      req.setAttribute("lists", lists);
      
      RequestDispatcher dispatcher = req.getRequestDispatcher("/empLists.jsp");
      dispatcher.forward(req, resp);
   }
   
}
