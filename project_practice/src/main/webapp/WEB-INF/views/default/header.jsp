<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
}

.wrap {
	width: 1000px;
	margin: auto;
}

.header {
	width: 1000px;
	background-color: white;
}

.navdiv {
	width: 100%;
	background-color: maroon;
}

nav {
	background-color: maroon;
	width: 1000px;
}

nav ul {
	list-style: none;
	display: flex;
	justify-content: flex-end;
}

nav ul li {
	margin: 0 3px;
	padding: 10px 10px;
}

nav ul li a {
	text-decoration: none;
	color: white;
}

nav ul li a:hover {
	color: yellow;
	padding-bottom: 3px; /* a태그 밑줄과 글씨 간격*/
	border-bottom: 1px solid yellow;
	transition: all 0.25s;
}

.title { /*오른, 아래, 번짐*/
	text-shadow: 10px 10px 15px gray;
	font-size: 70pt;
	text-align: center;
	margin-top: 0px;
	padding-bottom: 20px;
	color: maroon;
	font-family: times new roman;
}

.content {
	margin-top: 50px;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<h1 class="title">CARE LAB</h1>
		</div>
	</div>
	<div class="navdiv">
		<div class="wrap">
			<nav>
				<ul>
					<li><a href="${contextPath }/index">HOME</a></li>
					<li>
								<a href="${contextPath }/member/memberInfo">MEMBERSHIP</a> 
					</li>
					<li>
								<a href="${contextPath }/board/boardAllList">BOARD</a> 
					</li>
					<%-- 
					<li>
								<a href="${contextPath }/test/board">TEST_BOARD</a> 
								<!-- <a href="${contextPath }/test/write">TEST_WRITE</a> S -->
					</li>
					--%>
					<li>
						<c:choose>
							<c:when test="${loginUser != null }"> <!-- 세션이 있다면 로그인 사용자니 -->
								<a href="${contextPath }/member/logout">LOGOUT</a> 	<!-- 로그아웃으로 변경 -->						
							</c:when>
							<c:otherwise>
								<a href="${contextPath }/member/login">LOGIN</a><!-- 세션이 없다면 로그인으로 -->							
							</c:otherwise>
						</c:choose>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>
