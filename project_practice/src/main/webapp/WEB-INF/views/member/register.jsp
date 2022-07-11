<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../default/header.jsp"/>
<div align="center">
   <form action="register" method="post">
      <table border="1">
         <tr><td>
            <input type="text" name="id" placeholder="아이디"><br>
            <input type="password" name="pw" placeholder="비밀번호"><br>
            <input type="text" name="addr" placeholder="주  소"><br>
            <hr>
            <input type="submit" value="회원가입">
         </td></tr>
      </table>
   </form>
</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>