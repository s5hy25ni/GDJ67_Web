<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 관리 메인</title>
<style type="text/css">
	form{
		width: 800px;
		margin: 100px auto;
	}
	
	table{
		border: 1px solid pink;
		border-collapse: collapse;
		margin: 0 auto;
	}
	
	th, td{
		border: 1px solid grey;
		width: 50%
	}
	
	th {
		background: pink;
		
	}
	
	th:nth-child {
		background: white;
	}
	
	th>input{
		float: right;
	}
	.btn-pink{
		background-color: pink;
	}
}
</style>
</head>
<body>
	<form action="./CalController.do" method="post">
		<input type="hidden" name="command" value="calendar">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" value="RABIT">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" value="기묘">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="일정보기">
				</th>
			</tr>
			
		</table>
	</form>
</body>
</html>