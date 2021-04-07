<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>비밀 번호 찾기 페이지</title>
<link href="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/css'/>/bootstrap.min.css" rel="stylesheet" />
<script src="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/js'/>/bootstrap.bundle.js"></script>
</head>
<body>
	
		<div class="text-center"><h3><p>비밀번호 찾기</p></h3></div>
		
		<form action="<c:url value='/user/findPassExecute'/>" method="post" name="findPassRequest" id="findPassRequest">
				<div class="mb-3">
					<label class="form-label">가입한 아이디</label>
					<input type="text" name="id" id="id" class="form-control">
				</div>
				<div class="mb-3">
					<label class="form-label">가입한 이메일</label>
					<input type="text" name="email" id="email" class="form-control">
				</div>
				<div class="mb-3">
			<label class="form-label">비밀번호 확인 질문</label>
					<select name="passCheckQuestion" class="form-select">
								<option value="fatherHome">아버지 고향은?</option>
								<option value="dream">너의 꿈은?</option>
								<option value="age">너의 나이는?</option>
					</select>
				</div>
				<div class="mb-3">
					<label class="form-label">비밀번호 확인 질문 답</label>
					<input type="text" name="passCheckAnswer" id="passCheckAnswer" class="form-control">
				</div>
			<div class="d-grid gap-2 d-md-flex justify-content-md-center">
				<input type="submit" value="비밀번호 찾기" class="btn btn-outline-primary" style="width: 30%; float:none; margin:0 auto">
			</div>
		</form>	
	
	

</body>
</html>