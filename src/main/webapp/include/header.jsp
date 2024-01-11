<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>도서는 역시 도중!</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath }/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,.600italic,700italic" rel="stylesheet" type="text/css">
	
	<!-- jQuery -->
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>

    
	<style>
	.abc {
		position: sticky;
		top: 0px;
		width: 100%; 
		z-index: 10;
	}
	</style>
    <style>
	.div_center {
		margin-bottom: 20px;
		margin-top:20px;
		padding: 30px 15px;

	}
	</style>
    
    
    
</head>

<body>
	<!-- header -->
	<div class="brand">도 중</div>        
    <div class="address-bar">도서는 역시 도중!</div>
    
    <nav class="navbar navbar-default abc" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong">My First Web</a>
            </div>
           
           
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${pageContext.request.contextPath }/home.jsp">홈</a>
                    </li>
                     <li>
                        <a href="">내도서판매</a>
                    </li>
                    <li>
                        <a href="">도서구매</a>
                    </li>
                    <li>
                        <a href="">도서랭킹</a>
                    </li>
                   
                   
                 	<c:choose>
                 	<c:when test="${sessionScope.user_id == null }">
	                    <li>
	                        <a href="${pageContext.request.contextPath }/user/login.user" style="color:red">로그인</a>
	                    </li>
	                    <li>
	                        <a href="${pageContext.request.contextPath }/user/join.user" style="color:orange;">회원가입</a>
	                    </li>
                    </c:when>
                    <c:otherwise>
   	                    <li>
	                        <a href="${pageContext.request.contextPath }/user/logout.user"style= color:red">로그아웃</a>
	                    </li>
	                    <li>
	                        <a href="${pageContext.request.contextPath }/user/mypage.user" style="color:orange">마이페이지</a>
	                    </li>
                    </c:otherwise>
                    </c:choose>






                </ul>
            </div>
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 	<!-- end header -->