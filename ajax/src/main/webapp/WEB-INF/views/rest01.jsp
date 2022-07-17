<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function ajaxGet() {
		$.ajax({
			usl : "rest", type: "get", dataType : "json",
			success : function(data) { $("#label").text(data.execute)}
		})	
	}
	function ajaxPost() {
		$.ajax({
			usl : "rest", type: "post", dataType : "json",
			success : function(data) { $("#label").text(data.execute)}
		})	
	}
	function ajaxPut() {
		$.ajax({
			usl : "rest", type: "put", dataType : "json",
			success : function(data) { $("#label").text(data.execute)}
		})	
	}
	function ajaxDelete() {
		$.ajax({
			usl : "rest", type: "delete", dataType : "json",
			success : function(data) { $("#label").text(data.execute)}
		})	
	}
</script>
</head>
<body>
<label id = "label"></label><hr>
<button type="button" onclick="ajaxGet()">get호출</button>
<button type="button" onclick="ajaxPost()">post호출</button>
<button type="button" onclick="ajaxPut()">put호출</button>
<button type="button" onclick="ajaxDelete()">del호출</button>
</body>
</html>