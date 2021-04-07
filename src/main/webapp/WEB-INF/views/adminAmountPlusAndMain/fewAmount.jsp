<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>재고 부족 제품</title>
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">
<div class="text-center"><span class="text-danger"><h3>재고 부족 제품</h3></span></div>
	<table class="table table-striped table-hover">
		<tr class="table-primary">
			<td>제품 번호</td>		
			<td>제품 사진</td>		
			<td>제품명</td>		
			<td>가격</td>		
			<td>수량</td>		
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>
					<a href="<c:url value='/admin/proEdit?proNo=${product.proNo}'/>" class="link-secondary">
						<c:out value='${product.proNo}'/>
					</a>
				</td>
				<td>
					<a href="<c:url value='/admin/proEdit?proNo=${product.proNo}'/>" class="link-secondary">
						<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${product.proPhoto}'/>" alt="이미지가 없습니다" class="rounded" height="100" width="100">
					</a>
				</td>
				<td>
					<a href="<c:url value='/admin/proEdit?proNo=${product.proNo}'/>" class="link-secondary">
						<c:out value='${product.proName}'/>
					</a>
				</td>
				<td><c:out value='${product.proPrice}'/>원</td>
				<td><c:out value='${product.proAmount}'/></td>
			</tr>
		</c:forEach>	
	</table>
</div>
</body>
</html>