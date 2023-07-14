<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<link rel="stylesheet" href="http://localhost:8090/HTML_Education/css/10_login_form.css">
</head>
<body>
	<form class="box" action="./boardLogin.do" method="post">
	<h1>Login</h1>
		<input type="text" id="id" name="id" placeholder="username">
		<input type="password" id="pw" name="pw" placeholder="password">
		
		<input type="submit" value="Login"> <!-- reset은 초기화 -->		
	</form>
</body>
</html>