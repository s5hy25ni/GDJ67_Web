<%@page import="com.min.edu.dto.AnswerboardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변형 게시판 처음 페이지</title>
</head>
<%
	UserVo loginInfo = (UserVo)session.getAttribute("loginInfo");
	List<AnswerboardDto> lists = (List<AnswerboardDto>)request.getAttribute("lists");
%>
<body>
	<h2><a href="./main.do">글 목록 보기</a></h2>
	<h2><a href="./boardListJSTL.do">JSTL</a></h2>
	<fieldset>
		<legend>scope</legend>
		<%
			if(loginInfo==null){
				%>
					<div style="color:orange;">로그인된 정보가 없습니다.</div>
				<%
			} else {
				%>
					**로그인 정보**<br>
					<ul>
						<li>아이디 : <%=loginInfo.getId()%></li>
						<li>성명 : <%=loginInfo.getName()%></li>
						<li>권한 : <%=loginInfo.getAuth().equalsIgnoreCase("U")?"사용자":"관리자"%></li>
						<li><button onclick="location.href='./logout.do'">로그아웃</button></li>
					</ul>
					<div><%=lists==null?"request scope 전달 안됨":"전달됨"%></div>
				<%
			}
		%>
	</fieldset>
</body>
</html>