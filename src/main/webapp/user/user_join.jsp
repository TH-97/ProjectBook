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

	<h2>회원가입</h2>
	<hr>

	<form action="joinForm.user" method="post" name="reg_form">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td colspan="2"><input type="text" name="user_id" required
					pattern="[A-Za-z0-9]{4,}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td colspan="2"><input type="password" name="user_pw" required></td>
			</tr>

			<tr>
				<td>비밀번호 확인</td>
				<td colspan="2"><input type="password" name="user_pw_check"
					required></td>
			</tr>

			<tr>
				<td>이름</td>
				<td colspan="2"><input type="text" name="user_name" required></td>
			</tr>

			<tr>
				<td>이메일</td>
				<td colspan="2"><input type="email" name="user_email"
					placeholder="aaa@gmail.com"></td>
			</tr>

			<tr>
				<td>주소</td>
				<td colspan="2"><input type="text" name="user_address"
					placeholder="서울특별시 강남구 테헤란로 1길"></td>
			</tr>

			<tr>
				<td>성별</td>
				<td><input type="radio" name="user_gender" value="M" checked>남자
				</td>
				<td><input type="radio" name="user_gender" value="F">
					여자</td>
			</tr>


		</table>
	${msg}
		<table>
			<tr>
				<td><input type="submit" value="회원가입" class="btn btn-default">
				</td>
				<td><input type="button" value="취소" class="btn btn-default"
					onclick="location.href='login.user';"></td>

			</tr>
		</table>

	</form>

</div>




</body>
</html>
<%@ include file="/include/footer.jsp"%>