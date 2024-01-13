<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/include/header1.jsp"%>
<%@ include file="/include/header2.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도중</title>
<style>
.ser{
   box-shadow: 0 0 20px #795cfa, 0 0 40px #b5a5fa;
   padding: 15px 0px;
   background-color: none;   
   border-radius: 20px;
   width: 450px;
   vertical-align: middle;
   text-align: center;
   box-sizing: 80px;
   font-size: 35px
   align-items: center;
   float: center;
   	outline: none;
	border: none;

}
form{
   font-size: 35px
   display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    float: center;
   line-height: 50px;
   vertical-align: middle;
   text-align: center;
   
}
span{
   font-size: 35px
   display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    float: center;
   line-height: 50px;
   vertical-align: middle;
   text-align: center;
}
.ser::palceholder{
   color: rgb(153 153 204);
   font-size: var;
}
body{
   background-color:linearGradient(105deg, rgb(136, 124, 241/100%) 39%, rgb(124, 241, 192/ 100%) 96%);
}
.btn btn-default{
 	background-color: #AAA9F5;
}
 
</style>
</head>

<body>
	<span>
		<form action="book/search.book" method="post">
			<input type="text" color=#AAA9F5; class="ser" name="search_book" placeholder="도서검색"> 
			<input type="submit" value="검색" class="btn btn-default">
		</form>
	</span>
	<div></div>


</body>
</html>
<%@ include file="../include/footer.jsp"%>