<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<form action="./boardLogin.do" method="POST">
		<!-- 전달된 값(parameter)는 시작 jsp에서 도착 jsp까지 -->
		<input type="hidden" name="loc" value="<%=request.getParameter("loc")%>">
		<table style="margin: 100px auto; text-align:center;">
			<tbody>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" id="id" required="required">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="pw" id="pw" required="required">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" class="btn" value="로그인">
						<input type="reset" class="btn" value="취소" onclick="history.back(-1)">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
<script type="javascript">
	function fn(){
		document.forms[0].submit()
	}
</script>
</html>