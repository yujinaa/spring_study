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
		var addr = $("#addr").val()	;
		var form = {age:a, name:n, addr:addr}//age에 사용자가 입력한 a를 가져오겠다
		console.log(form)
		$.ajax({
			url : "ajax_result01", type: "POST",
			//data : 서버로 보낼 데이터{age : 20, name : 홍길동}
			data : JSON.stringify(form),//json문자열 형식으롭 바꾸겠다
			dataType : "json",//서버로 돌려받는 값의 타입 지정
			//서버로 보낼 데이터 설정
			contentType : "application/json; charset=utf-8",//이 방식으로 보내겠다
			success :function(result){
				$("#label").text(result.name+":"+result.age)
			},error: function(){alert("문제 발생")}
		})
	}
</script>
</head>
<body>
	<input type="text" id = "name" placeholder="이름"><br>
	<input type="text" id = "age" placeholder="나이"><br>
	<input type="text" id = "addr" placeholder="주소"><br>
	<input type="button" onclick="ajax()" value="저장">
	<hr> 결과 : <label id = "label"></label>
</body>
</html>