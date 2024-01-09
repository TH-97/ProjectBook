<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        form {
            text-align: center;
        }
    </style>
</head>
<body>
	<div>
		<form action="book/search.book" method="post">
        <label for="search">도서 검색:</label>
        <input type="text"  name="search_book" placeholder="검색어를 입력하세요...">
        <input type="submit"value="검색" class="btn btn-default">
    </form>
	</div>
	<div>

		
	</div>

</body>
</html>
<%@ include file="../include/footer.jsp" %>