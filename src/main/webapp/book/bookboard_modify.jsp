<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header1.jsp" %>
<%@ include file="../include/header2.jsp" %>


<div align="center" class="div_center">
	<h2>게시판 글 수정</h2>
	<hr>
	 ${vo.state }
	
	<form action="update.board" method="post">
		
		<!-- hidden태그는 보여주고 싶지 않은 데이터를 숨겨서 전송할때 사용합니다. -->
		<input type="hidden" name="bul_num" value="${vo.bul_num }">
		
		
		<table border="1" width="500">
			
			<tr>
				<td>거래상태</td>
				<td><input style="color:red"type="radio" name = "state" ${vo.state.equals("판매") ? 'checked' : ''} value="판매" >판매</td>
				<td><input type="radio" name = "state" ${vo.state.equals("구매") ? 'checked' : ''} value="구매" >구매</td>
				<td><input type="radio" name = "state" ${vo.state.equals("거래완료") ? 'checked' : ''} value="거래완료" >거래완료</td>
				
			</tr>
			
			
			<tr>
				<td>작성자</td>
				<td colspan = "3"><input type="text" name="writer" value="${vo.writer }" readonly></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td colspan = "3">
					<input type="text" name="title" value="${vo.title }">
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td colspan = "3">
					<textarea rows="10" style="width: 95%;" name="content">${vo.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="수정 하기" onclick="">&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='list.board'; ">  
					<input type="button" value ="삭제하기" onclick = "location.href='delete.board?bul_num=${vo.bul_num}';">
				</td>
			</tr>
			
		</table>
	</form>
	
</div>


<%@ include file="../include/footer.jsp" %>


