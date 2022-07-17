<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function getUsers() {
	$.ajax({
		url : "users", type: "get", getaType: "json",
		success : function(list) {
			$("#users").text(list)
			console.lig(list)
		}
	})
}
	
</script>
</head>
<body>
	<span id = "users"></span>
	<hr>
	<button type="button" onclick="getUsers()">사용자 목록 보기</button>
</body>
</html>