<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나만의 웹툰</title>
<style type="text/css">
	br{
		margin: 0px;
	}
	
	img{
		width: 300px;
		height: auto;
		margin-top: -4px;
		margin-bottom: 0px;
	}
</style>
</head>
<body>
	<c:forEach var="w" items="${wLists}">
		${w}<br>
	</c:forEach>
</body>
</html>