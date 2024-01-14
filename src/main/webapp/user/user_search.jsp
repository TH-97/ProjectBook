<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/include/header1.jsp" %>
<%@ include file = "/include/header2.jsp" %>
<link rel="stylesheet" href="../css/new.css">

<div align = "center" class = "div_center">
	<h2>아이디 찾기</h2>
	<hr>
	
	<form action = "searchForm.user" method = "post" id="login-form">

		 <input type = "text" name = "user_name" placeholder ="이름">&nbsp;

		 <input type = "text" name = "user_phone" placeholder ="연락처(-을 제외)">

		 <input type = "submit" value = "확인" class = "btn btn-default">

	</form>
	${msg }



</div>




</body>


<%@ include file = "/include/footer.jsp" %>