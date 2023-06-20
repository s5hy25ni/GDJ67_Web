<%@page import="com.min.edu.dto.Player_DTO5"%>
<%@page import="com.min.edu.dto.Team_DTO5"%>
<%@page import="com.min.edu.dto.Player_DTO4"%>
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
<body>
	<!-- javascript:~~ 이 문법은 실제로 안씀 -->
	<button onclick="javascript:location.href='./joinCtrl.do'">결과 확인</button>
	<%
	List<All_Dto> lists = (List<All_Dto>)request.getAttribute("listsOne");
	%>
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
	<% List<Team_DTO> lists_02 = (List<Team_DTO>)request.getAttribute("listsTwo"); %> 
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
	<% List<Team_DTO> lists_03 = (List<Team_DTO>)request.getAttribute("listsThree"); %>
	<fieldset>
		<legend>MyBatis의 mapper.xml에 &lt;collection&gt; 사용하여 resultMap을 사용하여 연결 team->player</legend>
		<div>
			<div>총갯수 : <%=lists_03.size() %></div>
			<div>0번째 : <%=lists_03.get(0) %></div>
		</div>
	</fieldset>	
	<% List<Player_DTO4> lists_04 = (List<Player_DTO4>)request.getAttribute("listsFour");  %>
	<fieldset>
		<legend>MyBatis의 mapper.xml에 &lt;collection&gt; 사용하여 resultMap을 사용하여 연결 player->team</legend>
		<div>
			<div>총갯수 : <%=lists_04.size() %></div>
			<div>1번째 : <%=lists_04.get(1) %></div>
			<div>2번째 : <%=lists_04.get(2) %></div>
		</div>
	</fieldset>		
	<% List<Team_DTO5> lists_05 = (List<Team_DTO5>)request.getAttribute("listsFive");  %>
	<fieldset>
		<legend>Team을 기준으로 소속된 선수들의 정보 확인</legend>
		<div>
			<div>총갯수 : <%=lists_05.size() %></div>
			<div>
				<div><%=lists.get(0).getTeam_name() %></div>
				<select>
					<%
						for(Player_DTO5 dto : lists_05.get(0).getPdto()) {
							%>
								<option><%=dto.getPlayer_name()%> / <%=dto.getBack_no() %></option>
							<%
						}
					%>
				</select>
			</div>
		</div>
	</fieldset>							
				<%
			}
	%>
</body>
</html>