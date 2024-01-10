<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "/include/header.jsp" %>

<div class ="div_center" style = "text-align: center;">

	<h2>로그인페이지</h2>
	<hr>
	<form action = "loginForm.user" method = "post">
	<input type="text" name = "user_id" placeholder = "아이디"><br><br>
	<input type ="password" name = "user_pw" placeholder = "비밀번호"><br><br>
	${msg }<br>
	<input type = "submit" value = "로그인" class="btn btn-default">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type = "button" value = "회원가입" class = "btn btn-default" onclick="location.href='join.user';">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type = "button" value = "아이디찾기" class = "btn btn-default" onclick = "location.href='serach.user;'">
	

	</form>




</div>

	

</body>
</html>
<%@ include file = "/include/footer.jsp" %>
