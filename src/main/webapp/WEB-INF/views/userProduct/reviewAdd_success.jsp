<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>리뷰 등록 성공</title>
</head>
<body>
	<script type="text/javascript">
  		alert("등록 성공");
  		location.href="<c:url value='/product?proNo=${proNo}'/>"
	</script>
	

</body>
</html>