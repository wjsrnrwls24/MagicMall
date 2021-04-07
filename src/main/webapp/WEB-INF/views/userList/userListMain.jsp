<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 조회 페이지</title>
</head>
<body>
<jsp:include page ="../Header.jsp"/>
<div class="container">	
<div class="col-sm-6" style="width: 40%; float:none; margin:0 auto">
	<div class="card">
		<div class="card-body bg-light">
			<span class="text-center"><h3>회원 조회</h3></span>
			<form name="findProduct" method="post" action="<c:url value='/userList/loginEx'/>">
				<div class="mb-3">
					<label class="form-label">아이디</label>
				    <input type="text" name="id" id="id" class="form-control">
				</div>
				<div class="mb-3">
					<label class="form-label">비밀번호</label>
			    	<input type="password" name="password" id="password" class="form-control">
			    </div>
			    <div class="d-grid gap-2 d-md-flex justify-content-md-center">
					<input type="submit" id="loginRequest" name="loginRequest" value="로그인" class="btn btn-success">
				</div>				
			</form><br>
		</div>
		<div class="card-footer bg-light">
			<span class="text-center"><h3>비회원 조회</h3></span>
			<form action="<c:url value='/userList/nonUserEx'/>" method="post" class="row g-3 justify-content-center">
				<div class="col-auto">
					<input type="Number" name="orderNo" value="0" class="form-control" placeholder="주문번호">
				</div>
				<div class="col-auto">
					<input type="submit" value="조회하기" class="btn btn-success">
				</div>			
			</form>
		</div>
	</div>	
	
</div>
</div>
</body>
</html>