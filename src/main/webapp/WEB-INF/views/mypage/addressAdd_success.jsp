<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>배송지 등록 성공</title>
</head>
<body>
	<script type="text/javascript">
		alert("주소 등록 완료 되었습니다")  		
		location.href="<c:url value='/mypage/address?userNo=${userNo}'/>"
	</script>

</body>
</html>