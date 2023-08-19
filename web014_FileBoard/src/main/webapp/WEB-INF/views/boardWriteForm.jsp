<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 쓰기</title>
<script type="text/javascript">
	function chfile(){
		var imgFile = document.getElementById("imgFile")
		console.log(imgFile.value);
		
		var fileSize;
		var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp)$/;
		var maxSize = 5 * 1024 * 1024; // 5MB
		
		if(imgFile.value==""){
			alert("첨부파일은 필수!");
			imgFile.focus();
			return false;
		} 
		
		// for문으로 파일 개수 체크!
		fileSize = document.getElementById("imgFile").files[0].size;
		/* fileSize1 = document.getElementById("imgFile").files[1].size; */
		console.log(fileSize);
		/* console.log(fileSize1); */
		
		if(!imgFile.value.match(fileForm)){
			alert("이미지만 업로드 가능합니다.");
			return false;
		} else if(fileSize > maxSize){
			alert("파일 사이즈는 5MB까지만 가능합니다.");
			return false;
		}
		
	}
</script>
</head>
<body>
	<h1>새 글 작성</h1>
	<form action="./fileboard.do" method="post" enctype="multipart/form-data" onsubmit="return chfile()">
		<table>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer" value="작성자">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" size="50" value="게시판 만들어요">
				</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td>
					<input type="file" name="filename" id="imgFile" multiple="multiple">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="50" name="content">드디어 서블릿이 끝나간다</textarea>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="등록">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>