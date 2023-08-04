<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.UserDto"%>
<%@page import="com.min.edu.dao.UserDaoImpl"%>
<%@page import="com.min.edu.dao.IUserDao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
<%
	String cmd = request.getParameter("command");
	System.out.println("요청받은 command 값 : "+cmd);
	
	IUserDao dao = new UserDaoImpl();
	
	if(cmd == null || cmd == ""){
		response.sendRedirect("./error.jsp");
	} else if(cmd.equalsIgnoreCase("login")){
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.printf("%s / %s", id, password);
		
		Map<String, Object> inmap = new HashMap<String, Object>();
		inmap.put("id", id);
		inmap.put("password", password);
		
		UserDto loginDto = dao.getLogin(inmap);
		
		//TODO 001 MyBatis의 결과는 객체를 반환
		// 결과가 없을 경우 null로 반환하여 로그인이 실패했음을 script를 통해 알려줌
		if(loginDto != null){
			System.out.println("로그인 성공");
			
			//TODO 002 request scope의 범위 연습
			/* request.setAttribute("loginDto", loginDto); */
			
			// 흐름제어는 redirect(연결만), forward(req,resp)
			/* response.sendRedirect("./adminMain.jsp"); */
			
			// RequestDispatcher
			// RequestDispatcher dispatcher = request.getRequestDispatcher("이동페이지").forward(req, resp);
			/* pageContext.forward("./adminMain.jsp"); */
			
			//TODO 003 session scope의 범위 연습
			// Session session = request.getSession();
			// session.setAttribute("name", Object);
			
			session.setAttribute("loginDto", loginDto);
			session.setMaxInactiveInterval(60*10);
			if(loginDto.getAuth().equalsIgnoreCase("ADMIN")){
				response.sendRedirect("./adminMain.jsp");				
			} else if(loginDto.getAuth().equalsIgnoreCase("USER")){
				response.sendRedirect("./userMain.jsp");
			}
			
			
			
		} else {
			%>
			<script type="text/javascript">
				alert("아이디와 비밀번호를 확인하세요.");
				location.href="./index.jsp";
			</script>
			<%
		}
	} else if(cmd.equalsIgnoreCase("logout")) {
		session.invalidate();
		response.sendRedirect("./index.jsp");
	} else if(cmd.equalsIgnoreCase("getAllUserStatus")){
		List<UserDto> lists = dao.getAllUserStatus();
		request.setAttribute("lists", lists);
		pageContext.forward("./userListStatus.jsp");
	} else if(cmd.equalsIgnoreCase("getAllUser")){
		List<UserDto> lists = dao.getAllUser();
		request.setAttribute("lists", lists);
		pageContext.forward("./userList.jsp");
	} else if(cmd.equalsIgnoreCase("updateAuthForm")){
		String seq = request.getParameter("seq");
		UserDto dto = dao.getUserInfo(seq);
		request.setAttribute("dto", dto);
		pageContext.forward("./updateAuthForm.jsp");
	} else if(cmd.equalsIgnoreCase("updateAuth")) {
		String seq = request.getParameter("seq");
		String role = request.getParameter("role");
		System.out.println("seq : "+seq+" role : "+role);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("auth", role);
		map.put("seq", seq);
		
		int n = dao.updateAuthUser(map);
		
		if(n>0){
			response.sendRedirect("./userController.jsp?command=getAllUser");
		} else {
			response.sendRedirect("./userController.jsp?command=updateAuthFrom&seq="+seq);
		}
	} else if(cmd.equalsIgnoreCase("getUserInfo")){
		String seq = String.valueOf(((UserDto)session.getAttribute("loginDto")).getSeq());
		System.out.println("seq : "+seq);
		UserDto dto = dao.getUserInfo(seq);
		request.setAttribute("dto", dto);
		pageContext.forward("./userInfo.jsp");
	} else if(cmd.equalsIgnoreCase("modify")){
		String seq = String.valueOf(((UserDto)session.getAttribute("loginDto")).getSeq());
		System.out.println("seq : "+seq);
		UserDto dto = dao.getUserInfo(seq);
		request.setAttribute("dto", dto);
		pageContext.forward("./updateForm.jsp");
	} else if(cmd.equalsIgnoreCase("updateUser")){
		String seq = String.valueOf(((UserDto)session.getAttribute("loginDto")).getSeq());
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		System.out.printf("%s, %s, %s, %s \n", seq, address, phone, email);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq",seq);
		map.put("address",address);
		map.put("phone",phone);
		map.put("email",email);
		
		int n = dao.updateUserInfo(map);
		
		if(n>0){
			response.sendRedirect("./userController.jsp?command=getUserInfo");
		} else {
			response.sendRedirect("./error.jsp");
		}
	} else if(cmd.equalsIgnoreCase("delUser")){
		String seq = String.valueOf(((UserDto)session.getAttribute("loginDto")).getSeq());
		dao.delUser(seq);
		int n = dao.delUser(seq);
		if(n>0){
			response.sendRedirect("./userController.jsp?command=logout");
		} else {
			response.sendRedirect("./error.jsp");
		}
	} else if(cmd.equalsIgnoreCase("insertUser")){
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		System.out.printf("%s, %s, %s, %s, %s, %s", id, password, name, address, phone, email);
		
		UserDto dto = new UserDto(id, password, name, address, phone, email);
		int n = dao.insertUser(dto);
		if(n==1){
			response.sendRedirect("./index.jsp");
		} else {
			response.sendRedirect("./resistForm.jsp");
		}
				
		
	} else if(cmd.equalsIgnoreCase("idChk")){
		String id = request.getParameter("id");
		int n = dao.duplicateId(id);
		boolean isc = false;
		if(n==1){
			isc = true;
		}
		response.sendRedirect("./idChk.jsp?isc="+isc);
	}
%>
</html>