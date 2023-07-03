<%@page import="com.min.edu.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회-등급변경</title>
</head>
<script type="text/javascript">
	function updateAuth(seq){
		console.log(seq);
		location.href="./userController.jsp?command=updateAuthForm&seq="+seq;
	}
</script>
	<%
		List<UserDto> lists = (List<UserDto>)request.getAttribute("lists");
	%>
<body>
	<%@include file="adminMain.jsp" %>
	<hr size="3">
	<h1>회원정보조회</h1>
	<table>
		<thead>
			<tr>
				<td>SEQ(번호)</td>
				<td>ID(아이디)</td>
				<td>NAME(성명)</td>
				<td>EMAIL(이메일)</td>
				<td>AUTH(등급)</td>
				<td>등급변경</td>
			</tr>
		</thead>
		<tbody>
			<%
				for(UserDto dto: lists){
					%>
					<tr>
						<td><%=dto.getSeq()%></td>
						<td><%=dto.getId()%></td>
						<td><%=dto.getName()%></td>
						<td><%=dto.getEmail()%></td>
						<td><%=dto.getAuth()%></td>
						<td><button onclick="updateAuth('<%=dto.getSeq()%>')">권한변경</button></td>
					</tr>
					<%
				}
			%>
		</tbody>
	</table>
</body>
</html>