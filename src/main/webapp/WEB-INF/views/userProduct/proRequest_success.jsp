<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>재고 수정 성공 페이지</title>
</head>
<body>
<script type="text/javascript">
		
			alert("재고가 요청 되었습니다");
	  		location.href="<c:url value='/product?proNo=${proNo}'/>"
</script>

</body>
</html>