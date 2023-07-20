<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/index.css">
</head>
<%
	UserDto dto = (UserDto)session.getAttribute("loginInfo");
%>
<body>
	<header>
		<div id="left">
			<div id="menu1"><a href="./boardPage.do">게시물조회</a></div>
			<%
				if(dto != null && dto.getAuth().equalsIgnoreCase("A")){
					%>
					<div id="menu2"><a href="./userList.do">회원조회</a></div>			
					<%
				}
			%>
		</div>
		<div id="right">
			<%
				if(dto == null){
					%>
						<form action="./login.do" method="post">
							<input type="text" name="id">
							<input type="password" name="pw">		
							<input type="submit" class="btn" value="로그인">
						</form>
					<%
				} else {
					%>
						<input type="button" class="btn" value="로그아웃" onclick="location.href='./login.do'">
					<%
				}
			%>
		</div>
	</header>
</body>
</html>