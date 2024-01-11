<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#header {
	font-weight: bold;
	font-size: 15px;
	line-height: 30px;
}

.wrapper {
	width: 100%;
	min-height: 50px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.lists {
	display: flex;
	background-color: purple;
	margin-right: 60px;
}

.lists li {
	margin-right: 50px;
	color: white;
}

.title {
	font-size: 40px;
	margin-left: 30px;
}

.log {
	margin-right: 30px;
}
</style>
</head>
<body>
	<section id="header">
		<div class="wrapper">

			<div class="title">
				<i class="fas fa-kiss-wink-heart"></i> 홈
			</div>
			<ul class="lists">
				<li>팔래</li>
				<li>살래</li>
			</ul>
			<div style="float:right;">로그인</div>
			<div class="log">회원가입</div>
		</div>
	</section>

</body>
</html>