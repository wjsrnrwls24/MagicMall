<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>비밀 번호 변경 페이지</title>
<link href="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/css'/>/bootstrap.min.css" rel="stylesheet" />
<script src="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/js'/>/bootstrap.bundle.js"></script>
</head>
<body>
<div class="container">	
		<div class="text-center"><h3><p>비밀번호 변경</p></h3></div>
		
		<form action="<c:url value='/user/changePassExecute'/>" method="post">
			새로운 비밀번호: <input type="password" name="password" id="password" class="form-control"><br>
			새로운 비밀번호 확인: <input type="password" name="passwordCheck" id="passwordCheck" class="form-control"><br>
			<input type="hidden" name="userNO" value="${userNO}">
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<input type="submit" value="비밀번호 변경"  class="btn btn-outline-primary" style="width: 30%; float:none; margin:0 auto">
		</div>
		</form>
		
		
	
</div>
</body>
</html>