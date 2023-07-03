<%@page import="com.min.edu.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userListStatus</title>
</head>
<body>
	
	<%
		List<UserDto> lists = (List<UserDto>)request.getAttribute("lists");
	%>
	<h1>회원상태정보 조회</h1>
	<table>
		<thead>
			<tr>
				<th>SEQ(번호)</th>
				<th>ID(아이디)</th>
				<th>NAME(성명)</th>
				<th>ADDRESS(주소)</th>
				<th>PHONE(전화번호)</th>
				<th>EMAIL(이메일)</th>
				<th>ENABLE(사용여부)</th>
				<th>AUTH(등급)</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(UserDto dto : lists){
					%>
					<tr>
						<td><%=dto.getSeq()%></td>
						<td><%=dto.getId()%></td>
						<td><%=dto.getName()%></td>
						<td><%=dto.getAddress()%></td>
						<td><%=dto.getPhone()%></td>
						<td><%=dto.getEmail()%></td>
						<td><%=dto.getEnable().equals("Y")?"사용중":"탈퇴"%></td>
						<td><%=dto.getAuth()%></td>
					</tr>
					<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th><a href="./adminMain.jsp">메인페이지이동</a></th>
			</tr>
		</tfoot>
	</table>
</body>
</html>