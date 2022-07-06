<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>result_session.jsp<br>
	id : ${requestScope.id }, ${sessionScope.id }<br> <!-- requestScope:모델에 있는값 --><!-- sessionScope:세션에 있는 값 -->
	name : ${name },${sessionScope.name }<br><!-- name은 model에 없기 때문에 세션에있는 name만 출력된다 -->
	<hr>
	<a href="make_session">make_session</a>
	<a href="del_session">del_session</a>
</body>
</html>