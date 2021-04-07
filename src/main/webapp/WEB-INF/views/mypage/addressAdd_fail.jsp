<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>주소록 저장 실패</title>
</head>
<body>
	<script type="text/javascript">
		alert("공백이 있거나 입력된 문자 길이가 너무 깁니다")  		
		location.href="<c:url value='/mypage/addressAdd?userNo=${userNo}'/>"
	</script>

</body>
</html>