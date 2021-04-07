<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<script>
	function copy_to_clipboard() {
 	 var copyText = document.getElementById("Email");
 	 copyText.select();
 	 document.execCommand("Copy");
 	 alert("이메일이 복사 되었습니다")
	}
</script>
<meta charset="UTF-8">
	<title>반품 및 교환 내용</title>
	
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">
	<div class="text-center"><h3>${reEx.reExOrderer}님의 반품 및 교환 신청</h3></div>
	<a href="<c:url value='/admin/ExRe'/>">
		<input type="button" value="뒤로가기" class="btn btn-outline-danger">
	</a>
	
	<table class="table">
		<tr>
			<td class="table-secondary">제품명</td>
			<td>${product.proName}</td>		
		</tr>
		<tr>
			<td class="table-secondary">수량</td>
			<td>${reEx.reExAmount}</td>		
		</tr>
		<tr>
			<td class="table-secondary">반품 및 교환 여부</td>
			<td>${reEx.reExChoose}</td>		
		</tr>
		<tr>
			<td class="table-secondary">주문자</td>
			<td>${reEx.reExOrderer}</td>		
		</tr>
		<tr>
			<td class="table-secondary">이메일</td>
			<td>
				<input type="text" value="${reEx.reExEmail}" id="Email" readonly >
				<input type="button" value="이메일 복사" onclick="copy_to_clipboard()" class="btn btn-primary btn-sm">
			</td>		
		</tr>
		<tr>
			<td class="table-secondary">반품 및 교환 사유</td>
			<td>
				<img src="${pageContext.request.contextPath}/resources/images/reExImages/${reEx.reExPhoto}" alt="이미지가 없습니다" class="rounded" height="200" width="200">
				${reEx.reExReason}
			</td>		
		</tr>	
	</table>
</div>
</body>
</html>