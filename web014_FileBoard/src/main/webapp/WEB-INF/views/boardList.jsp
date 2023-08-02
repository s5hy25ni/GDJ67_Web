<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록 조회</title>
<style type="text/css">
	table, tr, td, th{
		border: 1px solid #ccc;
		border-collapse: collapse;
		text-align: center;
	}
</style>
</head>
<body>
	<table>
		<col width="200px">
		<col width="200px">
		<col width="400px">
		<col width="200px">
		<thead>
			<tr>
				<th>연번</th>
				<th>아이디</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="d" items="${lists}" varStatus="vs">
				<tr>
					<td>${d.seq} / ${vs.count}</td>
					<td>${d.id}</td>
					<td><a title="${d.content}" href="./fileboard.do?command=detail&seq=${d.seq}">${d.title}</a></td>
					<td>${fn:substring(d.regdate,0,fn:indexOf(d.regdate, ' '))}</td>
				</tr>
			</c:forEach>
		</tbody>			
		<tfoot>
			<tr>
				<th colspan="4">
					<input type="button" value="새글쓰기" onclick="newWriter()">
				</th>
			</tr>
		</tfoot>
	</table>
</body>
<script type="text/javascript">
	function newWriter(){
		location.href="./fileboard.do?command=boardWriteForm";
	}
</script>
</html>