<%@page import="com.min.edu.comm.PhotoBean"%>
<%@page import="org.apache.ibatis.javassist.bytecode.ExceptionTable"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.min.edu.dto.AnswerboardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 게시글 보기</title>
</head>
<%

	List<AnswerboardDto> lists = (List<AnswerboardDto>)request.getAttribute("lists");
	/* List<AnswerboardDto> lists = new ArrayList(); */
%>
<jsp:useBean id="dp" class="com.min.edu.comm.DatePatternBean" scope="page" />
<jsp:useBean id="pp" class="com.min.edu.comm.PhotoBean" scope="page" />
<%@ include file="./header.jsp" %>
<body>
   <div id="container">
      <form action="./boardDelete.do" method="POST" onsubmit="return chkSubmit()">
      	<table class="table table-hover">
      		<thead>
      			<tr class="info">
      				<th><input type="checkbox" id="allCheck" onclick="checkAll(this.checked)" class="allCheckBox"></th>
      				<th>연번</th>
      				<th>아이디</th>
      				<th>제목</th>
      				<th>작성일</th>
      			</tr>
      		</thead>
      		<tbody>
      			<%
      				if(lists.size()==0){
      					%>
      					<tr>
      						<td colspan="5" style="color:red; text-align:center;">-- 작성된 글이 존재하지 않습니다 --</td>
      					</tr>
      					<%
      				} else {
      					for(int i=0; i<lists.size(); i++){
      						%>
      						<tr>
      							<td><input type="checkbox" name="ch" class="ch" value="<%=lists.get(i).getSeq()%>"></td>
      							<td><%=lists.size()-i%></td>
      							<td><%=lists.get(i).getId()%></td>
      							<%
      								if(lists.get(i).getDelflag().equalsIgnoreCase("y")){
      									%>
      										<td style="color:red; font-size:0.8em;">관리자에 의해 삭제되었습니다.</td>
      									<%
      								} else {
      									%>
		      							<td>
		      								<a href="./detailBoard.do?seq=<%=lists.get(i).getSeq()%>">
 		      									<jsp:setProperty property="depth" name="pp" value="<%=lists.get(i).getDepth()%>"/>
		      									<jsp:getProperty property="photo" name="pp"/>
		      									<%-- <%=PhotoBean.getPhoto(lists.get(i).getDepth())%> --%>
		      									<%=lists.get(i).getTitle()%>
		      								</a>
	      								</td>
		      							<%      									
      								}
      							%>
      							<td>
<%--       								<jsp:setProperty property="regdate" name="dp" value="<%=lists.get(i).getRegdate()%>"/>
      								<jsp:getProperty property="datePattern" name="dp"/> --%>
      								<%=lists.get(i).getRegdate()%>
   								</td>
      						</tr>
      						<%
      					}
      				}
      			%>
      		</tbody>
      		<tfoot>
      			<tr>
      				<td colspan="5" style="text-align:center;">
      					<input class="btn btn-info btn-block" type="submit" value="다중삭제">
      				</td>
      			</tr>
      		</tfoot>
      	</table>
      </form>
   </div>
</body>
<%@ include file="./footer.jsp" %>
</html>