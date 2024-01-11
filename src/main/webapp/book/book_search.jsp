<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
	text-align: center;
}

table {
	width: 33%;
	height: 200px;
	margin-left: auto;
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
		<form action="search.book" method="post">
			<label for="search">도서 검색:</label> <input type="text"
				name="search_book" placeholder="검색어를 입력하세요..."> <input
				type="submit" value="검색" class="btn btn-default">
		</form>
	</div>
	<div>



		<c:forEach var="vo" items="${list}">
		<!-- hidden태그는 보여주고 싶지 않은 데이터를 숨겨서 전송할때 사용합니다. -->
		<input type="hidden" name="book_num" value="${vo.book_num}">
			<table border="1">
				<thead>
					<tr>
						<td rowspan="7">이미지</td>
						<td style="height: 40px; font-size: 20px">${vo.book_name}</td>
						<td rowspan="3"><input type="button" value="구매하기" onclick="location.href='buy.book?book_num=${vo.book_num}'; "></td>
					</tr>
					<tr>
						<td>${vo.book_author}</td>
					</tr>
					<tr>
						<td>${vo.book_category}</td>
					</tr>

					<tr>
						<td>${vo.book_price}</td>
						
						
						<td rowspan="2"><input type="button" value="장바구니" onclick="location.href='goBasket.book?book_num=${vo.book_num}'; "></td>
							
						
					</tr>

					<tr>
						<td>좋아요:${vo.love}</td>
					</tr>
					<tr>
						<td>등급:${vo.book_grade}</td>
						<td rowspan="2"><input type="button" value="좋아요" onclick="location.href='love.book?book_num=${vo.book_num}'; "></td>
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