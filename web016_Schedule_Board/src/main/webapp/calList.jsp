<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 리스트</title>
</head>
<jsp:useBean id="dateUtil" class="com.min.edu.bean.DatePattern" />
<%@ include file="header.jsp" %>
<body>
	<h2>일정 목록 보기</h2>
	<div id="container">
		<form action="./DelController.do" method="post" id="multiDelForm">
			<table class="table table-hover">
				<thead>
					<tr class="info">
						<th><input type="checkbox" onclick="allCheck(this.checked)"></th>
						<th>번호</th>
						<th>아이디</th>
						<th>제목</th>
						<th>일정</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty lists}">
							<tr>
								<td colspan="6"> -- 작성된 글이 없습니다 -- </td>
							</tr>
						</c:when>
						<c:otherwise>
							<input type="hidden" name="year" value="${fn:substring(lists[0].mdate,0,4)}">
							<input type="hidden" name="month" value="${fn:substring(lists[0].mdate,4,6)}">
							<input type="hidden" name="date" value="${fn:substring(lists[0].mdate,6,8)}">
							<c:forEach var="dto" items="${lists}" varStatus="vs">
								<tr>
									<td><input type="checkbox" name="chk" value="${dto.seq}"></td>
									<td>${fn:length(lists)-vs.index}</td>
									<td>${dto.id}</td>
									<td><a>${dto.title}</a></td>
									<td>
										<jsp:setProperty property="toDate" name="dateUtil" value="${dto.mdate}"/>
										<jsp:getProperty property="toDate" name="dateUtil"/>
									</td>
									<td>
										<fmt:parseDate var="regDate" value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
										<fmt:formatDate value="${regDate}" pattern="yyyy. MM. dd" />
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<input class="btn btn-block btn-danger" type="submit" value="다중삭제">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>