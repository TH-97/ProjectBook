<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file = "/include/header1.jsp" %>
<%@ include file = "/include/header2.jsp" %>

<style>

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
.ser{
   box-shadow: 0 0 20px #795cfa, 0 0 40px #b5a5fa;
   padding: 15px 0px;
   background-color: none;   
   border-radius: 20px;
   width: 450px;
   vertical-align: middle;
   text-align: center;
   box-sizing: 80px;
   font-size: 35px
   align-items: center;
   float: center;
   	outline: none;
	border: none;

}
form{
   font-size: 35px
   display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    float: center;
   line-height: 50px;
   vertical-align: middle;
   text-align: center;
   
}
span{
   font-size: 35px
   display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    float: center;
   line-height: 50px;
   vertical-align: middle;
   text-align: center;
}
.ser::palceholder{
   color: rgb(153 153 204);
   font-size: var;
}
body{
   background-color:linearGradient(105deg, rgb(136, 124, 241/100%) 39%, rgb(124, 241, 192/ 100%) 96%);
}
.btn btn-default{
 	background-color: #AAA9F5;
}

.w-btn-neon2 {
    position: relative;
    border: none;
    min-width: 200px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        rgba(129, 230, 217, 1) 0%,
        rgba(79, 209, 197, 1) 100%
    );
    border-radius: 1000px;
    color: #795cfa;
    cursor: pointer;
    box-shadow: 12px 12px 24px rgba(79, 209, 197, 0.64);
    font-weight: 700;
    transition: 0.3s;
}

</style>
</head>
<body>
	<div>
		<form action="search.book" method="post">
			<label for="search"></label>
			<input type="text" color=#AAA9F5; class="ser" name="search_book" placeholder="게시물 검색..."> 
			<br>
			<br>
				<input type="submit" value="검색" class="w-btn-neon2">
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
						<td>제목</td>
						<td style="height: 40px; font-size: 20px">${vo.book_name}</td>
						<td rowspan="3"><input type="button" value="구매하기"<%-- onclick="location.href='buy.book?book_num=${vo.book_num}'; " --%>></td>
					</tr>
					<tr>
						<td>글쓴이</td>
						<td>${vo.book_author}</td>
					</tr>
					<tr>
						<td></td>
						<td>${vo.book_category}</td>
					</tr>

					<tr>
						<td>책 가격</td>
						<td>${vo.book_price}</td>


						<td rowspan="2"><input type="button" value="장바구니"<%-- onclick="location.href='goBasket.book?book_num=${vo.book_num}'; " --%>></td>


					</tr>
				</thead>
			</table>
		</c:forEach>

	</div>

</body>
</html>
<%@ include file="../include/footer.jsp"%>