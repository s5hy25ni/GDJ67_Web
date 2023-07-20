<%@page import="com.min.edu.comm.PhotoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Board List 페이지</title>
</head>
<%@ include file="./header.jsp" %>
<body>
<!-- 요청 값 받기 -->
<c:set var="rows" value="${lists}" scope="page"/>
<jsp:useBean id="dp" class="com.min.edu.comm.DatePatternBean" scope="page" />
<jsp:useBean id="pp" class="com.min.edu.comm.PhotoBean" scope="page" />
	<div class="container">
    	<form action="./boardDelete.do" method="POST" onsubmit="return chkSubmit()">
	      	<table class="table table-hover">
	      		<thead>
	      			<tr class="info">
	      				<th><input type="checkbox" id="allCheck" onclick="checkAll(this.checked)" class="allCheckBox"></th>
	      				<th>연번</th>
	      				<th>아이디</th>
	      				<th>제목</th>
	      				<th>작성일</th>
	      			</tr>
	      		</thead>
	      		<tbody>
	      			<c:if test="${fn:length(rows) == 0}"> <!-- eq 0도 가능 -->
	      				<tr>
      						<td colspan="5" style="color:red; text-align:center;">-- 작성된 글이 존재하지 않습니다 --</td>
      					</tr>
	      			</c:if>
	      			<c:if test="${fn:length(rows) ne 0}">
	      				<c:forEach var="dto" items="${rows}" varStatus="vs">
	      					<tr>
	      						<td><input type="checkbox" name="ch" value="${dto.seq}"></td>
	      						<td>${fn:length(rows)-vs.index}</td>
	      						<td>${dto.id}</td>
      							<c:choose>
      								<c:when test="${fn:trim(dto.delflag) eq 'Y'}">
      									<td style="color:red; font-size:0.8em;">관리자에 의해 삭제되었습니다.</td>
      								</c:when>
      								<c:otherwise>
      									<td>
	      									<a href="./detailJSTL.do?seq=${dto.seq}">
	      										<jsp:setProperty property="depth" name="pp" value="${dto.depth}"/>
			      								<jsp:getProperty property="photo" name="pp"/>
		      									${dto.title}
		      								</a>
	      								</td>
      								</c:otherwise>
      							</c:choose>	      						
	      						<td>
	      							<fmt:parseDate var="patternDate" value="${dto.regdate}" pattern="yyyy-MM-dd"></fmt:parseDate>
	      							<fmt:formatDate value="${patternDate}" pattern="YYYY년도 MM월 DD일"/>
	      						</td>
	      					</tr>
	      				</c:forEach>
	      			</c:if>
	      		</tbody>
	      	</table>
	      </form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>