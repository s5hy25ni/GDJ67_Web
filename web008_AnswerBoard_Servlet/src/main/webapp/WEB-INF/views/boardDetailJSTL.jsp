<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<table class="table table-condensed">
			<tr>
				<th class="info">아이디</th>
				<td>${dto.id}</td>
			</tr>
			<tr>
				<th class="info">제목</th>
				<td>${dto.title}</td>
			</tr>
			<tr>
				<th class="info">내용</th>
				<td>${dto.content}</td>
			</tr>
			<tr>
				<th class="info">등록일</th>
				<td>${dto.regdate}</td>
			</tr>
		</table>
 		<div class="btn-group btn-group-justified">
			<c:if test="${empty loginVo && (loginVo.auth eq A || login.id eq dto.id)}">
				<div class="btn-group">
					<button type="button" class="btn btn-primary"
						onclick="del('${dto.seq}')">삭제</button>	
				</div>	
			</c:if>
			<c:if test="${empty loginVo && loginVo.id eq dto.id}">
				<div class="btn-group">
					<button type="button" class="btn btn-primary"
						onclick="modify('${dto.seq}')">수정</button>	
				</div>			
			</c:if>
			<div class="btn-group">
				<button type="button" class="btn btn-primary"
					onclick="reply('${dto.seq}')">답글</button>	
			</div>
		</div>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</body>
</html>