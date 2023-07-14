<%@page import="com.min.edu.dto.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript" src="./js/answerboard.js"></script>
<style type="text/css">
   #container{
      width: 800px;
      height:60vh;
      margin: 60px auto;
   }
   header{
      background: #051937;
      height:100px;
      color:#000000;
   }
   footer{
      background: #051937;
      text-align: center;
      line-height: 20px;
      padding: 20px; 
   }
	.navbar.navbar-inverse{
		margin-top:10px;
	}
</style>
</head>
<body>
<header>
	<div style="padding:5px;">
		<h1 style="display: inline;">
			<a href="./main.do">게시판 구현</a>
		</h1>
	</div>
	<c:choose>
		<c:when test="${empty sessionScope.loginInfo}">
			<div style="display:inline; float:right">
				<button class="btn btn-info" onclick="location.href='./boardLogin.do'">Sign in</button>
				<button class="btn btn-primary">Sign up</button>
			</div>
		</c:when>
		<c:otherwise>
			<div style="display: inline; float: right; margin: 10px;">
				<span style="color:white;">아이디 :
					${loginInfo.id} (${loginInfo.auth eq 'U' ? '사용자' : '관리자'})
				</span>
				<button class="btn btn-warning">MyPage</button>
				<button class="btn btn-danger"
					onclick="location.href='./logout.do'">Logout</button>
			</div>
		</c:otherwise>
	</c:choose>
</header>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">HOME</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">menu<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="./boardInsert.do">게시판</a></li>
							<li><a href="#">글작성</a></li>
						</ul></li>
					<li><a href="#">other</a></li>
					<li><a href="#">siteMap</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>