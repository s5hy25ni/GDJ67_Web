<%@page import="com.min.edu.dto.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성</title>
<script type="text/javascript" src="./js/writeForm.js"></script>
</head>
<%
	UserVo loginInfo = (UserVo)session.getAttribute("loginInfo");
%>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<div><a href="javascript:history.back(-1)">뒤로가기</a></div>
		<form action="./boardInsert.do" method="post">
			<table class="table table-condensed form-group">
				<thead>
					<tr>
						<th class="info">아이디</th>
						<td>
							<input type="text" class="form-control" value="<%=loginInfo.getId()%>" readonly="readonly">
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th class="info">제목</th>
						<td>
							<input type="text" class="form-control" id="title" name="title">
						</td>
					</tr>
					<tr>
						<th class="info">내용</th>
						<td>
							<textarea id="content" name="content" class="form-control" rows="10"></textarea>
						</td>
					</tr>
					<tr>
						<th class="info">내용</th>
						<td>
							<div id="convertView"></div>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" style="text-align: center;">
							<input class="btn btn-primary active" type="button" value="새글작성" onclick="validationForm()">
							<input class="btn btn-primary" type="reset" value="글초기화">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>