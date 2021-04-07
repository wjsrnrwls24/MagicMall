<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>장바구니 추가 성공 페이지</title>
</head>
<body>
<script type="text/javascript">
		
			alert("장바구니에 담았습니다");
	  		location.href="<c:url value='/basket/main'/>"
</script>

</body>
</html>