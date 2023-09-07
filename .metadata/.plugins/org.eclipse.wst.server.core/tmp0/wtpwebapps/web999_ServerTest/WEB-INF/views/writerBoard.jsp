<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글쓰기</title>
<link rel="stylesheet" href="./css/index.css">
<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
<script type="text/javascript" src="./js/write.js"></script>
</head>
<body>
	<div id="container">
		<div id="writeBox">
			<form id="writeForm" action="./insert.do" method="post" enctype="multipart/form-data">
				<table>	
					<col width="30%">
					<col width="70%">
					<tbody>
						<tr>
							<th>작성자</th>
							<td><input type="text" name="id" id="id"></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" id="title"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea rows="10"name="content" id="content"></textarea> </td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td><input type="file" name="originFname" id="file"></td>				
						</tr>
						<tr>
							<th colspan="2"><input type="button" value="작성"></th>
						</tr>
					</tbody>
				</table>		
			</form>
		</div>
	</div>
</body>
</html>