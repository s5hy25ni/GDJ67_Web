<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 페이지 서버의 주소란?</title>
</head>
<body>
	<fieldset>
		<legend>서버 주소</legend>
		<ul>
			<li>request.getContextPath() : <%=request.getContextPath()%></li>
			<li>request.getRequestURI() : <%=request.getRequestURI()%></li>
			<li>request.getRequestURL() : <%=request.getRequestURL()%></li>
		</ul>
	</fieldset>
	<h3><a href="./bikeCtrl.do?command=first">첫 번째 방법</a></h3>
	<h3><a href="<%=request.getRequestURL()%>bikeCtrl.do?command=second">두 번째 방법</a></h3>
</body>
</html>