<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="<%=request.getContextPath()%>/resources/js/daumpost.js"></script><!-- 외부 js파일가져오기 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- 제이쿼리 쓰기위해 -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	function register(){//주소 입력후 회원가입 버튼누르면 addr1에 한줄로 합쳐지기(dto에 addr이기때문에)
		addr1 = $("#addr1").val()
		addr2 = $("#addr2").val()
		addr3 = $("#addr3").val()
		addr = addr1 + "/" + addr2 + "/" +addr3
		$("#addr1").val(addr)
		fo.submit()
	}
</script>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:import url="../default/header.jsp" />
	<div align="center">
		<form id = "fo" action="register" method="post">
			<table border="1">
				<tr>
					<td><input type="text" name="id" placeholder="아이디"><br>
						<input type="password" name="pw" placeholder="비밀번호"><br>

						<input type="text" readonly id="addr1" name="addr"
						placeholder="우편번호"> <input type="button"
						onclick="daumPost()" value="우편번호 찾기"><br> <input
						type="text" readonly id="addr2" placeholder="주 소"><br> <!-- readonly : 읽기전용 -->
						<input type="text" id="addr3" placeholder="상 세 주 소"><br>
						<hr> <input type="button" onclick="register()" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
	<c:import url="../default/footer.jsp" />
</body>
</html>