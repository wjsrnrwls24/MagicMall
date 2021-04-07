<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>관리자 페이지</title>
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">
	<div class="text-center"><span class="text-info"><h3>재고 요청</h3></span></div>
		<table class="table table-bordered">
			<tr class="table-primary">
				<td>제품 사진</td>
				<td>제품 이름</td>
				<td>재고 요청 횟수</td>
				<td></td>
			</tr>
			<c:forEach var="amountRePro" items="${amountRePros}">
			<tr class="table-light">
				<td>
					<a href="<c:url value='/admin/proEdit?proNo=${amountRePro.proNo}'/>" class="link-secondary">
						<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${amountRePro.proPhoto}'/>" alt="이미지가 없습니다" class="rounded" height="100" width="100">
					</a>
				</td>
				<td>
					<a href="<c:url value='/admin/proEdit?proNo=${amountRePro.proNo}'/>" class="link-secondary">
						<c:out value='${amountRePro.proName}'/>
					</a>
				</td>
				<td><c:out value='${amountRePro.proAmountRequest}'/></td>
				<td>
					<form action="<c:url value='/admin/amountPlusEx'/>" method="post">
						<input type="hidden" value="${amountRePro.proNo}" name="proNo">
						<input type="submit" value="재고 처리 완료" class="btn btn-primary btn-sm">
					</form>
				</td>
			</tr>
			</c:forEach>
		</table>
	<div class="text-center"><span class="text-danger"><h3>주문취소</h3></span></div>
		<table class="table table-bordered">
			<tr class="table-primary">
				<td>주문자</td>
				<td>제품 사진</td>
				<td>제품 이름</td>
				<td>수량</td>				
				<td></td>
			</tr>
			<c:forEach var="cancelOrder" items="${cancelOrders}">
			<tr class="table-light">
			<td><c:out value='${cancelOrder.orderInfo.orderer}'/></td>
				<td>
					<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${cancelOrder.product.proPhoto}'/>" alt="이미지가 없습니다" class="rounded" height="100" width="100">
				</td>
				<td>
					<c:out value='${cancelOrder.product.proName}'/>
				</td>
				<td><c:out value='${cancelOrder.orderList.orAmount}'/></td>
				<td>
					<form action="<c:url value='/admin/orderCancelEx'/>" method="post">
						<input type="hidden" value="${cancelOrder.orderList.orderNo}" name="orderNo">
						<input type="submit" value="확인" class="btn btn-primary btn-sm">
					</form>
				</td>
			</tr>
			</c:forEach>			
		</table>
	<div class="text-center"><span class="text-info"><h3>베스트 제품</h3></span>
	<table class="table justify-content-center">
		<tr>
		<c:forEach var="mostSalePro" items="${mostSalePros}" begin="0" end="4">
			<td>
				<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${mostSalePro.proPhoto}'/>" alt="이미지가 없습니다" class="rounded" height="200" width="200"><br>
				<c:out value='${mostSalePro.proName}'/><br>
				구매:<c:out value='${mostSalePro.proBuyNum}'/>
			</td>
		</c:forEach>
		</tr>
	</table>
	</div>	
</div>	
</body>	
	
</html>