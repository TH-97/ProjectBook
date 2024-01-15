<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도중</title>
<style type="text/css">
#header {
	font-weight: bold;
	font-size: 15px;
	line-height: 30px;
	text-decoration: none;
	color: white;
}

.wrapper {
	width: 100%;
	min-height: 50px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: #AAA9F5;
	color: white;
	text-decoration: none;
	padding: 1px 10px 3px 10px;
}

.lists {
	display: flex;
	background-color: #AAA9F5;
	margin-right: 60px;
	list-style: none;
	color: white;
	text-decoration: none;
	padding: 1px 10px 3px 10px;
}

.lists li {
	margin-right: 50px;
	color: white;
	text-decoration: none;
	padding: 1px 10px 3px 10px;
}

.title {
	font-size: 40px;
	margin-left: 30px;
	color: white;
	text-decoration: none;
	padding: 1px 10px 3px 10px;
}

.log {
	margin-right: 30px;
	list-style: none;
	color: white;
	text-decoration: none;
	padding: 1px 10px 3px 10px;
}

.lists:hover {
	color: #0B3962;
	background-color: #9F81F6;
	text-decoration: none;
	
}

.log:hover {
	color: #0B3962;
	background-color: #9F81F6;
	text-align: center;
	text-decoration: none;
}
.listst li{
	float: left;
	list-style: none;
	color: white;
	text-decoration: none;
	font-size: 20px;
	@import url('https://fonts.googleapis.com/css2?family=Diphylleia&display=swap');
	font-family: 'Diphylleia', serif;
	
}
.logmain li{	
	float: right;
	list-style: none;
	color: white;
	text-decoration: none;
}
.title{
	list-style: none;
	color: white;
	text-decoration: none;
}
.home:hover{
	color: #0B3962;
	background-color: #9F81F6;
	text-decoration: none;
	
}
.home{
	text-decoration: none;
	color: white;
	@import url('https://fonts.googleapis.com/css2?family=Diphylleia&display=swap');
	font-family: 'Diphylleia', serif;
	padding: 1px 10px 3px 10px;
	
}
</style>
</head>
<body>
	<section id="header">
		<div class="wrapper">

			<div class="title">
			<li><a class="home" href="${pageContext.request.contextPath }/home.jsp">Home</a></li>
			</div>
			<ul class="logmain">
				<c:choose>
					<c:when test="${sessionScope.user_id == null }">
						<li><a class="log" href="${pageContext.request.contextPath }/user/login.user">login</a></li>
						<li><a class="log" href="${pageContext.request.contextPath }/user/join.user" >join</a></li>
					</c:when>
					<c:otherwise>
						<li><a class="log" href="${pageContext.request.contextPath }/user/logout.user">logout</a></li>
						<li><a class="log" href="${pageContext.request.contextPath }/user/mypage.user?wrier=${vo.writer}">mypage</a></li>
					</c:otherwise>
				</c:choose>
				<li><a class="log" href="${pageContext.request.contextPath }/book/list.board">list</a></li>
			</ul>

		</div>
	</section>
	<br>
	<br>
    <br>
    <br>
    <br>
</body>
</html>