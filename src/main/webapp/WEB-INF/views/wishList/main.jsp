<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>위시리스트 페이지</title>
</head>
<body>
<jsp:include page ="../Header.jsp"/>
<div class="container">
	<div class="text-center"><span class="text-info"><h3>
	<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-bag-plus" viewBox="0 0 16 16">
  	<path fill-rule="evenodd" d="M8 7.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V12a.5.5 0 0 1-1 0v-1.5H6a.5.5 0 0 1 0-1h1.5V8a.5.5 0 0 1 .5-.5z"/>
  	<path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
	</svg>위시리스트</h3></span></div>
	<div align="left">
		<a href="<c:url value='/list/'/>">
			<input type="button" value="계속 쇼핑" class="btn btn-success">
		</a>
	</div>
	
		<table class="table">
			<tr class="table-primary">
				<td>제품 사진</td>
				<td>제품명</td>
				<td>적립금</td>
				<td>가격</td>
				<td></td>
			</tr>
				
					<c:forEach var="product" items="${products}">
						<tr class="table-light">
							<td>
								<a href="<c:url value='/product?proNo=${product.proNo}'/>">
								<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${product.proPhoto}'/>" alt="사진이 없습니다" class="rounded" height="100" width="100">
								</a>
							</td>
							<td>
								<a href="<c:url value='/product?proNo=${product.proNo}'/>">
									<c:out value='${product.proName}'/>
								</a>
							</td>
							<td><c:out value='${product.proSavedMoney}'/>원</td>
							<td><c:out value='${product.proPrice}'/>원</td>
						<form action="<c:url value='/wishlist/delList'/>" method="post">
							<td>
								<input type="hidden" value="${product.proNo}" name="proNo">
								<input type="submit" value="제품삭제" class="btn btn-danger btn-sm">
							</td>
						</form>
						</tr>
					</c:forEach>
					  
					
		</table>

	
</div>

</body>
</html>