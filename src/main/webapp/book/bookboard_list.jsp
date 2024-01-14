<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>        

<%@ include file="../include/header1.jsp" %>
<%@ include file="../include/header2.jsp" %>

<div class="container">
		<h2>거래게시판</h2>

		<table class="table table-bordered" border = "1">
			<thead>
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>거래상태</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
	
			
	
			<tbody>
				
				<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.bul_num }</td>
					<td>${vo.writer }</td>
					<td>${vo.state }</td>
					<td><a href="content.board?bul_num=${vo.bul_num }&state=${vo.state}">${vo.title }</a></td>
					<td><fmt:formatDate value="${vo.regdate }" pattern="yy-MM-dd" /></td>
					<td>${vo.hit }</td>
				</tr>
				</c:forEach>

				
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="5" align="right">
						<form action="book.search" class="form-inline" >
						  <div class="form-group">
						    <input type="text" name="search" placeholder="제목검색" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-default">
							<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='write.board'; ">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>


<%@ include file="../include/footer.jsp" %>
