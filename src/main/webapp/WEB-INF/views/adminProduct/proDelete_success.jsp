<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>제품 삭제 성공페이지</title>
</head>
<body>
	<script type="text/javascript">
			alert("삭제 성공");
	  		location.href="<c:url value='/admin/proList?num=0'/>"  		
	</script>

</body>
</html>