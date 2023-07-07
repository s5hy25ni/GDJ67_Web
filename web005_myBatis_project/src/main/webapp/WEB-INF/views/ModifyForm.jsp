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
	<h1>수정하기</h1>
	<hr>
	<form action="./setUpdateBoard.do" method="POST">
		<table>
			<tbody>
				<tr>
					<th>작성자</th>
					<td><%=one.getWriter()%></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><%=one.getTitle()%></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" required="required"><%=one.getContent()%></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="seq" value="<%=one.getSeq()%>">
		<input type="submit" value="수정하기">
		<input type="button" onclick="location.href='./getOneBoard.do?seq=<%=one.getSeq()%>'" value="취소">
	</form>
</body>
</html>