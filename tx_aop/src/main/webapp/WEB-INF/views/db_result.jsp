<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<table border="1">
		<tr>
			<th>user</th>
			<c:forEach var="u" items="${user }">
				<td>${u.userNum }</td>
			</c:forEach>
		</tr>
		<tr>
			<th>system</th>
			<c:forEach var="s" items="${system }">
				<td>${s.systemNum }</td>
			</c:forEach>
		</tr>
	</table>

</body>
</html>