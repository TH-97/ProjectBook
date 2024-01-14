<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ include file="../include/header1.jsp"%>
<%@ include file="../include/header2.jsp"%>


<div align="center" class="div_center">


	${vo.bul_num } ${vo.state }


	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${vo.bul_num }</td>

			<td width="20%">조회수</td>
			<td width="30%">${vo.hit }</td>
		</tr>
		<tr>
			<td>거래상태</td>
			<td>${vo.state }</td>
		<tr>
			<td>작성자</td>
			<td>${vo.writer }</td>


			<td>작성일</td>
			<td>${vo.regdate }</td>

		</tr>

		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${vo.title }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${vo.content }</td>
		</tr>

		<tr>
			<td colspan="4" align="center"><input type="button" value="목록"
				onclick="location.href='list.board'; ">&nbsp;&nbsp; <c:if
					test="${vo.writer == sessionScope.user_id }">
					<input type="button" value="수정"
						onclick="location.href='modify.board?bul_num=${vo.bul_num}&writer=${vo.writer }'; ">&nbsp;&nbsp;
				
				</c:if></td>
		</tr>
	</table>
	<table border="1" width="500">

		<thead>
			<tr>
				<td width="20%">글번호</td>
				<td width="30%">${vo.bul_num }</td>
				<td width="20%">조회수</td>
				<td width="30%">${vo.hit }</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>거래상태</td>
				<td width="30%">${vo.bul_num }</td>
				<td rowspan="2">작성일</td>
				<td rowspan="2"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td></td>
			</tr>
			<tr>
				<td width="20%">글제목</td>
				<td colspan="3">${vo.title }</td>
			</tr>
			<tr>
				<td width="20%">글내용</td>
				<td colspan="3" height="120px">${vo.content }</td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="button" value="목록"
					onclick="location.href='list.board'; ">&nbsp;&nbsp; <c:if
						test="${vo.writer == sessionScope.user_id }">
						<input type="button" value="수정"
							onclick="location.href='modify.board?bul_num=${vo.bul_num}&writer=${vo.writer }'; ">&nbsp;&nbsp;
				
				</c:if></td>
			</tr>
		</tbody>
	</table>

</div>



<%@ include file="../include/footer.jsp"%>
