<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>매출 관리 페이지</title>
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">
	<div class="text-center"><h3>매출 관리</h3></div>
	<table class="table">
		<tr class="table-secondary">
			<td>제품 번호</td>
			<td>제품 사진</td>
			<td>제품명</td>
			<td>원가격</td>
			<td>팔린 수량</td>
			<td>팔린 가격</td>		
		</tr>
		<c:forEach var="product" items="${products}">
		<tr class="table-light">
			<td><c:out value='${product.proNo}'/></td>
			<td>
				<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${product.proPhoto}'/>" alt="이미지가 없습니다" class="rounded" height="100" width="100">
			</td>
			<td><c:out value='${product.proName}'/></td>
			<td><c:out value='${product.proPrice}'/>원</td>
			<td><c:out value='${product.proBuyNum}'/></td>
			<td><c:out value='${product.proBuyNum*product.proPrice}'/>원</td>	
			</tr>
		</c:forEach>
	</table>
	<div class="text-end"><span class="text-danger"><h3>총 수익: <c:out value="${allPrice}"/>원</h3></span><br></div>
	<!-- 페이징 처리 부분  -->
					<ul class="pagination justify-content-center">
						<c:if test="${pc.prev}" >
							<!-- 이전 버튼 -->
                       		<li class="page-item">
								<a href="<c:url value='/admin/saleStat${pc.makeURI(pc.beginPage-1)}'/>" class="page-link">이전</a>
							</li>
						</c:if>
						<!-- 페이지 버튼 -->
						<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
							<li class=" ${(pc.paging.page == pageNum) ? 'page-item active' : 'page-item'}">
						 	  <a href="<c:url value='/admin/saleStat${pc.makeURI(pageNum)}'/>" class="page-link">${pageNum}</a>
							</li>
						</c:forEach>
						<c:if test="${pc.next}">
					   <!-- 다음 버튼 -->
					   	 <li class="page-item">
					    	  <a href="<c:url value='/admin/saleStat${pc.makeURI(pc.endPage+1)}'/>" class="page-link">다음</a>
					   	 </li>
					    </c:if>
				    </ul>
	
</div>
</body>
</html>