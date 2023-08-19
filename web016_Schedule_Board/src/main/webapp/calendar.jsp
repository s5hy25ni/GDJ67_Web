<%@page import="com.min.edu.dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.min.edu.util.CalendarUtil"%>
<%@page import="com.min.edu.model.CalboardDaoImpl"%>
<%@page import="com.min.edu.model.ICalboardDao"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 관리 화면</title>
<%
	// MVC1 패턴으로 작성해보자
	
	// 1) 세션 정보
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
	
	// 2) 달력 객체 생성(현재 달력)
	Calendar cal = new GregorianCalendar();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	
	// 3) 요청받은 달력 년월을 Parameter 확인
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	
	// 4) 처음 화면 요청됐을 때 -> 요청값이 없음 -> 현재 날짜를 기준이로 year와 month 세팅
	if(paramYear != null){
		year = Integer.parseInt(paramYear);
	}
	if(paramMonth != null){
		month = Integer.parseInt(paramMonth);
	}
	
	// 5) 연산과 상관없음
	if(month > 12){
		month = 1;
		year++;
	}
	if(month < 1){
		month=12;
		year--;
	}
	
	// 6) 요청되고 변경된 날짜의 값으로 Calendar객체를 setting
	cal.set(year, month-1, 1);
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	// 7) 이전 월의 달력(출력용)
	Calendar preCal = new GregorianCalendar(year, month-2, 1);
	int preLastDay = preCal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	// 8) 화면의 TITLE 값 가져오기
	ICalboardDao dao = new CalboardDaoImpl();
	String yyyymm = year + CalendarUtil.iTwoWord(month);
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("id", id);
	map.put("yyyymm", yyyymm);
	List<CalendarDto> cList = dao.getCalViewList(map);
	System.out.print(cList);
	
%>
<%@ include file="header.jsp" %>
</head>
<body>
	<div id="container">
		<table id="calendar">
			<caption style="text-align: center; font-size: 17px; color:black;">
				<a class="arrow" href="./calendar.jsp?year=<%=year-1%>&month=<%=month%>">◀</a>
				<a class="arrow" href="./calendar.jsp?year=<%=year%>&month=<%=month-1%>">◁</a>
				<span class="y"><%=year%></span>년도
				<span class="m"><%=CalendarUtil.iTwoWord(month)%></span>월
				<a class="arrow" href="./calendar.jsp?year=<%=year%>&month=<%=month+1%>">▷</a>
				<a class="arrow" href="./calendar.jsp?year=<%=year+1%>&month=<%=month%>">▶</a>
			</caption>
			<thead>
				<tr>
					<th>일</th>
					<th>월</th>
					<th>화</th>
					<th>수</th>
					<th>목</th>
					<th>금</th>
					<th>토</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<%
					for (int i = 0; i < dayOfWeek-1; i++) {
						%>
							<td style="color:grey;"><%=preLastDay-(dayOfWeek-1)+1+i%></td>
						<%
					}
					
					for (int i = 1; i <= lastDay; i++) {
						%>
							<td>
								<!-- 달력의 일 출력 -->
								<a href="./CalController.do?command=calList&year=<%=year%>&month=<%=month%>&date=<%=i%>"
									style="color:<%=CalendarUtil.fontColor(i, dayOfWeek)%>;"
									class="countView"
								><%=i%></a>
								
								<!-- 일정 추가 버튼 -->
								<a href="./CalController.do?command=calForm&year=<%=year%>&month=<%=month%>&date=<%=i%>">
									<img src="./img/pen.png" alt="일정 추가" id="plus">
								</a>
								
								<!-- 각 일의 일정 -->
								<div class="cList">
									<%=CalendarUtil.getCalView(i, cList)%>
								</div>
							</td>
						<%
						if((dayOfWeek-1+i)%7==0) {  
							out.print("</tr><tr>");
						}        
					}
				%>
				<%
					for (int i = 0; i<(7-(dayOfWeek-1+lastDay)%7)%7; i++){
						%>
							<td style="color:grey;"><%=i+1%></td>
						<%
					}
				%>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="wrap_loading" style="display:none;">
		<div>
			<img src="./img/loading.gif">
		</div>
	</div>
</body>
</html>