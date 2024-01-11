<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/include/header.jsp" %>

<div align = "center" class = "div_center">
	<h2>현재 비밀번호를 입력하세요.</h2>
	<hr>
	
	<form action = "deleteForm1.user" method = "post">
		비밀번호 : <input type = "password" name = "user_pw">&nbsp;
		<input type = "submit" value = "확인" class = "btn btn-default">
	</form>
	${msg }




</div>




</body>
</html>
<%@ include file="../include/aside.jsp" %>
<%@ include file = "/include/footer.jsp" %>