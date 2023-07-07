<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
forwardPage
<%
	String param = request.getParameter("name");
%>
<%=param%>
<hr>
${param.name}
</body>
</html>