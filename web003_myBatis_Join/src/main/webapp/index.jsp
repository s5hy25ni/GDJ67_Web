<%@page import="com.min.edu.dto.Team_DTO"%>
<%@page import="com.min.edu.dto.All_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myBatis Join</title>
</head>

<%
	List<All_Dto> lists = (List<All_Dto>)request.getAttribute("listsOne");
	List<Team_DTO> lists_02 = (List<Team_DTO>)request.getAttribute("listsTwo");
	List<Team_DTO> lists_03 = (List<Team_DTO>)request.getAttribute("listsThree");
%>
<body>
	<!-- javascript:~~ 이 문법은 실제로 안씀 -->
	<button onclick="javascript:location.href='./joinCtrl.do'">결과 확인</button>
	<%
			if(lists != null){
				%>
	<fieldset>
		<legend>All_DTO 방식</legend>
		<div>
			<div>총갯수 : <%=lists.size() %></div>
			<div>0번째 사람 : <%=lists.get(0).getPlayer_name() %>, <%=lists.get(0).getTeam_name() %></div>
		</div>
	</fieldset>
	<fieldset>
		<legend>각 DTO 생성 후 Team_DTO에 멤버필드로 사용하여 Join</legend>
		<div>
			<div>총갯수 : <%=lists_02.size() %></div>
			<% 
					for(int i = 0; i<2; i++){
						%>
							<div><%=lists_02.get(i) %></div>
						<%
					}
			%>
		</div>
	</fieldset>
		<fieldset>
		<legend>MyBatis의 mapper.xml에 &lt;collection&gt; 사용하여 resultMap을 사용하여 연결 team->player</legend>
		<div>
			<div>총갯수 : <%=lists_03.size() %></div>
			<div>0번째 : <%=lists_03.get(0) %></div>
		</div>
	</fieldset>								
				<%
			}
	%>
</body>
</html>