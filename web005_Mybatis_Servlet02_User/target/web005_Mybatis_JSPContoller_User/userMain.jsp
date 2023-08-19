<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 페이지</title>
</head>
<body>
	<%
		UserDto loginDto = (UserDto)session.getAttribute("loginDto");
	%>
	<h1>사용자 페이지</h1>
	<div>
		<span><%=loginDto.getName()%> 님 반갑습니다.</span>
		<p>-<%=loginDto.getAuth().equalsIgnoreCase("USER")?"사용자":"관리자"%>-</p>
	</div>
	<div>
		<div>
			<a href="./userController.jsp?command=logout">로그아웃</a>
			<a href="./userController.jsp?command=getUserInfo">마이페이지</a>
		</div>
	</div>
</body>
</html>