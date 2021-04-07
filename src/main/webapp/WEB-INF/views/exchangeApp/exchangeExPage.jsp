<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>교환 반품 신청 페이지</title>
</head>
<body>
<c:if test="${orderInfo.userNo==null}">
	<jsp:include page ="../Header.jsp"/>
</c:if>
<c:if test="${orderInfo.userNo!=null}">
	<jsp:include page ="../userHeader.jsp"/>
</c:if>
<div class="container">
	<div class="text-center"><h3><span class="text-warning">반품 및 교환 신청</span></h3></div>
	<form action="<c:url value='/mypage/exchangeAppEx'/>" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<td class="table-secondary"><span class="text-danger" style="width: 20%;">*제품명</span></td>
			<td class="table-light">
				${product.proName}
			</td>
		</tr>
		<tr>
			<td class="table-secondary"><span class="text-danger">*수량</span></td>
			<td class="table-light">
				<input type="text" value="${orderList.orAmount}" name="reExAmount" class="form-control" style="width: 40%;" readonly>
			</td>		
		</tr>
		<tr>
			<td class="table-secondary"><span class="text-danger">*반품 및 교환 여부</span></td>
			<td>
				<input type="radio" name="reExChoose" value="반품" class="form-check-input" type="radio" id="flexRadioDefault1">
				 <label class="form-check-label" for="flexRadioDefault1">반품</label>
				<input type="radio" name="reExChoose" value="교환" class="form-check-input" type="radio" id="flexRadioDefault2">
				  <label class="form-check-label" for="flexRadioDefault2">교환</label>
			</td>
		</tr>
		<tr>
			<td class="table-secondary"><span class="text-danger">*주문자</span></td>
			<td>
				<input type="text" value="${orderInfo.orderer}" name="reExOrderer" class="form-control" style="width: 40%;" readonly>
			</td>		
		</tr>
		<tr>
			<td class="table-secondary"><span class="text-danger">*이메일</span></td>
			<td>
				<input type="text" value="${orderInfo.orEmail}" name="reExEmail" class="form-control" style="width: 40%;">
			</td>
		</tr>
		<tr>
			<td class="table-secondary">반품 및 교환 사유</td>
			<td>
				<textarea rows="8" name="reExReason" class="form-control"></textarea>
			</td>		
		</tr>
		<tr>
			<td class="table-secondary">사진</td>
			<td>
				<input type="file" name="file" id="file" class="form-control" style="width: 40%;">
			</td>
		</tr>	
	</table>
	<c:if test="${orderInfo.userNo!=null }"><!-- 유저인지 아닌지 확인 -->
		<input type="hidden" value="${orderInfo.userNo}" name="userNo">
	</c:if>
		<input type="hidden" value="${orderInfo.orderNo}" name="orderNo">
		<input type="hidden" value="${orderList.proNo}" name="proNo">
		<input type="hidden" value="${product.proName}" name="proName">
	<div class="d-grid gap-2 d-md-flex justify-content-md-center">
		<input type="submit" value="신청" class="btn btn-outline-primary">
		<c:if test="${orderInfo.userNo!=null}">
			<a href="<c:url value='/mypage/orderList?userNo=${orderInfo.userNo}'/>">
				<input type="button" value="취소하기" class="btn btn-outline-danger">
			</a>
		</c:if>
		<c:if test="${orderInfo.userNo==null}">
			<a href="<c:url value='/shippingList?orderNo=${orderInfo.orderNo}'/>">
				<input type="button" value="취소하기" class="btn btn-outline-danger">
			</a>
		</c:if>
	</div>
</form>

</div>
</body>
</html>