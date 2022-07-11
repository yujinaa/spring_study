<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:import url="../default/header.jsp" />
	<div align="center">
		<table border="1" style="width: 500px;">
			<caption>  <!-- caption : 테이블에 대한 타이틀 -->
				<font size="5">회 원 정 보</font>
			</caption>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>주 소</th>
			</tr>
			<c:forEach items="${memberList }" var="mem">
				<tr>
					<td>${mem.id }</td>
					<td>${mem.pw }</td>
					<td>${mem.addr }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:import url="../default/footer.jsp" />
</body>
</html>
