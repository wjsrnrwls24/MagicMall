<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>유저 주문 목록 페이지</title>
				

</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">
	<a href="<c:url value='/admin/user'/>">
		<input type="button" value="뒤로가기" class="btn btn-outline-danger">
	</a>
	<div class="text-center"><span class="text-info"><h3>${orderSearch.userId}님의 주문내역</h3></span></div>
	<div class="row g-3 justify-content-end">
		<div class="col-auto">
		<a href="<c:url value='/admin/userOrder?dateLength=1week&userNo=${orderSearch.userNo}&userId=${orderSearch.userId}'/>">
			<input type="button" value="1주일" class="btn btn-outline-primary btn-sm">
		</a>
		</div>
		<div class="col-auto">
		<a href="<c:url value='/admin/userOrder?dateLength=1month&userNo=${orderSearch.userNo}&userId=${orderSearch.userId}'/>">
			<input type="button" value="1개월" class="btn btn-outline-primary btn-sm">
		</a>
		</div>
		<div class="col-auto">
		<a href="<c:url value='/admin/userOrder?dateLength=3month&userNo=${orderSearch.userNo}&userId=${orderSearch.userId}'/>">
			<input type="button" value="3개월" class="btn btn-outline-primary btn-sm">
		</a>
		</div>
		<div class="col-auto">
		<a href="<c:url value='/admin/userOrder?dateLength=12month&userNo=${orderSearch.userNo}&userId=${orderSearch.userId}'/>">
			<input type="button" value="12개월" class="btn btn-outline-primary btn-sm"><br><br>
		</a>
		</div>
	</div>
	<table class="table">
		<tr class="table-primary">
			<td>주문일자</td>
			<td>제품 사진</td>
			<td>제품명</td>
			<td>주문수량</td>
			<td>배송현황</td>
			<td>결제금액</td>
			<td>주문상태</td>		
		</tr>
		<c:forEach var="orderDetail" items="${orderDetails}">
			
			<tr class="table-light">
				<td>					
					<fmt:formatDate value="${orderDetail.orderInfo.ordate}" pattern="yyyy/MM/dd"/>
				</td>
				<td>					
					<img src="${pageContext.request.contextPath}/resources/images/${orderDetail.product.proPhoto}" alt="사진이 없습니다" class="rounded" height="100" width="100">
				</td>
				<td>
					<c:out value="${orderDetail.product.proName}"/>
				</td>
				<td>
					<c:out value="${orderDetail.orderList.orAmount}"/>
				</td>
				<td>
					<c:out value="${orderDetail.orderList.shippingStat}"/>
				</td>
				<td>
					<c:out value="${orderDetail.product.proPrice*orderDetail.orderList.orAmount}"/>원
				</td>
				<td>				
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
						<span class="text-warning">교환 중</span>
					</c:if>
					<!-- 반품 상태에서 보여지는것 -->
					<c:if test="${orderDetail.orderList.orderStat==2}">
						<span class="text-warning">반품 중</span>
					</c:if>
				</td>
				</tr>
		</c:forEach>
	</table>
	<br><form action="<c:url value='/admin/userOrder'/>" method="get" class="row g-3 justify-content-end">
			<div class="col-auto">
				<input type="text" name="keyword" placeholder="제품명" class="form-control">
			</div>
			<input type="hidden" value="proName" name="condition">
			<input type="hidden" value="${orderSearch.userNo}" name="userNo">
			<input type="hidden" value="${orderSearch.userId}" name="userId">
			<div class="col-auto">
				<input type="submit" value="검색" class="btn btn-outline-primary">
			</div>
		</form>
</div>
</body>
</html>