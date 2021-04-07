<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>주소록 수정 실패</title>
</head>
<body>
	<script type="text/javascript">
		alert("공백이 있거나 입력된 문자길이가 너무 깁니다")  		
		location.href="<c:url value='/mypage/addressEdit?addNo=${addNo}'/>"
	</script>

</body>
</html>