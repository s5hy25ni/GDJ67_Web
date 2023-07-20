<%@page import="com.min.edu.dto.Paging"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Board List 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<%
	List<UserDto> lists =  (List<UserDto>)request.getAttribute("lists");
	Paging p = (Paging)request.getAttribute("page");
%>
</head>
<%@ include file="../../header.jsp" %>
<body>
	<div class="container">
      	<table class="table table-hover">
      		<thead>
      			<tr class="info">
      				<th>연번</th>
      				<th>아이디</th>
      				<th>이름</th>
      				<th>이메일</th>
      				<th>권환</th>
      				<th>삭제여부</th>
      				<th>가입일</th>
      			</tr>
      		</thead>
      		<tbody>
      		<%
      			if(lists.size()==0){
      				%>
	   					<tr>
	   						<td colspan="5" style="color:red; text-align:center;">--회원이 존재하지 않습니다 --</td>
	   					</tr>
      				<%
      			}else{
      				for(int i = 0; i<lists.size(); i++){
      					%>
      						<tr>
<%--       						<td>${page.totalCount-((page.page-1)*page.countList)-vs.index}</td> --%>
      							<td><%=p.getTotalCount()-((p.getPage()-1)*p.getCountList())-i%></td>
      							<td><%=lists.get(i).getId()%></td>
      							<td><%=lists.get(i).getName()%></td>
      							<td><%=lists.get(i).getEmail()%></td>
      							<td><%=lists.get(i).getAuth().equals("1")?"회원":"관리자"%></td>
      							<td><%=lists.get(i).getDelflag().equalsIgnoreCase("N")?"활동 중":"탈퇴처리"%></td>
      							<td><%=lists.get(i).getJoindate()%></td>
      						</tr>
      					<%
      				}
      			}
      		%>
      		</tbody>
      	</table>
      	<div style="text-align: center">
			<ul class="pagination pagination-lg">
				<%if(p.getStartPage()>1){
					%>
					<li><a href="./userList.do?page=1">◁</a></li>
      				<li><a href="./userList.do?page=<%=p.getEndPage()-p.getCountPage()%>">◀</a></li>	
				<%
					}
				%>
      			<%
      				for(int i=p.getStartPage(); i<p.getEndPage()+1;i++){
      					if(i==p.getPage()){
      						%>
    							<li class="active"><a href="./userList.do?page=<%=i%>"><%=i%></a></li>
      						<%
      					}else{
      						%>
     							<li><a href="./userList.do?page=<%=i%>"><%=i%></a></li>
     						<%
      					}
      				}
      			%>
      			<%
      				if(p.getEndPage()<p.getTotalPage()){
      					%>
							<li><a href="./userList.do?page=<%=p.getStartPage()+p.getCountPage()%>">▶</a></li>
<%--   							<li><a href="./userList.do?page=${end*page.countPage+1}">▷</a></li>	 --%>
								<%-- ${page.totalPage/page.countPage} --%>
  							<li><a href="./userList.do?page=<%=(p.getTotalPage()/p.getCountPage())*p.getCountPage()+1%>">▷</a></li>	
      					<%
      				}
      			%>
			</ul>
		</div>
	</div>
</body>
<%@ include file="../../footer.jsp" %>
</html>