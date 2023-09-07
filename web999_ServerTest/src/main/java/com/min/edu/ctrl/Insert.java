package com.min.edu.ctrl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.model.BoardPageImpl;
import com.min.edu.model.IBoardPage;
import com.min.edu.vo.FileVo;
import com.min.edu.vo.RootVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Insert extends HttpServlet{

	private static final long serialVersionUID = -9217225259533858971L;
	private Logger logger = LoggerFactory.getLogger(Insert.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(">>>>>>>>>> Insert doGet");
		
		req.getRequestDispatcher("WEB-INF/views/writerBoard.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		String saveDirectory = context.getRealPath("upload");
		String encoding="UTF-8";
		
		MultipartRequest multi = new MultipartRequest(req, saveDirectory, 10 * 1024 * 1024, encoding, null);
		
		String id = multi.getParameter("id");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String originFname = multi.getOriginalFileName("originFname");
		logger.info(">>>>>>>>>> Insert doPost : {}, {}, {}, {}", id, title, content, originFname);
		RootVo rtVo = new RootVo(id, title, content);
		
		String storedFname = null;
		int fileSize = 0;
		FileVo fVo = null;
		
		if(originFname != null) {
			storedFname = UUID.randomUUID().toString().replace("-", "")+originFname.substring(0,originFname.lastIndexOf("."));
			fileSize = (int)multi.getFile("originFname").length();
			fVo = new FileVo(originFname, storedFname, fileSize);
			
			String systemFileName = multi.getFilesystemName("originFname");
			File oldFile = new File(saveDirectory+"/"+systemFileName);
			File newFile = new File(saveDirectory+"/"+storedFname);
			oldFile.renameTo(newFile);
			System.out.println(oldFile);
			System.out.println(newFile);
		}
		
		IBoardPage dao = new BoardPageImpl();
		boolean isc = dao.insertRoot(rtVo, fVo);
		
		if(isc) {
			resp.sendRedirect("./detail.do?seq="+rtVo.getSeq()+"&page=1");
		}
		
		
	}
}