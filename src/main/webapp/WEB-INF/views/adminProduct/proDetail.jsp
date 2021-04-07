<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>개별 제품 페이지</title>
	<script type="text/javascript">
		function deletePro(){
       		if(confirm("삭제하시겠습니까?")){
       			location.href="<c:url value='/admin/proDeleteEx?proNo=${product.proNo}'/>"
       		}
       		return false;
		}
	</script>
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">	
	<div align="right">${product.category}>${product.proName}</div><br>
	<table class="table justify-content-center">
		<tr class="text-right">
			<td style="width: 50%;">
				<img src="${pageContext.request.contextPath}/resources/images/${product.proPhoto}" alt="사진이 없습니다" class="rounded float-end" height="200" width="200">
			</td>
			<td>
			<div class="p-3 mb-2 bg-info text-dark"><h3>${product.proName}</h3></div><br>
			<span class='text-danger'>■</span>제조사 : ${product.proMaker}<br>
			<span class='text-danger'>■</span>가격 : ${product.proPrice}원<br>
			<span class='text-danger'>■</span>남은 수량 : ${product.proAmount}<br>
			<span class='text-danger'>■</span>적립금 : ${product.proSavedMoney}원 
			</td>
		</tr>
	</table>
		<div class="text-center"><h3>상품 상세 정보</h3></div>
		<table class="table justify-content-center">
		<tr>
		<td class="text-center">${product.proDetail}</td>
		</tr>
		<tr>
		<td class="text-center">${product.youtubeAdd}</td>
		</tr>
		</table>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
		<a href="<c:url value='/admin/proEdit?proNo=${product.proNo}'/>">
			<input type="button" value="수정하기" class="btn btn-primary">
		</a>
		<a href="#" onclick="deletePro()">
			<input type="button" value="삭제하기" class="btn btn-danger">
		</a>
		</div>

</div>                             
</body>
</html>