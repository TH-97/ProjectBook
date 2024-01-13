<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file = "/include/header1.jsp" %>
<%@ include file = "/include/header2.jsp" %>
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

input {
	box-sizing: border-box;
}
<</style>
</header>

<div class="div_center" style="text-align: center">

	<form action="updateForm.user" method="post" id="login-form">
		<h2>회원정보 수정</h2>

		<hr>
		
			
				<input type="text" name="user_id" value="${sessionScope.user_id}" readonly  placeholder="아이디"><br>
		
				
				<input type="password" name="user_pw" required placeholder="비밀번호 (5글자 이상)"><br>
			
				
				<input type="password" name="user_pw_check" required placeholder="비밀번호와 똑같이 입력하세요"><br>
		
				
				<input type="text" name="user_name" value="${vo.user_name }" placeholder="이름"><br>
			
				
				<input type="text" name="user_address"value="${vo.user_address }" placeholder="~~시~~구"><br>
			
				<input type = "text" name = "user_phone" value = "${vo.user_phone }" placeholder="연락처(- 제외)"><br>
				
				<span>
				<input type="radio" name="user_gender" ${vo.user_gender =='M' ? 'checked' : "" } value="M">남자
				<input type="radio" name="user_gender" ${vo.user_gender =='F' ? 'checked' : '' } value="F">여자<br>
				</span>
			
			
			


		${msg }<br>
		
				<input type="submit" value="수정" class="btn btn-default">
				<input type="button" value="취소" class="btn btn-default" onclick="mypage.user">
		

	</form>
</div>

<%@ include file="/include/footer.jsp"%>