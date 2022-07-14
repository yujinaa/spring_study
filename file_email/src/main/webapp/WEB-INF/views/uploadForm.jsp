<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드하기</h1>
	<!-- 파일업로드는 무조건 post방식, enctype는 무조건  multipart/form-data이어야 파일전송의 의미-->
	<form action="${contextPath }/upload" method="post" enctype="multipart/form-data">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="file" name="file"><br>
		<input type="submit" value = "업로드"><br>
	
	</form>
</body>
</html>