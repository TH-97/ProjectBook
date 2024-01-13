<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/include/header1.jsp" %>
<%@ include file = "/include/header2.jsp" %>

<div align = "center" class = "div_center">
	<h2>아이디 찾기</h2>
	<hr>
	
	<form action = "searchForm.user" method = "post">
	<table>
	<tr>
		<td>이름</td>
		<td>
		 <input type = "text" name = "user_name">&nbsp;
		 </td>
	</tr>
	<tr>
		<td>연락처</td>
		 <td><input type = "text" name = "user_phone" placeholder ="-을 제외하고 작성해주세요"> </td>
	</tr>
	<tr>
		<td colspan = "2" align = "right">
		<input type = "submit" value = "확인" class = "btn btn-default">
		</td>
	</tr>
</table>
	</form>
	${msg }



</div>




</body>


<%@ include file = "/include/footer.jsp" %>