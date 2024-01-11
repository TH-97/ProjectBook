<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>

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
<div class="div_center" style="text-align: center;">

	<form action="updateForm.user" method="post">
		<h2>회원정보 수정</h2>

		<hr>
		<table border="1">

			<tr>
				<td>아이디</td>
				<td><input type="text" name="user_id" value="${vo.user_id }"
					readonly></td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="user_pw" required
					placeholder="비밀번호는 5글자 이상 입력하세요"></td>
			</tr>

			<tr>
				<td>비밀번호확인</td>
				<td><input type="password" name="user_pw_check" required
					placeholder="비밀번호와 똑같이 입력하세요"></td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" name="user_name" value = "${vo.user_name }"></td>
			</tr>

			<tr>
				<td>이메일</td>
				<td><input type="email" name="user_email" value = "${vo.user_email }" placeholder = "aaa@gmail.com"></td>
			</tr>

			<tr>
				<td>주소</td>
				<td><input type="text" name="user_address"
					value="${vo.user_address }" placeholder = "~~시 ~구">
				</td>
			</tr>
			
			<tr>
				<td>성별</td>
				<td>
				 	<input type = "radio" name = "gender" ${vo.user_gender == 'M' ? 'checked' : ""} value = "M">남자 
					<input type = "radio" name = "gender" ${vo.user_gender == 'F' ? 'checked' : ""}  value = "F">여자

</td>
</tr>

		</table>




	
	</form>





</div>



</body>
</html>
<%@ include file="/include/footer.jsp"%>