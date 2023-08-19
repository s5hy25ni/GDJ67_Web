<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 게시글 상세 보기</title>
</head>
<%@ include file="../../header.jsp" %>
<script type="text/javascript" src="./js/reply.js"></script>
<body>
	<div class="container">
		<input type="hidden" id="seq" value="${bDto.BSeq}">
		<input type="hidden" id="writer" value="${loginInfo.id}">
		<table class="table table-hover">
			<caption>${bDto.title}</caption>
			<tr>
				<th>작성자</th>
				<td>${bDto.BWriter}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${bDto.BRegdate}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${bDto.BContent}</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:forEach items="${bDto.fileDto}"  var="fDto">
						<a href="#">${fDto.originFname}</a><br>
					</c:forEach>
				</td>
			</tr>
		</table>
		<div>
			<c:set var="b" value="홍길동" />
			<button id="replyShow" style="float:left; margin-bottom:10px;">댓글보기</button>
			<div id="replys">
				<table class="table table-hover">
					<c:forEach items="${bDto.replyDto}"  var="rDto">
						<tr>
							<th>
								${rDto.RWriter}<br>
								${rDto.RRegdate}
							</th>
							<c:choose>
								<c:when test="${fn:trim(rDto.RDelflag) eq 'Y'}">
									<td style="color:red; font-size:0.8em;">관리자에 의해 삭제되었습니다.</td>
								</c:when>
								<c:otherwise>							
									<td>${rDto.RContent}</td>
								</c:otherwise>
							</c:choose>	 
						</tr>
					</c:forEach>
					<c:if test="${loginInfo ne null}">
						<tr>
							<th colspan="2">
								<b>${loginInfo.id}</b>
								<textarea rows="5" cols="95" id="replyTxt"></textarea>
								<button id="replyWriteForm" style="float:right;">등록</button>
							</th>
						</tr>
					</c:if>
				</table>
				<div style="text-align: center">
		      		<fmt:parseNumber var="end" value="${page.totalPage/page.countPage}" integerOnly="true"/>
					<ul id="rPage" class="pagination">
						<c:if test="${page.startPage > 1}">
		      				<li><a onclick="replayPage(1)">◁</a></li>
		      				<li><a onclick="replayPage(${page.endPage-page.countPage})">◀</a></li>
		      			</c:if>
						<c:forEach begin="${page.startPage}" end="${page.endPage}" var="p">
							<c:choose>
								<c:when test="${p eq page.page}">
									<li class="active"><a onclick="replayPage(${p})">${p}</a></li>
								</c:when>
								<c:otherwise>
									<li><a onclick="replayPage(${p})">${p}</a></li>
								</c:otherwise>
							</c:choose>	  
						</c:forEach>
		   				<c:if test="${page.endPage < page.totalPage}">
		    				<li><a onclick="replayPage(${page.startPage + page.countPage})">▶</a></li>
		   					<li><a onclick="replayPage(${end*page.countPage+1})">▷</a></li>
		   				</c:if>
					</ul>
				</div>
			</div>
		</div>		
	</div>
</body>
<%@ include file="../../footer.jsp" %>
</html>