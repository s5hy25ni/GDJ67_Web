<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:catch var="err">
	<c:set var="weather" value="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${zone}"/>
 	<c:import var="wrd" url="${weather}"/>
	<x:parse var="w" xml="${wrd}"/>
		{"x":"<x:out select="$w/rss/channel/item/description/header/x"/>",
		"y":"<x:out select="$w/rss/channel/item/description/header/y"/>",
		"pubDate":"<x:out select="$w/rss/channel/pubDate"/>",
		"wfKor":"<x:out select="$w/rss/channel/item/description/body/data/wfKor"/>",
		"temp":"<x:out select="$w/rss/channel/item/description/body/data/temp"/>",
		"reh":"<x:out select="$w/rss/channel/item/description/body/data/reh"/>",
		"pop":"<x:out select="$w/rss/channel/item/description/body/data/pop"/>"}
</c:catch>
<c:if test="${err != null}">
	${err}
</c:if>