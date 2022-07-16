<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function test() {
		location.href = "non_ajax";
		
	}
</script>
</head>
<body>
해당 페이지를 전체적으로 서버와 통신한다
->클릭하면 다시 처음으로 돌아간다
<h1>일</h1>
<h1>일</h1>
<h1>일</h1>
<h1>일</h1>
<h1>일</h1>
<h1>일</h1>
<h1>일</h1>
<h1>일</h1>

<button type="button" onclick="test()">클릭</button>

</body>
</html>