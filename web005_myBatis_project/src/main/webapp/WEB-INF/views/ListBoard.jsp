<%@page import="com.min.edu.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListBoard</title>
</head>
<body>
	<h1>전체 게시글 조회</h1>
	<hr>
	<table>
		<col >
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<BoardDto> all = (List<BoardDto>)request.getAttribute("all");
				for(int i=0; i<all.size(); i++){
					%>
					<tr>
						<td><%=all.get(i).getSeq()%></td>
						<%if(all.get(i).getDelfalg().equalsIgnoreCase("y")){
							%>
							<td>삭제된 게시글입니다.</td>
							<%
						} else {
							%>
							<td><a href="./getOneBoard.do?seq=<%=all.get(i).getSeq()%>"><%=all.get(i).getTitle()%></a></td>
							<%
						}
						 %>
						<td><%=all.get(i).getWriter()%></td>
						<td><%=all.get(i).getRegdate()%></td>
					</tr>
					<%
				}
			%>
		</tbody>
	</table>
	<input type="button" onclick="location.href='./setInsertBoard.do'" value="새글작성">
</body>
</html>