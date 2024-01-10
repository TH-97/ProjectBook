<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<style>
form {
	text-align: center;
}

table {
	width: 33%;
	height: 200px; margin-left : auto;
	margin-right: auto;
	margin-left: auto;
}

th {
	text-align: center; /* 텍스트를 가로 방향으로 중앙에 배치 */
	vertical-align: middle; /* 텍스트를 세로 방향으로 중앙에 배치 */
	height: 300px;
}

td {
	text-align: center; /* 텍스트를 가로 방향으로 중앙에 배치 */
	vertical-align: middle; /* 텍스트를 세로 방향으로 중앙에 배치 */
}
</style>
</head>
<body>
	<div>
		<form action="" method="post">
			<label for="search">도서 검색:</label> <input type="text"
				name="search_book" placeholder="검색어를 입력하세요..."> <input
				type="submit" value="검색" class="btn btn-default">
		</form>
	</div>
	<div>



		<c:forEach var="vo" items="${list}">
			<table border="1">
				<thead>
					<tr>
						<td rowspan="7">이미지</td>
						<td style="height: 40px;font-size:20px">${vo.book_name}</td>
					</tr>
					<tr>
						<td>${vo.book_author}</td>
					</tr>
					<tr>
						<td>${vo.book_category}</td>
					</tr>
					<tr>
						<td>${vo.book_price}</td>
					</tr>
					<tr>
						<td>좋아요:${vo.love}</td>
					</tr>
					<tr>
						<td>등급:${vo.book_grade}</td>
					</tr>
					<tr>
						<td>재고:${vo.book_stock}</td>
					</tr>
				</thead>
			</table>
		</c:forEach>

	</div>

</body>
</html>
<%@ include file="../include/footer.jsp"%>