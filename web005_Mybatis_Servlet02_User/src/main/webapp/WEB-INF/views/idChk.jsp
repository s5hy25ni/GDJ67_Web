<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String isc = request.getParameter("isc");
%>
<body>
	<table>
		<tr>
			<td></td>
		</tr>
		<tr>
		<%
			if(isc.equals("true")){
				%>
				<td><input type="button" value="사용불가" onclick="cancel()"></td>
				<%
			} else {
				%>
				<td><input type="button" value="사용" onclick="comfirm()"></td>
				<%
			}
		%>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function cancel() {
		var parentId = opener.document.getElementsByName("id")[0];
		console.log(parentId.title, parentId.value);
		parentId.value="";
		parentId.focus();
		parentId.title="n";
		self.close();
	}
	function comfirm(){
		var parentId = opener.document.getElementsByName("id")[0];
		parentId.setAttribute("readonly", "readonly")
		parentId.title="y";
		parentId.parentNode.children[1].style.display="none";
		self.close();
	}
</script>
</html>