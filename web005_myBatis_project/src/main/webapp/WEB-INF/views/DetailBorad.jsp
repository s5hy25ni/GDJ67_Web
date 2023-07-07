<%@page import="com.min.edu.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	BoardDto one = (BoardDto)request.getAttribute("one");
%>
<body>
	<h1>[<%=one.getSeq()%>] <%=one.getTitle()%></h1>
	<hr>
	<p>작성자		: <%=one.getWriter()%></p>
	<p>작성 시간	: <%=one.getRegdate()%></p>
	<hr>
	<pre>
		<%=one.getContent()%>
	</pre>
	<input type="button" onclick="location.href='./setUpdateBoard.do?seq=<%=one.getSeq()%>'" value="수정">
	<input type="button" onclick="location.href='./setDeleteBoard.do?seq=<%=one.getSeq()%>'" value="삭제">
	<input type="button" onclick="location.href='./getAllBoard.do'" value="전체글 조회">
</body>
</html>