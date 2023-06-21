<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/10_login_form.css">
</head>
<!-- 
	<form> : 서버사이드에 HTML을 전송
				action 속성을 통해 submit 이벤트를 통해서 서버사이드에 값을 전송할 수 있는 영역
				method는 전송 프로토콜의 방식을 선택해서 보낼 수 있다.(default는 GET 방식, GET/POST/PUT/DELETE/TRACE...)
				반드시 서버에 전송할 때는 name이 있는 Element만을 전송할 수 있음
	<input> : 서버사이드에 전송될 값을 입력할 수 있는 요소(form 요소)
				form 요소 default는 text, type 속성을 통해 정의할 수 있음(text, color, date, number, password, ...)
				submit을 통해서 'name:값' 의 형태로 서버사이드에 전송
				empty Element(닫힘 tag 없고 values 속성을 가지고 있음)
				<b>값</b> <input value="값">
	
 -->
 <script type="text/javascript">
 	function checkVal(){
 		var user = document.getElementById("user");
 		var pw = document.getElementById("pw");
 		console.log(user, pw);
 		if(user.value == ""){
 			alert("아이디를 입력해 주세요");
 			user.value="";
 			user.focus();
 			return false
 		} else if(pw.value == ""){
 			alert("비밀번호를 입력해 주세요");
 			pw.focus();
	 		return false;
 		} else {
 			return true;
 		}
 	}
 </script>
<body>
	<button onclick="viewPw()">비밀번호 보기</button>
	<script type="text/javascript">
		function viewPw(){
			console.log("viewPw");
			document.getElementById("pw").type = "text";
		}
	</script>
	<form class="box" action="./HTMLLogin.login" method="post" onsubmit="return checkVal();">
	<h1>Login</h1>
		<input type="text" id="user" name="user" placeholder="username">
		<input type="password" id="pw" name="pw" placeholder="password">
		
		<input type="submit" value="Login"> <!-- reset은 초기화 -->		
	</form>
	
</body>
</html>