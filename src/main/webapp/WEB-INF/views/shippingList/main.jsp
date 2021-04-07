<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>주문 목록 페이지</title>
</head>
<body>
<jsp:include page ="../Header.jsp"/>
<div class="container">	
	<a href="<c:url value='/'/>">
		<input type="button" value="뒤로가기" class="btn btn-outline-secondary">
	</a>
	<div class="text-center"><h3>주문내역</h3></div>
	<table class="table">
		<tr class="table-info">
			<td>주문일자</td>
			<td>제품 사진</td>
			<td>제품명</td>
			<td>주문수량</td>
			<td>배송현황</td>
			<td>결제금액</td>
			<td></td>		
		</tr>
		<c:forEach var="orderDetail" items="${orderDetails}">
			
			<tr class="table-light">
				<td>
					
					<fmt:formatDate value="${orderDetail.orderInfo.ordate}" pattern="yyyy/MM/dd"/>
				</td>
				<td>
					<a href="<c:url value='/product?proNo=${orderDetail.product.proNo}'/>">
						<img src="${pageContext.request.contextPath}/resources/images/${orderDetail.product.proPhoto}" alt="사진이 없습니다" class="rounded" height="100" width="100">
					</a>
				</td>
				<td>
					<a href="<c:url value='/product?proNo=${orderDetail.product.proNo}'/>">
						<c:out value="${orderDetail.product.proName}"/>
					</a>
				</td>
				<td>
					<c:out value="${orderDetail.orderList.orAmount}"/>
				</td>
				<td>
					<c:if test="${orderDetail.orderList.shippingStat=='배송중'}">
						<c:out value="${orderDetail.orderList.shippingStat}"/>
					</c:if>
					<c:if test="${orderDetail.orderList.shippingStat=='배송완료'}">
						<span class="text-success"><c:out value="${orderDetail.orderList.shippingStat}"/></span>
					</c:if>				
				</td>
				<td>
					<c:out value="${orderDetail.product.proPrice*orderDetail.orderList.orAmount}"/>원
				</td>
				<td>
				<!-- 주문한 상태일 경우 보여지는것 -->
				<div class="d-grid gap-2 d-md-flex">
				<c:if test="${orderDetail.orderList.orderStat==1}">
					<form action="<c:url value='/shippingList/buyCancel'/>" method="post">
						<input type="hidden" value="${orderDetail.orderList.proNo}" name="proNo">
						<input type="hidden" value="${orderDetail.orderList.orderNo}" name="orderNo">
						<input type="hidden" value="0" name="orderStat">
						<input type="hidden" value="${orderDetail.orderList.orAmount}" name="orAmount">
						<input type="submit" value="주문취소" class="btn btn-outline-danger btn-sm">
					</form>
					<!--반품 및 교환 에 쓰이는 자료들  -->
					<form action="<c:url value='/mypage/exchangeApp'/>" method="get">
						<input type="hidden" value="${orderDetail.orderInfo.orderNo}" name="orderNo">
						<input type="hidden" value="${orderDetail.orderList.proNo}" name="proNo">
						<input type="hidden" value="${orderDetail.orderList.orAmount}" name="orAmount">
						<input type="hidden" value="${orderDetail.orderInfo.orEmail}" name="orEmail">
						<input type="hidden" value="${orderDetail.orderInfo.orderer}" name="orderer">
						<input type="hidden" value="${orderDetail.product.proName}" name="proName">
						<input type="submit" value="반품 및 교환" class="btn btn-outline-info btn-sm">
					</form>					
					
					<form action="<c:url value='/shippingList/buyFinishExectute'/>" method="post">
						<input type="hidden" value="${orderDetail.orderList.proNo}" name="proNo">
						<input type="hidden" value="${orderDetail.orderList.orderNo}" name="orderNo">
						<input type="hidden" value="4" name="orderStat" >
						<input type="submit" value="구매완료" class="btn btn-outline-success btn-sm">	
					</form>
					</c:if>
					</div>
					<!-- 구매완료 상태일때 보여지는것 -->	
					<c:if test="${orderDetail.orderList.orderStat==4}">
						<span class="text-success">구매완료</span>
					</c:if>	
					<!-- 주문취소 상태에서 보여지는것 -->
					<c:if test="${orderDetail.orderList.orderStat==0}">
						<span class="text-danger">주문취소</span>
					</c:if>
					<!-- 교환 상태에서 보여지는것 -->
					<c:if test="${orderDetail.orderList.orderStat==3}">
						교환 중
					</c:if>
					<!-- 반품 상태에서 보여지는것 -->
					<c:if test="${orderDetail.orderList.orderStat==2}">
						반품 중
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>

</div>		
</body>
</html>