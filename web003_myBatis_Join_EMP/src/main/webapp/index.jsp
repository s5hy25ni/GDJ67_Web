<%@page import="com.min.edu.dto.Dept_DTO5"%>
<%@page import="com.min.edu.dto.Dept_DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company</title>
</head>
<body>
	<button onclick="javascript:location.href='./joinCtrl.do'">결과 확인</button>
	<%
		List<Dept_DTO> lists02 = (List<Dept_DTO>)request.getAttribute("lists02");
	%>
	<%
		if(lists02 != null) {
	%>
	<fieldset>
		<legend>Join02</legend>
		<div>
			<div>총 갯수 : <%=lists02.size() %></div>
		</div>
	</fieldset>
	<%
		List<Dept_DTO> lists03 = (List<Dept_DTO>)request.getAttribute("lists03");
	%>
	<fieldset>
		<legend>Join03</legend>
		<div>
			<div>총 갯수 : <%=lists03.size() %></div>
			<div>0번째 : <%=lists03.get(0) %></div>
		</div>
	</fieldset>
	<%
		List<Dept_DTO5> lists05 = (List<Dept_DTO5>)request.getAttribute("lists05");
	%>
	<fieldset>
		<legend>Join05</legend>
		<div>
			<div>총 갯수 : <%=lists05.size() %></div>
			<div>0번째 : <%=lists05.get(0) %></div>
		</div>
	</fieldset>
	<%
		}
	%>
</body>
</html>