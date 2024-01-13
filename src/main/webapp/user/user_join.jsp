<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file = "/include/header1.jsp" %>
<%@ include file = "/include/header2.jsp" %>
<link rel="stylesheet" href="../css/new.css">
<style>

input {
	width: 100%; auto;
	box-sizing: border-box;
}

.btn btn-default{
 	flex-direction: row;
	float: center;
}
#login-form > input[type="submit"]{
    color: #fff;
    font-size: 16px;
    background-color: #AAA9F5;
    margin-top: 20px;
}
.div_center{
	padding-top: 5px;
	padding-bottom: 5px;
	padding-left: 5px;
	padding-right: 5px;
}
    
</style>
<div class="div_center" style="text-align: center;">

	<h2>Join</h2>
	<hr>

	<form action="joinForm.user" method="post" name="reg_form" id="login-form">
		
				
				<input type="text" name="user_id" required pattern="[A-Za-z0-9]{4,}" placeholder="아이디"><br>
			
				
				<input type="password" name="user_pw" required placeholder="비밀번호"><br>
			
				
				<input type="password" name="user_pw_check" required placeholder="비밀번호 확인"><br>
			
				<input type="text" name="user_name" required placeholder="이름"><br>
		
				
				<input type="email" name="user_email" placeholder="aaa@gmail.com" placeholder="이메일"><br>
			
				
				<input type="text" name="user_address" placeholder=" 주소 ex) 서울특별시 강남구 테헤란로 1길"><br>
		
				<input type = "text" name="user_phone" placeholder = "연락처 (-제외)"><br>
				
				<span>
				<input type="radio" name="user_gender" value="M" checked>남자
				<input type="radio" name="user_gender" value="F">여자<br>
				</span>
				
				${msg}<br>
				<input type="submit" value="회원가입" class="btn btn-default">
				<input type="button" value="취소" class="btn btn-default" onclick="location.href='login.user';"></td>
			


	</form>

</div>




</body>
</html>
<%@ include file="/include/footer.jsp"%>