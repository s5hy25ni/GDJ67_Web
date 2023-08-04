<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정화면</title>
<style type="text/css">
	span{
		color:red;
	}
</style>
</head>
<body>
	<%
		UserDto dto = (UserDto)request.getAttribute("dto");
	%>
</body>
	<form action="./userController.jsp" method="post">
		<input type="hidden" name="command" value="updateUser">
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th><span>&#42;</span>주소</th>
					<th><span>&#42;</span>전화번호</th>
					<th><span>&#42;</span>이메일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=dto.getId() %></td>
					<td>
						<input type="text" name="address" placeholder="<%=dto.getAddress()%>" required>
					</td>
					<td>
						<input type="text" name="phone" placeholder="<%=dto.getPhone()%>" required>
					</td>
					<td>
						<input type="text" name="email" placeholder="<%=dto.getEmail()%>" required>
					</td>
				</tr>				
			</tbody>
			<tfoot>
				<tr>
					<th colspan="4">
						<input type="submit" value="수정 완료">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
</html>