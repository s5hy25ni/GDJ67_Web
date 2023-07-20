<%@page import="com.min.edu.dto.AnswerboardDto"%>
<%@page import="com.min.edu.dto.UserVo"%>
<%@page import="com.min.edu.dto.AnswerboardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
</head>
	<%	 
			AnswerboardDto dto = (AnswerboardDto)request.getAttribute("dto");
			UserVo loginVo = (UserVo)session.getAttribute("loginInfo");
	%>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<table class="table table-condensed">
			<tr>
				<th class="info">아이디</th>
				<td><%=dto.getId()%></td>
			</tr>
			<tr>
				<th class="info">제목</th>
				<td><%=dto.getTitle()%></td>
			</tr>
			<tr>
				<th class="info">내용</th>
				<td><%=dto.getContent()%></td>
			</tr>
			<tr>
				<th class="info">등록일</th>
				<td><%=dto.getRegdate()%></td>
			</tr>
		</table>
		<div class="btn-group btn-group-justified">
		
			<%
				if(loginVo != null && (loginVo.getAuth().equalsIgnoreCase("A") || loginVo.getId().equals(dto.getId()))){
					%>
					<div class="btn-group">
						<button type="button" class="btn btn-primary"
							onclick="del('<%=dto.getSeq()%>')">삭제</button>	
					</div>					
					<%
				}
			%>
			
			<%
				if(loginVo != null && loginVo.getId().equals(dto.getId())){
					%>
					<div class="btn-group">
						<button type="button" class="btn btn-primary"
							onclick="modify('<%=dto.getSeq()%>')">수정</button>	
					</div>
					<%
				}
			%>
			<div class="btn-group">
				<button type="button" class="btn btn-primary"
					onclick="reply('<%=dto.getSeq()%>')">답글</button>	
			</div>
		</div>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>