<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 정보 수정 페이지</title>
</head>
<body>
<jsp:include page ="../userHeader.jsp"/> 
<div class="container">	
		<div class="text-center"><h3>회원 정보 수정</h3></div>
		<form method="post" action="<c:url value='/user/editEx'/>" name="editEx">
			<input type="hidden" name="userNO" value="${userNO}" >
			<table class="table">
				<tr>
					<td class="table-secondary"><span class="text-danger" style="width: 20%;">*비밀번호</span></td>
					<td class="table-light"><input type="password" name="password" id="password" class="form-control" style="width: 50%;"><span class="text-danger">*영문 숫자를 혼합한 4~16길이의 문자 및 숫자</span></td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*비밀번호 확인</span></td>
					<td class="table-light"><input type="password" name="passwordCheck" id="passwordCheck" class="form-control" style="width: 50%;"></td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*이메일</span></td>
					<td class="table-light"><input type="text"name="email" id="email" class="form-control" style="width: 50%;"></td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*휴대전화 번호</span></td>
					<td class="table-light"><input type="text"name="pNumber" id="pNumber" class="form-control" style="width: 50%;"></td>
				</tr>
			</table>
			<div class="d-grid gap-2 d-md-flex justify-content-md-center">
				<input type="submit" value="회원정보 수정" class="btn btn-outline-primary"/>
				<a href="<c:url value='/mypage'/>"><input type="button" value="취소하기" class="btn btn-outline-danger"/></a>
			</div>
		</form>
		
</div>
</body>
</html>