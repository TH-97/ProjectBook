<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file = "/include/header1.jsp" %>
<%@ include file = "/include/header2.jsp" %>
<style>
table {
	width: 20%;
	margin: 0 auto;
}

input {
	width: 100%;
	box-sizing: border-box;
}
</style>
<div class="div_center" style="text-align: center">

	<form action="updateForm.user" method="post">
		<h2>회원정보 수정</h2>

		<hr>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td colspan="2"><input type="text" name="user_id"
					value="${sessionScope.user_id}" readonly></td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td colspan="2"><input type="password" name="user_pw" required
					placeholder="비밀번호는 5글자 이상"></td>
			</tr>

			<tr>
				<td>비밀번호확인</td>
				<td colspan="2"><input type="password" name="user_pw_check"
					required placeholder="비밀번호와 똑같이 입력하세요"></td>
			</tr>
	
			<tr>
				<td>이름</td>
				<td colspan="2"><input type="text" name="user_name"
					value=${vo.user_name }></td>
			</tr>

			<tr>
				<td>주소</td>
				<td colspan="2"><input type="text" name="user_address"
					value="${vo.user_address }" placeholder="~~시~~구"></td>
			</tr>

			<tr>
				<td>성별</td>
				<td><input type="radio" name="user_gender"
					${vo.user_gender =='M' ? 'checked' : "" } value="M">남자</td>
				<td><input type="radio" name="user_gender"
					${vo.user_gender =='F' ? 'checked' : '' } value="F">여자</td>
			</tr>
			
			<tr>
				<td>연락처</td>
				<td colspan = "2"><input type = "text" name = "user_phone"
					value = "${vo.user_phone }" placeholder="-을 제외하고 적어주세요"></td>
			</tr>
			


		</table>
		${msg }
		<table>
			<tr>
				<td><input type="submit" value="수정" class="btn btn-default"></td>
				<td><input type="button" value="취소" class="btn btn-default"
					onclick="mypage.user"></td>
			</tr>
		</table>

	</form>
</div>

<%@ include file="/include/footer.jsp"%>