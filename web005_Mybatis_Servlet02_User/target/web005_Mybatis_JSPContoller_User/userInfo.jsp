<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<%
	UserDto dto = (UserDto)request.getAttribute("dto");
%>
<!-- 회원정보 수정, 회원탈퇴 -->
<body>
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
			<tr>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getAddress()%></td>
				<td><%=dto.getPhone()%></td>
				<td><%=dto.getEmail()%></td>
				<td><%=dto.getEnable().equals("Y")?"사용중":"탈퇴"%></td>
				<td><%=dto.getAuth().equals("USER")?"사용자":"관리자"%></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8">
					<input type="button" value="수정" onclick="updateForm()">
					<input type="button" value="탈퇴" onclick="delUser()">
				</td>
			</tr>
		</tfoot>
	</table>
</body>
<script type="text/javascript">
	// 명시적 함수, addEventListner click이벤트, onload를 통해서 click 이벤트
	function updateForm(){
		console.log("udpateForm");
		location.href="./userController.jsp?command=modify";
	}
	
	function delUser(){
		console.log("delUser");
		location.href="./userController.jsp?command=delUser";
	}
</script>
</html>