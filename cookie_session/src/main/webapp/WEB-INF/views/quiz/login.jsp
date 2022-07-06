<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/quiz/cookie"/> <!-- 외부 쿠키 가져오기 -->
<c:choose>
	<c:when test="${loginUser ==null }">
	<form action="chkUser" method="post">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="text" name="pwd" placeholder="비밀번호"><br>
		<input type="submit" value="로그인">	
	</form>
	</c:when>
	<c:otherwise>
		<hr>
		${loginUser }님 로그인 상태입니다<br>
		<a href="chkUser">main 이동</a>
	</c:otherwise>
</c:choose>
</body>
</html>