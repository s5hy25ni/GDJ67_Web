<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 조회</title>
<style type="text/css">
	table, tr, td, th{
		border: 1px solid #ccc;
		border-collapse: collapse;
		text-align: center;
	}
</style>
</head>
<body>
	<table>
		<col width="200px">
		<col width="800px">
		<tbody>
			<tr>
				<th>아이디</th>
				<td>${dto.id}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.title}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.regdate}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${dto.content}</td>
			</tr>
		</tbody>			
		<tfoot>
			<tr>
				<th>첨부파일</th>
				<c:choose>
					<c:when test="${fn:length(dto.filedto) > 0}">
						<td>
							<c:forEach var="files" items="${dto.filedto}">
								${files.origin_fname}
								<button onclick="location.href='./fileboard.do?command=download&seq=${dto.seq}'">다운로드</button>
							</c:forEach>
						</td>
					</c:when>
					<c:otherwise>
						<td style="color:red">-- 첨부파일이 없습니다 --</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</tfoot>
	</table>
</body>
</html>