<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트를 통한 DB 저장</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script type="text/javascript" src="../js/bike01.js"></script>
</head>
<body>
	<form action="../bikeCtrl.do" method="post">
		<input type="hidden" name="command" value="first_db">
		<input type="submit" value="DB저장">
		<table>
			<thead></thead>
			<tbody></tbody>
		</table>
	</form>
</body>
</html>