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
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:import url="../default/header.jsp" />
	<table border="1" align="center">
		<caption>
			<font size="5"><b>개인 정보</b></font>
		</caption>
		<tr>
			<th width="100">글 번호</th>
			<td width="200">${personalData.writeNo}</td>
			<th width="100">작성자</th>
			<td width="200">${personalData.id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${personalData.title}</td>
			<th>등록일자</th>
			<td>${personalData.saveDate}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${personalData.content}</td>
			<td colspan="2">
			<c:if
					test="${ personalData.imageFileName == 'nan' }">
					<b>이미지가 없습니다</b>
			</c:if> 
				<c:if test="${ personalData.imageFileName != 'nan' }">
					<img width="200px" height="100px"
						src="${contextPath}/board/download?imageFileName=${personalData.imageFileName}">
					<a href="${contextPath}/board/download?imageFileName=${personalData.imageFileName}">
						${personalData.imageFileName} </a>
				</c:if></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><c:if
					test="${ loginUser == personalData.id }">
					<input type="button" onclick="location.href='${contextPath }/board/modify_form?writeNo=${personalData.writeNo }'" value="수정하기">
					<input type="button" value="삭제하기" 	onclick="location.href='${contextPath }/board/delete?writeNo=${personalData.writeNo }&imageFileName=${personalData.imageFileName}'">
					<!-- writeNo=${personalData.writeNo}:db에있는 데이터 삭제위한 것 -->
					<!-- imageFileName=${personalData.imageFileName}: 해당 저장소에서 이미지 삭제하기위한 것 -->
				</c:if> <input type="button" onclick="" value="답글달기"> <input
				type="button" onclick="" value="리스트로 돌아가기"></td>
		</tr>
	</table>
	<c:import url="../default/footer.jsp" />
</body>
</html>