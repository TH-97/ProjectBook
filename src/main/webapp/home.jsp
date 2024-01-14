<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/include/header1.jsp"%>
<%@ include file="/include/header2.jsp"%>
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

.w-btn-neon2 {
    position: relative;
    border: none;
    min-width: 200px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        #B4B4FF 0%,
        #B4B4FF 100%
    );
    border-radius: 1000px;
    color: white;
    cursor: pointer;
    box-shadow: 12px 12px 24px #B4B4FF;
    font-weight: 700;
    transition: 0.3s;
}
 
</style>
</head>

<body>
	<span>
		<form action="book/search.board" method="post">
			<input type="text" color=#AAA9F5; class="ser" name="search_board" placeholder="게시물 검색..."> 
			<br>
			<br>

			<input type="submit" value="검색" class="w-btn-neon2">
		</form>
	</span>
	<div></div>


</body>
</html>
<%@ include file="../include/footer.jsp"%>