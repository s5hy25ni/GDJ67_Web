<%@page import="com.min.edu.dto.Emp_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<% 
		Object obj = request.getAttribute("lists");
		List<Emp_Dto> lists = (List<Emp_Dto>)obj;
	%>
<body>
	<h1>empLists 페이지 입니다.</h1>
	<%
		for(Emp_Dto dto : lists) {
							%>
			<%=dto %><br>
							<%
		}
	%>
</body>
</html>