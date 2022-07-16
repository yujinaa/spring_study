<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> <!-- 제이쿼리 쓰기 위해 가지고온것 -->
<script type="text/javascript">
	function ajax() {
		var n = $("#name").val(); //제이쿼리 문법
		var a = document.getElemebtById("age").value;//자바스크립트 문법
		var form = {age:a, name:n}//age에 사용자가 입력한 a를 가져오겠다
		console.log(form)
	}
</script>
</head>
<body>
	<input type="text" id = "name"><br>
	<input type="text" id = "age"><br>
	<input type="button" onclick="ajax()" value="저장">
	<hr> 결과 : <label id = "label"></label>
</body>
</html>