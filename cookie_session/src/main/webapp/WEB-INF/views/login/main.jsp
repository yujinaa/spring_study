<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>main.jsp<br>
	${loginNick } 님 환영합니다!<br>
	${loginId } 님 환영합니다!<br> <!-- id는 여기저기서 쓰이기 때문에 세션으로 만든다 -->
	<a href="logout">logout</a>

</body>
</html> 