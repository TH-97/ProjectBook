<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../include/header1.jsp"%>
<%@ include file="../include/header2.jsp"%>
<link rel="stylesheet" href="../css/new.css">
<header>
	<style>
.div_center {
	box-shadow: 0 0 20px #FAAC58, 0 0 40px #F5D0A9;
	padding: 0px 0px;
	background-color: none;
	border-radius: 20px;
	margin-left: 5%;
	margin-right: 5%;
}

h2 {
	color: #DBA901;
	text-align: center;
}

table {
	table-layout: fixed;
	width: 100%;
	border-collapse: collapse;
	border: 3px solid purple;
}

thead th:nth-child(1) {
	width: 5%;
}

thead th:nth-child(2) {
	width: 10%;
}

thead th:nth-child(3) {
	width: 15%;
}

thead th:nth-child(4) {
	width: 45%;
}

thread th:nth-child(5) {
	width: 25%;
}

thread th:nth-child(6) {
	width: 50px;
}

th, td {
	padding: 20px;
}
</style>

</header>

<div class="div_center">
	<h2>거래게시판</h2>

	<table class="table table-bordered" border="1">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>작성자</th>
				<th>거래상태</th>
				<th>제목</th>
				<th>날짜</th>
				<th style="width: 50px;">조회수</th>
			</tr>
		</thead>



		<tbody>

			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.bul_num }</td>
					<td>${vo.writer }</td>
					<td>${vo.state }</td>
					<td><a
						href="content.board?bul_num=${vo.bul_num }&state=${vo.state}">${vo.title }</a></td>
					<td style="text-align: center;"><fmt:formatDate
							value="${vo.regdate }" pattern="yy-MM-dd" /></td>
					<td style="text-align: center;">${vo.hit }</td>
				</tr>
			</c:forEach>


		</tbody>

		<tbody>
			<tr>
				<td colspan="5" align="right">
					<form action="search.board" class="form-inline" method="post">
						<div class="form-group">
							<input type="text" name="search_board" placeholder="제목검색"
								class="form-control"> <input type="submit" value="검색"
								class="btn btn-default"> <input type="button"
								value="글 작성" class="btn btn-default"
								onclick="location.href='write.board'; ">
						</div>
					</form>
				</td>
			</tr>
		</tbody>

	</table>
</div>


<%@ include file="../include/footer.jsp"%>
