<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
register_view<br>
<h1>회원가입 페이지</h1>
<form action="${contextPath }/member/register2" method="post">
<input type="text" name = "id" placeholder="input id"><br>
<input type="password" name = "pwd" placeholder="input pwd"><br>
<input type="text" name = "name" placeholder="input name"><br>
<input type="submit" value="가입">
</form>
</body>
</html>