<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보 입력</title>
</head>
<!-- ID, PASSWORD, NAME, ADDRESS, PHONE, EMAIL -->
<script type="text/javascript">
	window.onload=function(){
		console.log("onload");
		var inputs = document.getElementsByTagName("input");
		/* console.log(inputs.length); */
		for(var i=3; i<8; i++){
			console.log(inputs[i].name);
			inputs[i].onclick=idConfirm;
		}
	}
	
	function idConfirm(target){
		/* console.log("작동"); */
		var idStatus = document.getElementsByName("id")[0];
		if(idStatus.title=="n"){
			alert("아이디 중복검사를 먼저 진행해주세요");
			idStatus.focus();
		}
	}
	
	function emailCheck(){
		console.log("emailCheck");
		var email = document.getElementById("email").value;
		console.log(email);
		// 앞의 아이디는 영문대소문+숫자+.+-
		var regText = /^[A-Za-z0-9\.\-]+@[A-Za-z\-]+\.[A-Za-z\-]+/;
		if(!regText.test(email)){
			alert("이메일을 잘못 작성하셨습니다.");
		}
	}
	
	function idChk(){
		console.log("idChk");
		var idStatus = document.getElementsByName("id")[0];
		if(idStatus.value==""){
			alert("ID중복 검색값을 필수로 입력해주세요");
			return
		}
		window.open("./userController.jsp?command=idChk&id="+idStatus.value, "아이디중복검사", "width=500px, height=500px");

	}
</script>
<body>
	<form action="./userController.jsp" method="post">
		<input type="hidden" name="command" value="insertUser">
		<table>
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" title="n" name="id">
						<input type="button" value="중복검사" onclick="idChk()">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="address">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="phone">
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" id="email" name="email">
						<input type="button" value="이메일확인" onclick="emailCheck()">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">
						<input type="submit" value="회원가입">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>