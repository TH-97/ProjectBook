<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/include/header1.jsp"%>
<%@ include file="/include/header2.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.ser {
	box-shadow: 0 0 20px #795cfa, 0 0 40px #b5a5fa;
	padding: 15px 0px;
	background-color: none;
	display: flex;
	border-radius: 20px;
	width: 450px;
	vertical-align: middle;
	text-align: center;
	box-sizing: 80px;
}

form {
	font-size: 35px display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.ser::palceholder {
	color: rgb(153, 153, 204);
	font-size: var;
}
</style>
</head>

<body>
	<span>
		<form action="book/search.book" method="post">
			<input type="text" color=#AAA9F5; class="ser" name="search_book"
				placeholder="도서검색"> <input type="submit" value="검색"
				class="btn btn-default">
		</form>
	</span>
	<div></div>


</body>
</html>
<%@ include file="../include/footer.jsp"%>