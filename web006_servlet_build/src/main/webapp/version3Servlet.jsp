<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST 처리 방식 Encoding</title>
</head>
<!-- TODO 010 /Version3Servlet.do 요청하는 POST 프로토콜 작성 화면 -->
<body>
	<pre>
		POST로 처리되는 parameter의 값은 주소로 전달되는 방식이 아니다.
		HTML이 전송되는 방식
		이벤트는 submit으로 처리된다.
	</pre>
	
	<form action="./Version3Servlet.do" method="get">
		<input type="text" name="name">
		<input type="submit" value="값전송">		
	</form>
</body>
</html>