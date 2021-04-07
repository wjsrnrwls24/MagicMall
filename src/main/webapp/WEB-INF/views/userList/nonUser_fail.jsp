<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>로그인 실패 페이지</title>
</head>
<body>
	<script type="text/javascript">
			alert("주문번호가 잘못 됬습니다");
		
  		location.href="<c:url value='/userList'/>"
	</script>
	
	
</body>
</html>