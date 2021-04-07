<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 정보 수정 성공</title>
</head>
<body>
	<script type="text/javascript">
  		alert("수정 완료");
  		location.href="<c:url value='/mypage'/>"
	</script>
</body>
</html>