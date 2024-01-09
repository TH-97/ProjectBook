<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../include/header.jsp" %>
		
	<div align="center" class="div_center">
		<h3>마이페이지</h3>
		<hr>
		<p>
		${sessionScope.user_id }<b style="color:green;">(${sessionScope.user_name })</b>님의 정보
		</p>

		<a href="">[내정보 조회]</a>
		
		<a href="">[장바구니]</a>

		<a href="">[예치금]</a>
		
		<a href="">[관심 도서]</a>
		
		<a href="">[내정보 수정]</a>&nbsp;&nbsp;
		
		<a href="">[탈퇴]</a>
		
	</div>

	<%@ include file="../include/footer.jsp" %>