<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
	<title>현재 주문 목록</title>
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">
	<div class="text-center"><h3>현재 주문내역</h3></div>
	<table class="table">
		<tr class="table-secondary">
			<td>주문일자</td>
			<td>주문번호</td>
			<td>제품 사진</td>
			<td>제품명</td>
			<td>수량</td>
			<td>주문자</td>
			<td></td>		
		</tr>
		
		<c:forEach var="orderDetail" items="${orderDetails}">
		<c:if test="${orderDetail.orderList.shippingStat!='배송완료'}">
			<tr class="table-light">
				<td>					
					<fmt:formatDate value="${orderDetail.orderInfo.ordate}" pattern="yyyy/MM/dd"/>
				</td>
				<td>
					<c:out value="${orderDetail.orderInfo.orderNo}"/>
				</td>
				<td>					
					<img src="${pageContext.request.contextPath}/resources/images/${orderDetail.product.proPhoto}" alt="이미지가 없습니다" class="rounded" height="100" width="100">
				</td>
				<td>
					<c:out value="${orderDetail.product.proName}"/>
				</td>
				<td>
					<c:out value="${orderDetail.orderList.orAmount}"/>
				</td>
				<td>
					<c:out value="${orderDetail.orderInfo.orderer}"/>
				</td>
				<td>
					<form action="<c:url value='/admin/orderFinishEx'/>" method="post">
						<input type="hidden" value="${orderDetail.orderInfo.orderNo}" name="orderNo">
						<input type="hidden" value="${orderDetail.product.proNo}" name="proNo">
						<input type="submit" value="배송완료" class="btn btn-success btn-sm">
					</form>
				</td>
			</tr>
			</c:if>
		</c:forEach>	
	</table>
	<form action="<c:url value='/admin/ordererList'/>" method="get" class="row g-3 justify-content-end">
		<input type="hidden" value="orderer" name="condition">
		<div class="col-auto">
			<input type="text" name="keyword" class="form-control" placeholder="주문자 검색">
		</div>
		<div class="col-auto">
			<input type="submit" value="검색" class="btn btn-outline-primary">
		</div>
	</form>
	
		<!-- 페이징 처리 부분  -->
					<ul class="pagination justify-content-center">
						<c:if test="${pc.prev}" >
							<!-- 이전 버튼 -->
                       		<li class="page-item">
								<a href="<c:url value='/admin/ordererList${pc.makeURI(pc.beginPage-1)}'/>" class="page-link">이전</a>
							</li>
						</c:if>
						<!-- 페이지 버튼 -->
						<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
							<li class=" ${(pc.paging.page == pageNum) ? 'page-item active' : 'page-item'}">
						 	  <a href="<c:url value='/admin/ordererList${pc.makeURI(pageNum)}'/>" class="page-link">${pageNum}</a>
							</li>
						</c:forEach>
						<c:if test="${pc.next}">
					   <!-- 다음 버튼 -->
					   	 <li class="page-item">
					    	  <a href="<c:url value='/admin/ordererList${pc.makeURI(pc.endPage+1)}'/>" class="page-link">다음</a>
					   	 </li>
					    </c:if>
				    </ul>
</div>
</body>
</html>