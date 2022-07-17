<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
c
<script type="text/javascript">
	function ajaxTest() {
		$.ajax({
			//url : 컨트롤러 경로
			//type : post or get
			 //성공적으로 통신이 일어났으면 함수가 가지고 있는 내용 실행
			 //실패했다면 에러가 가지고 있는 내용 실행
			url : "ajax_result", //"ajax",
			type : "GET", 
			success : function(data){//data:성공시 서버로부터 전달받는값
				$("#count").text(data)
				console.log("성공")	},
			error : function(){alert('통신실패')} 
		})	
		}
</script>
</head>
<body>
	<h1>일</h1>
	<h1>일</h1>
	<h1>일</h1>
	<h1>일</h1>
	<h1>일</h1>
	<h1>일</h1>
	<h1>일</h1>
	<h1>일</h1>
	<button type="button" onclick="ajaxTest()">클릭</button>
	<label id="count">0</label>
</body>
</html>