<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--TODO 008 request 요청, parameter/attibute
	HttpServletRequest는 pass by reference로 전달되어 값을 담고 또다른 JSP 전달 => HTML 구성
 --%>
 <%
 	String name = request.getParameter("name");
 	String nickName = request.getParameter("nickname");
 	String val = (String)request.getAttribute("val");
 %>
</body>
	<h1>parameter <%=name%></h1>
	<h1>parameter <%=nickName%></h1>
	<h1>Attribute <%=val%></h1>
</html>