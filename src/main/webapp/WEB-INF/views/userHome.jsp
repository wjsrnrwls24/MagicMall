<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>유저 화면</title>
</head>
<body>
<jsp:include page ="userHeader.jsp"/>
<div class="container">
<div class="text-center">
<span class="text-info"><h3>신제품</h3></span></div>
<table class="table justify-content-center">
	<tr>
	<c:forEach var="product" items="${products}" begin="0" end="4">
		<td>
			<input type="hidden" name="proNo" value="${product.proNo}" id="proNo">
									<a href="<c:url value='/product?proNo=${product.proNo}'/>" >
    									<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${product.proPhoto}'/>" alt="이미지가 없습니다" class="rounded" height="200" width="200" ><br>
    								</a>    							
									<a href="<c:url value='/product?proNo=${product.proNo}'/>" class="link-secondary">
										<h4><c:out value="${product.proName}" /></h4><br>
									</a>								
								<c:out value="${product.proPrice}" />원<br>
								구매:<c:out value="${product.proBuyNum}" /><br>
								<c:if test="${product.proAmount==0}">
									<span class="text-danger">품절</span>
								</c:if>
								<c:if test="${product.proBuyNum<50}">
									<span class="text-warning">신상품</span>
								</c:if>
								<form action="<c:url value='/basket/productAdd'/>" method="get">
									<input type="hidden" name="userNo" value="${userNo}">
									<input type="hidden" name="proNo" value="${product.proNo}">
									<input type="hidden" name="shopOrAmount" value="1">
									<input type="submit" value="장바구니 추가" class="btn btn-outline-primary btn-sm">
								</form>
							</td>
							</c:forEach>
</tr>
</table>
</div>
</body>
</html>