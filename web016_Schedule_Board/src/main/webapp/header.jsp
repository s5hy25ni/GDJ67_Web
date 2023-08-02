<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript" src="./js/calendar.js"></script>
<style type="text/css">
	header{
		background: pink;
		height: 70px;
		box-sizing: border-box;
		color : #000000;
		text-align: right;
		padding-right: 10px;
	}
	a{
		color : black;
		text-decoration: none;
	}
	a:hover{
		color : black;
		cursor: pointer;
	}
	#container{
		width: 800px;
		height: 580px;
		margin : 40px auto;
	}
	#calendar{
		border: 1px solid #ccc;
		border-collapse: collapse;
		margin : auto;
	}
	#calendar th{
		width: 80px;
		border : 1px solid #ccc;
		text-align: center;
		background: pink;
	}
	#calendar td{
		width: 80px;
		height: 80px;
		border : 1px solid #ccc;
		text-align: left;
		vertical-align: top;
		position: relative;
	}
	.arrow:hover{
		text-decoration: none;
	}
	span{
		font-weight: bold;
	}
	.cList{
		margin-top: 5px;
	}
	.cList p{
		font-size: 8px;
		margin : 2px;
		background-color: #FFEAEA;
	}
	#plus{
		width : 15px;
		height : 15px;
		margin-top : 3px;
		background-image: url("./img/pen.png");
		background-size: 15px;
		float: right;
	}
	.cPreview{
		position: absolute;
		background-color: pink;
		top: -30px;
		left: 10px;
		width: 40px;
		height: 40px;
		opacity: 0.7;
		color: white;
		text-align: center;
		font-weight: bold;
		line-height: 40px;
		border-radius: 40px 40px 40px 1px;
	}
	
	.wrap_loading{
		position: fixed;
		left: 0px;
		right: 0px;
		top: 0px;
		bottom: 0px;
		background-color: rgba(0,0,0,0.2)
	}
	
	.wrap_loading div{
		position: fixed;
		top: 30%;
		left: 48%;
	}
	
	.wrap_loading img{
		width: 50%;
		height: 50%;
	}
</style>
</head>
<body>
	<header>
		<div>
			<div><b>아이디</b> : ${sessionScope.id}</div>
			<div><b>성명</b> : ${sessionScope.name}</div>
			<div>
				<a href="./CalController.do?command=sessionDel" style="color:red;"><b>세션삭제</b></a>
			</div>
		</div>
	</header>
</body>
</html>