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
			//$("#users").text(list)
			console.lig(list)
			/*
			let html = "<b>이름 : </b>" +list[0].name + "님<br>"
			html += "<b>나이 : </b>" +list[0].name + "살<hr>"
			*/
			
			//반복문으로 나타내기
			for(var i = 0;i<list.length;i++){
			html += "<b>이름 : </b>" +list[1].name + "살<br>"
			html += "<b>나이 : </b>" +list[1].name + "살<hr>"
			}
			//$("#users").html(html)	//html형태로 들어온다
			
			//더보기 기능으로 만들기
			$("#users").append(html)
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