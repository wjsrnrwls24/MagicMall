<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	
	
</head>
<body>
<jsp:include page ="Header.jsp"/>
<div class="container">

<div class="text-center"><span class="text-info"><h3>신제품</h3></span></div>
	<table class="table justify-content-center">
	<tr>
	<c:forEach var="product" items="${products}" begin="0" end="4">
			<input type="hidden" name="proNo" value="${product.proNo}" id="proNo">
								
							<td>
							<a href="<c:url value='/product?proNo=${product.proNo}'/>">
    							<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${product.proPhoto}'/>" alt="이미지가 없습니다" class="rounded" height="200" width="200" ><br>
    						</a>
    												    							
									<a href="<c:url value='/product?proNo=${product.proNo}'/>" class="link-secondary">
										<h4><c:out value="${product.proName}" /></h4><br>
									</a>								
								<c:out value="${product.proPrice}" />원<br>
								
								구매:<c:out value="${product.proBuyNum}"/><br>
								<c:if test="${product.proAmount==0}">
									<span class="text-danger">품절</span>
								</c:if>
								<c:if test="${product.proBuyNum<50}">
									<span class="text-warning">신상품</span><br>
								</c:if>
								</td>
								
								</c:forEach>
								</tr>
	</table>
</div>
</body>
</html>
