<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="/include/header1.jsp"%>
<%@ include file="/include/header2.jsp"%>
<link rel="stylesheet" href="../css/new.css">
<header>
<style>
.btn btn-default{
    color: #fff;
    font-size: 16px;
    background-color: #AAA9F5;
    margin-top: 20px;
}
#login-form.btn btn-default{
outline-color: #795cfa;
}
</style>
</header>
<div align="center" class="div_center">

	<h2>My page</h2>
	<hr>
	<p>
		${sessionScope.user_id }<b style="color: #f39d4c;">(${sessionScope.user_name })</b>님의
		정보
	</p>
	<form id="login-form">
	
		<input type = "button" value = "내 작성글보기" class = "btn btn-default" onclick="location.href='${pageContext.request.contextPath}/book/searchMy.board?writer=${vo.writer}';">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "button" value = "내 찜목록" class = "btn btn-default" onclick="location.href='';">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "button" value = "내 정보수정" class = "btn btn-default" onclick="location.href='${pageContext.request.contextPath}/user/update.user';">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "button" value = "탈퇴하기" class = "btn btn-default" style="color:#f39d4c" onclick="location.href='${pageContext.request.contextPath }/user/delete.user';">&nbsp;&nbsp;&nbsp;&nbsp; 
	
	</form>



</div>

<%@ include file="../include/aside.jsp"%>
<%@ include file="../include/footer.jsp"%>