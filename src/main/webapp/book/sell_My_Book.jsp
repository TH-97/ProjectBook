<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body {
	text-align: center;
}

.custom-table1 {
	margin: 0 auto;
	width: 20%;
	height: 5%;
}
table {
	margin: 0 auto;
	width: 5%;
	height: 5px;
}


input {
	width: 100%;
	height: 100%;
	text-align-last: center;
}

th, td {
	text-align: center;
	
}

select {
	width: 100%;
	height: 100%;
	text-align-last: center;
}
</style>

</head>
<body>
	<hr>
	<form action="sell.book" method="post">
	<table border="1" class="custom-table1">
		<thead>
			<tr>
				<th>제목</th>
				<th><input type="text" name="book_name"></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>지은이</td>
				<td><input type="text" name="book_author"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="book_publisher"></td>
			</tr>
			<tr>
				<td>출판일</td>
				<td><input type="date" name="book_releasedate"></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><select name="book_category">
						<option value="건강취미">건강취미</option>
						<option value="경제경영">경제경영</option>
						<option value="소설시희곡">소설시희곡</option>
						<option value="인문학">인문학</option>
				</select></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="book_price"></td>
			</tr>
			<tr>
				<td>책 등급</td>
				<td><select name="book_grade">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
				</select></td>
			</tr>

		</tbody>
	</table>
	<br>
	<table>
		<tr>
			<td><input type="submit" value="판매하기"></td>
		</tr>
	</table>
	</form>
	<hr>
</body>
</html>



<%@ include file="../include/aside.jsp"%>
<%@ include file="../include/footer.jsp"%>