<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header1.jsp"%>
<%@ include file="../include/header2.jsp"%>

<div align="center" class="div_center">
	<h2>게시판 글 작성</h2>
	<hr>

	<form action="registForm.board" method="post">
		<table border="1" width="500">

			<tr>
				<td> 거래상태 </td>
				<td>
				<input type="radio" name="state" value = "판매">판매
				<input type="radio" name="state" value = "구매">구매
				<input type="radio" name ="state" value = "거래완료">거래완료
				
				</td>
			</tr> 
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" required></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"
					value="${sessionScope.user_id }" size="10" required readonly>
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><textarea rows="10" style="width: 95%;" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성 완료" onclick="">
					&nbsp;&nbsp; <input type="button" value="목록"
					onclick="location.href='list.board'; "></td>
			</tr>

		</table>
	</form>

</div>

<%@ include file="../include/aside.jsp" %>
<%@ include file="../include/footer.jsp"%>


