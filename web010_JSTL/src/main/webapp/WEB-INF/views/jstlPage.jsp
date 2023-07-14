<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 문법 페이지</title>
</head>
<body>
	${lists.get(0).getName()}<br>
	${lists.get(0).name}<br>
	${lists[0].name}<br>
	<c:set var="one" value="${lists[0]}"/>
	${one.name} /${one.math} /${one.kor}
	<hr>
	<h2>JSTL 문법</h2>
	<table>
		<thead>
			<tr>
				<td>연번</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>총점</td>
				<td>평균</td>
				<td>등급</td>
			</tr>
		</thead>
		<tbody>
			<c:set var="info" value="${lists}"/> <!-- sevlet에서 req.setAttribute 이름 -->
			<c:forEach var="d" items="${info}" varStatus="vs"> <!-- var는 items 안에 있는 1개, vs는 index 또는 count -->
				<tr>
					<td>${fn:length(info)-vs.index}, ${vs.index}, ${vs.count}</td>
					<td>
						<c:if test="${d.name eq '피카1'}">
							<c:out  value="첫 번째 피카"/> 
							${d.name} <!-- d.getName() -->
						</c:if>
						<c:choose>
							<c:when test="${d.name eq '피카3'}">
								${d.name} 님 환영합니다.
							</c:when>
							<c:when test="${d.name eq '피카7'}">
								<c:out value="${d.name} 님 환영합니다."/>
							</c:when>
							<c:otherwise>
								누구?
							</c:otherwise>
						</c:choose>
					</td>
					<td>${d.kor}</td>
					<td>${d.math}</td>
					<td>${d.eng}</td>
					<c:set var="total" value="${d.kor+d.math+d.eng}"/>
					<td>${total}</td>
					<td>${total/3}</td>
					<td title='${total>70?"합격":"과락"}'>
						${total>70?"합격":"과락"}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:forEach var="i" begin="1" end="9" step="1">
		${i}<br>
	</c:forEach>
	<!-- DTO의 날짜가 java.util.Date 혹은 java.lang.Strin 타입으로 되어 있는 경우 -->
	<!-- 
		java.util.Date d = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy년도 MM월 dd일");
		String newD = fmt.format(d);
		System.out.println(newD);
		
		String strDate = "2023-07-14 12:15:00" -> java.util.Date로 변경 -> Pattern
	 -->
	<fmt:formatDate value="<%=new Date()%>" pattern="yyyy년도 MM월 dd일"/>
	<fmt:parseDate var="inDate" value="2023-07-14 12:15:00" pattern="yyyy-MM-dd HH:mm:ss"/>
	<fmt:formatDate value="${inDate}" pattern="yyyy년도 MM월 dd일"/>
</body>
</html>