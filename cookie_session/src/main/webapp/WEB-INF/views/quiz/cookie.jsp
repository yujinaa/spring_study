<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function popup() {
		console.log("cookie => ","${cook}")
		if("${cook}" == ""){
			window.open("popup","new")     //쿠키가 없으면 popup 띄우기
			"width=300,height=200,top=500,left=500");
		}
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="popup()">
cookie페이지입니다<br>


</body>
</html>