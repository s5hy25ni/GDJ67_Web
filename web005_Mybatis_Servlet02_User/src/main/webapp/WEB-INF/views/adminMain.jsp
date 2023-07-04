<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<%
		// scriptlet 자바의 문법을 작성하는 영역
		Object obj = request.getAttribute("loginDto"); // 전달받은 객체의 name이 없으면 null
		UserDto loginDto = (UserDto)obj;
		
		UserDto sessionLoginDto = (UserDto)session.getAttribute("loginDto");
	%>
	전달받은 값 request : <%=loginDto%>
	전달받은 값 sessionLoginDto : <%=sessionLoginDto%>
	
	<h1>관리자 페이지</h1>
	<div>
		<span><%=sessionLoginDto.getName()%> 님 환영합니다.</span>
		<span>(등급:<%=sessionLoginDto.getAuth()%>)</span>
	</div>
	<div style="font-size:small;">
		<div>
			<a href="./loginLogout.servlet">로그아웃</a>
		</div>
		<div>
			<a href="./getAllUserStatus.servlet">회원상세정보 조회</a>
		</div>
		<div>
			<a href="./getAllUser.servlet">회원정보 조회(사용계정만)</a>
		</div>
	</div>
</body>
</html>