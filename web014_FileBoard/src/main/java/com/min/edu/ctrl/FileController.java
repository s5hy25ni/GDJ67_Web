package com.min.edu.ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.MultipartStream;

import com.min.edu.dto.BoardDto;
import com.min.edu.dto.FileBoardDto;
import com.min.edu.model.BoardFileImpl;
import com.min.edu.model.IBoardFile;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.MultipartParser;

public class FileController extends HttpServlet{

	private static final long serialVersionUID = 938871408338950278L;
	
	// 상세, 조회, 글작성, 다운로드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		System.out.println("doGet 실행");
		
		IBoardFile dao = new BoardFileImpl();
		
		String command = req.getParameter("command");
		System.out.println("요청받은 command : "+command);
		
		if(command.equalsIgnoreCase("boardList")) {
			List<BoardDto> lists = dao.getAllList();
			req.setAttribute("lists", lists);
			req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp);
			
		} else if(command.equalsIgnoreCase("detail")) {
			String seq = req.getParameter("seq");
			List<BoardDto> dtos = dao.getBoard(seq);
			req.setAttribute("dto", dtos.get(0));
			req.getRequestDispatcher("/WEB-INF/views/boardDetail.jsp").forward(req, resp);
		} else if(command.equalsIgnoreCase("boardWriteForm")) {
			req.getRequestDispatcher("/WEB-INF/views/boardWriteForm.jsp").forward(req, resp);
		} else  if(command.equalsIgnoreCase("download")) {
			String seq = req.getParameter("seq");
			System.out.println("요청 받은 seq값 : "+seq);
			
			FileBoardDto fDto = dao.getFile(seq);
			System.out.println(fDto);

			// 현재 저장 위치 : "C:\eclipse_web\workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\web014_FileBoard\\upload/b8abfbbf0c8044e598afa6042014f72a고라파덕"
			// 상대경로 : 
			ServletContext context = req.getServletContext();
			String path = context.getRealPath("/upload");
			String filePath = path + "/" + fDto.getStored_fname();
			
			System.out.println("물리적인 파일의 주소 : "+filePath);
			
			// filePath에 저장되어 있는 파일을 IO로 읽어서(InputStream) 브라우저에 보내준다(OutputStream)
			FileInputStream in = null;
			ServletOutputStream out = null;
			
			try {
				File file = new File(filePath); // 물리적인 공간에서 파일을 읽어옴
				System.out.println("읽어온 파일 : "+file);
				
				byte[] b = new byte[(int)file.length()];
				System.out.println("읽어온 파일 byte" + Arrays.toString(b));
				
				resp.reset(); // 브라우저로 응답할 때 header에 있는 정보를 초기화 함
				
				// MIME 타입
				// 전달하는 파일의 특성에 맞춰 header정보를 변경해줌
				// 어떤 타입인지 모를 경우 application/octet-stream (8byte 크기)
				// 만약에 타입을 알고 있다면 제공해주는 타입을 사용 ex) application/msword
				
				resp.setContentType("application/octet-stream");
				
				// 8859_1 : 1바이트에 해당하는 256개의 코드에 대해 유니코드(리터럴)로 만들어 줌
				// 파일명 인코딩
				String encoding = new String(fDto.getOrigin_fname().getBytes("UTF-8"), "8859_1");
				
				// 파일 다운로드 버튼을 눌렀을 때 서버에서 전송 받은 데이터를 어떻게 처리할지 브라우저에 알려줘야 함
				resp.setHeader("Content-Disposition", "attachment; filename="+encoding);
				
				in = new FileInputStream(file);
				out = resp.getOutputStream(); // req : 새로운 요청 페이지, resp : 요청 받은 페이지에 응답
				
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("doPost 실행");
		
		/* 
		 * 화면(view:HTML)의 form요소의 전송타입이 application/x-www-form-urlencode 라면 text만을 전송
		 * String writer = req.getParameter("writer"); String title =
		 * req.getParameter("title"); String filename = req.getParameter("filename");
		 * String content = req.getParameter("content");
		 * System.out.printf("%s %s %s %s", writer, title, filename, content);
		 */
		
		// 화면(view:HTML)의 form요소의 전송타입이 text와 data라면 multipart/form-data로 선언해야 함
		// server에서는 요청받은 request를 multipartRequest로 처리해줘야 한다.
		
		/*
		 *  절대경로(변하지 않는 주소)와 상대경로(변하는 주소)
		 *  절대경로 예시 : local의 특정 위치(window 기준 ex>c:\\upload\\)
		 *  상대경로 : WAS(tomcat)의 설치 위치 (Run > Run Configuration > tomcat > dtwp ~~~)
		 *  ※※※ 미리보기 혹은 refresh 없이(비동기식) 미리보기 하기 위해서는 상대경로 작업을 해야 함 
		 */
		
		/*
		 * MultiPartRequest의 필요값
		 * HttpServletRequest, saveDirectory(저장경로 절대/상대), maxPostSize(파일의 최댓값), Encoding, policy
		 */
		
		// 절대경로(서버는 리눅스, 역슬래시 XX)
		String saveDirectory = "C:\\eclipse_web\\workspace_web\\web014_FileBoard\\src\\main\\webapp\\upload";
		
		// 상대경로(context root)
		ServletContext context = req.getServletContext();
		String saveDirectory2 = context.getRealPath("upload");
		String saveDirectory3 = req.getServletContext()+"/upload";
		
		System.out.println("절대경로	: "+saveDirectory);
		System.out.println("상대경로1	: "+saveDirectory2);
		System.out.println("상대경로2	: "+saveDirectory3);
		
		int maxPostSize = 10 * 1024 * 1024; // 1kb -> 1MB -> 10MB
		String encoding = "UTF-8";
		
		// MultiPartRequest로 요청받은 Text와 Data를 받아와 객체로 만든다. RenamePolicy는 필요없음 어차피 이름 uuid로 변경
		MultipartRequest multi = new MultipartRequest(req, saveDirectory2, maxPostSize, encoding, new DefaultFileRenamePolicy());
		
		// 1) 전달받은 TEXT 받기
		String writer = multi.getParameter("writer");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String origin_fname = multi.getOriginalFileName("filename");
	
		System.out.printf("%s, %s, %s, %s \n", writer, title, content, origin_fname);
		
		
		
		// 2) 파일 업로드
		String stored_fname = null;
		int file_size = 0;
		FileBoardDto fDto = null;
		
		if(origin_fname != null) {
			// stored_fname : 파일이 서버에 저장될 때 중복되지 않는 이름을 만들어주고, 전달할때 기존의 이름과 맞춰서 사용
			stored_fname = UUID.randomUUID().toString().replace("-", "")+origin_fname.substring(0,origin_fname.lastIndexOf("."));
			file_size = (int)multi.getFile("filename").length();
			System.out.println("저장할 파일 명 : "+stored_fname);
			
			fDto = new FileBoardDto();
			fDto.setWriter(writer);
			fDto.setOrigin_fname(origin_fname);
			fDto.setStored_fname(stored_fname);
			fDto.setFile_size(file_size);
			
			System.out.println("최종 파일 : "+fDto);
		}
		
		BoardDto bDto = new BoardDto();
		bDto.setId(writer);
		bDto.setTitle(title);
		bDto.setContent(content);
		
		System.out.println("게시글 : "+bDto);
		
		// dao 실행
		IBoardFile dao = new BoardFileImpl();
		boolean isc = dao.insertBoard(bDto, fDto);
		
		File oldFile = new File(saveDirectory2+"/"+multi.getFilesystemName("filename"));
		File newFile = new File(saveDirectory2+"/"+stored_fname);
		oldFile.renameTo(newFile);
		
		if(isc) {
			resp.sendRedirect("./fileboard.do?command=boardList");
		} else {
			resp.getWriter().print("<script>alert('글입력실패');</script>");
		}
		
		resp.getWriter().print(isc);
	}
}
