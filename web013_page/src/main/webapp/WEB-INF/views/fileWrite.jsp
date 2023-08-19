<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 새 글 쓰기</title>
</head>
<body>
	<form action="./fileWrite.do" method="post">
		<table>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" ></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" value="test01"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="5" cols="50" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td><input type="file"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th><input type="button" value="취소" onclick="history.back(-1)"></th>
					<th><input type="submit" value="작성"></th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>