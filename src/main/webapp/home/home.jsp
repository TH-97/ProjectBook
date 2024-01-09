<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        form {
            text-align: center;
        }
        table{
        	border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
    </style>
</head>
<body>
	<div style="">
		<form action="/search" method="post">
        <label for="search">도서 검색:</label>
        <input type="text" id="search" name="q" placeholder="검색어를 입력하세요...">
        <button type="submit">검색</button>
    </form>
	</div>
	<div>
		<table border="1">
			<tr>
				<th>책1</th>
				<th>책2</th>
				<th>책3</th>
				<th>책4</th>
			</tr>
			<tr>
				<td>책1이름</td>
				<td>책2이름</td>
				<td>책3이름</td>
				<td>책4이름</td>
			</tr>
			<tr>
				<td>책1가격</td>
				<td>책2가격</td>
				<td>책3가격</td>
				<td>책4가격</td>
			</tr>
		</table>
	</div>

</body>
</html>
<%@ include file="../include/footer.jsp" %>