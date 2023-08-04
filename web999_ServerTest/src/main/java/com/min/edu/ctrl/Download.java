package com.min.edu.ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.model.BoardPageImpl;
import com.min.edu.model.IBoardPage;
import com.min.edu.vo.FileVo;
import com.min.edu.vo.PageVo;

public class Download extends HttpServlet{

	private static final long serialVersionUID = 5579897776186058033L;
	private Logger logger = LoggerFactory.getLogger(Download.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String bSeq = req.getParameter("seq");
		logger.info(">>>>>>>>>> Download doGet : {}", bSeq);
		
		IBoardPage dao = new BoardPageImpl();
		FileVo fVo = dao.getFname(bSeq);
		
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("/upload");
		System.out.println(path);
		String filePath = path+"/"+fVo.getStoredFname();
		
		FileInputStream in = null;
		ServletOutputStream out = null;
		
		try {
			File file = new File(filePath);
			byte[] b = new byte[(int)file.length()];
			
			resp.reset();
			resp.setContentType("application/octet-stream");
			
			String encoding = new String(fVo.getOriginFname().getBytes("UTF-8"), "8859_1");
			resp.setHeader("Content-Disposition", "attachment; filename="+encoding);
			
			in = new FileInputStream(file);
			out = resp.getOutputStream();
			
			int numRead = 0;
			while((numRead = in.read(b,0,b.length))!=-1) { // 객체, 0부터, 끝까지
				out.write(b,0,numRead);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
			in.close();
		}
	}
}
