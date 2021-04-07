<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>아이디 찾기</title>
<link href="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/css'/>/bootstrap.min.css" rel="stylesheet" />
<script src="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/js'/>/bootstrap.bundle.js"></script>
</head>
<body>
	<p><div class="text-center"><h3>아이디 찾기</h3></div></p>
	
		 
		<form action="<c:url value='/user/findIDExecute'/>" method="post" id="findIdEx" name="findIdEx">
			<div class="mb-3">
				<label class="form-label">가입한 이메일</label>
				<input type="text" name="email" id="email" class="form-control"/>
			</div>
			<div class="d-grid gap-2 d-md-flex justify-content-md-center">
				<input type="submit" value="아이디 찾기" name="idFindRequest" id="idFindRequest" class="btn btn-outline-primary" style="width: 25%; float:none; margin:0 auto"/>
			</div>
		</form>
	
</body>
</html>