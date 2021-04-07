<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
				<title>로그인 성공 페이지</title>
</head>
<body>
	<script type="text/javascript">
  		alert("회원 가입 완료 되었습니다");
  		location.href="<c:url value='/user/login'/>"
	</script>
</body>
</html>