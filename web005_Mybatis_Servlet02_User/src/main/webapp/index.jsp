<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html style="height: 196px; ">
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<style type="text/css">
	table{
		border:2px solid pink;
		border-collapse: clollapse;
		width: 300px;
		margin: 200px auto;
	}
</style>
</head>
<body>
	<%
		// scriptlet 자바의 문법을 작성하는 영역
/* 		Object obj = request.getAttribute("loginDto"); // 전달받은 객체의 name이 없으면 null
		UserDto loginDto = (UserDto)obj; */
		
/* 		UserDto sessionLoginDto = (UserDto)session.getAttribute("loginDto"); */
	%>
	<%-- 전달받은 값 request : <%=loginDto%> --%>
	<%-- 전달받은 값 sessionLoginDto : <%=sessionLoginDto%> --%>
	
	
   <form action="./loginLogout.servlet" method="post">

   <input type="hidden" name="command" value="login">
      <table>
         <tr>
            <td>아이디</td>
            <td><input type="text" name="id"></td>
         </tr>
         <tr>
            <td>비밀번호</td>
            <td><input type="password" name="password"></td>
         </tr>
         <tr>
            <td colspan="2">
               <input type="submit" value="로그인">
               <input type="button" value="회원가입" onclick="registForm()"> 
            </td>
         </tr>
      </table>
   </form>
</body>
<script type="text/javascript">
	function registForm(){
		location.href="./regist.servlet";
	}
</script>
</html>