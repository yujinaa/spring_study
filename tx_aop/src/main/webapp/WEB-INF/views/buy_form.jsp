<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	구매개수 입력<br>
	<form action="buy">
		<input type="text" name="num"><br> 
		<input type="submit" value="구매">
		<input type="button" value="db결과 확인"
			onclick="location.href='db_result'">
	</form>

</body>
</html>