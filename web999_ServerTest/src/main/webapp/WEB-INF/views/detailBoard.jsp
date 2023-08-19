<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link rel="stylesheet" href="./css/index.css">
<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
<script type="text/javascript" src="./js/detail.js"></script>
</head>
<body>
	<div id="container">
		<div id="rootBox">
			<input type="hidden" value="${rtVo.seq}">
			<table>	
				<col width="30%">
				<col width="70%">
				<tbody>
					<tr>
						<th>작성자</th>
						<td>${rtVo.id}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${rtVo.title}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${rtVo.content}</td>
					</tr>
					<tr>
						<th>첨부파일명</th>
						<c:choose>
							<c:when test="${empty rtVo.fileVo}">
								<td id="noneFile">--- 첨부파일이 없습니다 ---</td>
							</c:when>
							<c:otherwise>
								<td><a>${rtVo.fileVo.originFname}</a></td>		
							</c:otherwise>
						</c:choose>					
					</tr>
				</tbody>
			</table>
		</div>
		<hr>
		<div id="replyBox">
			<table>
				<col width="5%">
				<col width="65%">
				<col width="30%">
				<tbody>
					<c:forEach items="${rtVo.replyVo}" var="rpVo" >
						<tr>
							<th>└</th>
							<th>${rpVo.title}</th>
							<td>${rtVo.regdate}</td>
						</tr>
					</c:forEach>
			</table>
		</div>
		<div id="pageBox">
			<ul>
				<li><a id="1">◀</a></li>
				<li><a id="${pVo.startPage-pVo.cntPage}">◁</a></li>
				<c:forEach var="p" begin="${pVo.startPage}" end="${pVo.endPage}">
					<c:choose>
						<c:when test="${p eq pVo.curPage}">
							<li class="activePage" id="${p}"><a>${p}</a></li>
						</c:when>
						<c:otherwise>
							<li><a id="${p}">${p}</a></li>
						</c:otherwise>
					</c:choose>	  
				</c:forEach>
				<li><a id="${pVo.startPage + pVo.cntPage}">▷</a></li>
				<li><a id="${pVo.totalPage mod pVo.cntPage*pVo.cntPage+1}">▶</a></li>				
			</ul>
		</div>
	</div>
</body>
</html>