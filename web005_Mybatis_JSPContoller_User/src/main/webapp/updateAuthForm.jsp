<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등급 변경</title>
</head>
<%
	UserDto dto = (UserDto)request.getAttribute("dto");
%>
<%@include file="adminMain.jsp"%>
<body>
	<h1>회원등급변경하기</h1>
	<form action="./userController.jsp" method="post">
		<input type="hidden" name="command" value="updateAuth">
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
		<table>
	      <tr>
	         <th>seq번호</th>
	         <td><%=dto.getSeq() %></td>
	      </tr>
	      <tr>
	         <th>ID</th>
	         <td><%=dto.getId() %></td>
	      </tr>
	      <tr>
	         <th>Name</th>
	         <td><%=dto.getName() %></td>
	      </tr>
	      <tr>
	         <th>Auth</th>
	         <td>
	         	<select name="role">
	         		<option value="ADMIN" <%=dto.getAuth().equalsIgnoreCase("ADMIN")?"selected":""%> >관리자</option>
	         		<option value="USER" <%=dto.getAuth().equalsIgnoreCase("USER")?"selected":""%> >사용자</option>
	         	</select>
	         </td>
	      </tr>
	      <tr>
	      	<th colspan="2">
	      		<input type="submit" value="등급변경">
	      	</th>
	      </tr>
		</table>
	</form>
</body>
</html>