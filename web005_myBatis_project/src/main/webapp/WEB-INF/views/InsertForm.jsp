<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<body>
	<h1>새글 작성</h1>
	<hr>
	<form action="./setInsertBoard.do" method="POST">
		<table>
			<tbody>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="writer" required="required">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" required="required">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" required="required"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="작성완료">
		<input type="button" onclick="location.href='./getAllBoard.do'" value="취소">
	</form>
</body>
</html>