<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>비유저 주문 성공</title>
<link href="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/css'/>/bootstrap.min.css" rel="stylesheet" />
<script src="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/js'/>/bootstrap.bundle.js"></script>
</head>
<body>
	<div class="text-center">
	<h3>주문이 완료되었습니다</h3><br>
	<span class="text-danger">주문번호:${orderNo}</span><br>	
	주문번호를 꼭 저장해 주세요<br>
	나중에 주문 배송에 사용됩니다.<br>
	</div>
	<div class="d-grid gap-2 d-md-flex justify-content-md-center">
		<a href="<c:url value='/'/>">	
			<input type="button" value="메인으로" class="btn btn-outline-primary">
		</a>
	</div>

</body>
</html>