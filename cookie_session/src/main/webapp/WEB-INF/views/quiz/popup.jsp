<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk() {
		location.href="cookieChk";
		window.close();
	}
</script>
</head>
<body>
쿠키를 위한 팝업창입니다<br><br><br>
<input type="checkbox" onclick="chk()">하루동안 열지않음
</body>
</html>