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
<%@ include file="../../header.jsp" %>
<body>
<!-- 요청 값 받기 -->
<jsp:useBean id="dp" class="com.min.edu.comm.DatePatternBean" scope="page" />
<c:set var="rows" value="${lists}" scope="page"/>
	<div class="container">
		<div>
			${page}
		</div>
      	<table class="table table-hover">
      		<thead>
      			<tr class="info">
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
      						<td>${page.totalCount-((page.page-1)*page.countList)-vs.index}</td>
      						<td>${dto.id}</td>
     							<c:choose>
     								<c:when test="${fn:trim(dto.delflag) eq 'Y'}">
     									<td style="color:red; font-size:0.8em;">관리자에 의해 삭제되었습니다.</td>
     								</c:when>
     								<c:otherwise>
	   									<td>
	      									${dto.title}
	      								</td>
     								</c:otherwise>
     							</c:choose>	      						
      						<td>
      							
   								<fmt:parseDate var="patternDate" value="${dto.regdate}" pattern="yyyy-MM-dd"></fmt:parseDate>
	   							<fmt:formatDate value="${patternDate}" pattern="YYYY년도 MM월 dd일"/>
      						</td>
      					</tr>
      				</c:forEach>
      			</c:if>
      		</tbody>
      	</table>
      	<div style="text-align: center">
      		<fmt:parseNumber var="end" value="${page.totalPage/page.countPage}" integerOnly="true"/>
			<ul class="pagination pagination-lg">
				<c:if test="${page.startPage > 1}">
      				<li><a href="./boardPage.do?page=1">◁</a></li>
      				<li><a href="./boardPage.do?page=${page.endPage-page.countPage}">◀</a></li>
      			</c:if>
				<c:forEach begin="${page.startPage}" end="${page.endPage}" var="p">
					<c:choose>
						<c:when test="${p eq page.page}">
							<li class="active"><a href="'./boardPage.do?page='+${p}">${p}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="./boardPage.do?page=${p}">${p}</a></li>
						</c:otherwise>
					</c:choose>	  
				</c:forEach>
   				<c:if test="${page.endPage < page.totalPage}">
    				<li><a href="./boardPage.do?page=${page.startPage + page.countPage}">▶</a></li>
   					<li><a href="./boardPage.do?page=${end*page.countPage+1}">▷</a></li>
   				</c:if>
			</ul>
		</div>
	</div>
</body>
<%@ include file="../../footer.jsp" %>
</html>