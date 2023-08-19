<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 추가</title>
<script type="text/javascript">
	function calMonth(){
		var year = document.getElementById("year");
		var month = document.getElementById("month");
		console.log(year.value, month.value)
		
/*		var d = new Date();
 		console.log(d.getFullYear());
		console.log(d.getMonth()+1);
		console.log(d.getDate());
		console.log(d.getHours());
		console.log(d.getMinutes());
		console.log(d.getSeconds()); */
		var lastDay = new Date(year.value, month.value, 0);
		console.log("lastDay : ",lastDay.getDate());
		
		date.innerHTML="";
		var html="";
		for(let i=1; i<=lastDay.getDate(); i++){
			html += "<option value='"+i+"'>"+i+"</option>";
		}
		date.innerHTML=html;
	}
</script>
<%@ include file="header.jsp" %>
<style type="text/css">
	#calForm input[type=text]{
		width: 100%;
	}
</style>
<%! // Declaration 멤버필드
	int n = 0;
	
%>
<% // Scriptlet
	int m = 0;
	/*
		// scope 객체
		int lastDay = (Integer)request.getAttribute("lastDay");
		int hour = (Integer)request.getAttribute("hour");
		int minute = (Integer)request.getAttribute("minute");
	
		// parameter 
		int year = reuest.getParameter("year");
		int month = reuest.getParameter("month");
		int date = reuest.getParameter("date");
	*/

%>
</head>
<body>
	<div id="container">
		<form action="./CalController.do" method="post">
			<input type="hidden" name="command" value="calInsert">
			<table class="table" id="calForm">
				<tbody>
					<tr>
						<th>아이디</th>
						<td>${sessionScope.id}</td>
					</tr>
					<tr>
						<th>일정</th>
						<td>
							<select id="year" name="year">
								<!-- 
									param.명 
									requestScope.명
									sessionScope.명
									applicationScope.명
								-->
								<fmt:parseNumber var="i" type="number" value="${param.year}" />
								<c:forEach var="i" begin="${i-2}" end="${i+2}" step="1">
									<option ${i eq param.year?"selected":""} value="${i}">${i}</option>							
								</c:forEach>
							</select>
							<select name="month" id="month" onchange="calMonth()">
								<c:forEach var="i" begin="1" end="12" step="1">
									<option ${i eq param.month?"selected":""} value="${i}">${i}</option>																												
								</c:forEach>
							</select>
							<select name="date" id="date">
								<c:forEach var="i" begin="1" end="${maxDay}" step="1">
									<option ${i eq param.date?"selected":""} value="${i}">${i}</option>
								</c:forEach>
							</select>
							<select name="hour">
								<c:forEach var="i" begin="0" end="23" step="1">
									<option ${i eq hour?"selected":""} value="${i}">${i}</option>
								</c:forEach>
							</select>
							<select name="minute">
								<c:forEach var="i" begin="0" end="50" step="10">
									<option ${i eq minute?"selected":""} value="${i}">${i}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input class="form-control" type="text" name="title" id="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea class="form-control" rows="10" name="content"></textarea></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="2">
							<input class="btn btn-block btn-danger" type="submit" value="추가">
						</th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$("input[type=submit]").click(function(){
		if($("#title").val() == ""){
			alert("한 개 이상 체크해주세요");
			return false;
		}
	});
	
/* 	$("#month").change(function(){
		$.ajax({
			url:"./CalController.do",
			type:"post",
			async:true,
			dataType:"text",
			data:{"command":"getMaxDay",
				"month":$("#month").val(),
				"year":$("#year").val()
			},
			success:function(resp){
				$("#date").children().remove();
				var html = "";				
				for(let i=1; i<=Number(resp); i++){
					if(i==${param.date}){
						html+="<option selected value=";
						html+=i;
						html+=">"
						html+=i;
						html+="</option>"													
					} else {
						html+="<option value=";
						html+=i;
						html+=">"
						html+=i;
						html+="</option>"																									
					}
				}
				$("#date").append(html);
			},
			error:function(){
				alert("잘못된 요청");
			}
		});
	}); */
});
</script>
</html>