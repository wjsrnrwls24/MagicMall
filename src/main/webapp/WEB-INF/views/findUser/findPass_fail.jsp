<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>비밀 번호 찾기 실패</title>
</head>
<body>
	<script type="text/javascript">
			alert("다시 입력해주세요");
			location.href="<c:url value='/user/findPass'/>"
	</script>

</body>
</html>