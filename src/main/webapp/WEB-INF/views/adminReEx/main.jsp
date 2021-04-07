<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>반품 및 교환 현황</title>
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">
	<div class="text-center"><span class='text-info'><h3>반품 및 교환 신청 내역</h3></span></div>
	<table class="table table-hover">
		<tr class="table-primary">
			<td>주문번호</td>
			<td>주문자</td>
			<td>제품사진</td>
			<td>제품명</td>
			<td>가격</td>
			<td>수량</td>
			<td></td>
		</tr>
		<c:forEach var="reExList" items="${reExLists}">
		<tr class="table-light">
			<td>
				<a href="<c:url value='/admin/ExReAppli?orderNo=${reExList.returnExchange.orderNo}&proNo=${reExList.returnExchange.proNo}'/>">
					<c:out value='${reExList.orderInfo.orderNo}'/>
				</a>
			</td>
			<td>
				<a href="<c:url value='/admin/ExReAppli?orderNo=${reExList.returnExchange.orderNo}&proNo=${reExList.returnExchange.proNo}'/>">
					<c:out value='${reExList.orderInfo.orderer}'/>
				</a>
			</td>
			<td>
				<a href="<c:url value='/admin/ExReAppli?orderNo=${reExList.returnExchange.orderNo}&proNo=${reExList.returnExchange.proNo}'/>">
					<img src="${pageContext.request.contextPath}/resources/images/reExImages/<c:out value='${reExList.product.proPhoto}'/>" alt="이미지가 없습니다" class="rounded" height="100" width="100">
				</a>
			</td>
			<td>
				<a href="<c:url value='/admin/ExReAppli?orderNo=${reExList.returnExchange.orderNo}&proNo=${reExList.returnExchange.proNo}'/>">
					<c:out value='${reExList.product.proName}'/>
				</a>
			</td>
			<td><c:out value='${reExList.product.proPrice}'/>원</td>
			<td><c:out value='${reExList.returnExchange.reExAmount}'/></td>
			<td>
				<form action="<c:url value='/admin/ExReExecute'/>" method="post">
					<input type="hidden" value="${reExList.returnExchange.orderNo}" name="orderNo">
					<input type="hidden" value="${reExList.returnExchange.proNo}" name="proNo">
					<input type="hidden" value="${reExList.returnExchange.reExAmount}" name="reExAmount">
					<input type="hidden" value="${reExList.returnExchange.reExChoose}" name="reExChoose">
					<input type="submit" value="승인" class="btn btn-success btn-sm">
				</form>
			</td>
			</tr>
		</c:forEach>
	
	</table>
</div>
</body>
</html>