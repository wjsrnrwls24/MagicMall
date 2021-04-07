<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>관리자 제품 목록</title>
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">	
		<div class="text-center"><span class='text-info'><h3>제품 목록</h3></span></div>
		<div align="right">
			<form action="<c:url value='/admin/proList'/>" method="get">
				<input type="hidden" name="mostSale" value="mostSale">
				<input type="submit" value="많이 팔린 순" class="btn btn-secondary btn-sm">
			</form>
		</div>
		<table class="table table-hover">
			<tr class="table-primary">
				<td>제품번호</td>
				<td>제품 사진</td>
				<td>제품명</td>
				<td>가격</td>
				<td>수량</td>
			</tr>			
				<c:forEach var="product" items="${products}">
						<tr class="table-light">
								<td>
									<a href="<c:url value='/admin/proDetail?proNo=${product.proNo}'/>" class="link-dark">
										<c:out value="${product.proNo}" />
									</a>
								</td>
    							<td>
    								<a href="<c:url value='/admin/proDetail?proNo=${product.proNo}'/>" class="link-dark">
    									<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${product.proPhoto}'/>" alt="사진이 없습니다" class="rounded" height="100" width="100">
    								</a>
    							</td>
								<td>
									<a href="<c:url value='/admin/proDetail?proNo=${product.proNo}'/>" class="link-dark">
										<c:out value="${product.proName}" />
									</a>
								</td>
								<td><c:out value="${product.proPrice}" />원</td>
								<td><c:out value="${product.proAmount}" /></td>
							</tr>
						
				</c:forEach>
		</table>
		<!-- 페이징 처리 부분  -->
					<ul class="pagination justify-content-center">
						<c:if test="${pc.prev}" >
							<!-- 이전 버튼 -->
                       		<li class="page-item">
								<a href="<c:url value='/admin/proList${pc.makeURI(pc.beginPage-1)}'/>" class="page-link">이전</a>
							</li>
						</c:if>
						<!-- 페이지 버튼 -->
						<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
							<li class=" ${(pc.paging.page == pageNum) ? 'page-item active' : 'page-item'}">
						 	  <a href="<c:url value='/admin/proList${pc.makeURI(pageNum)}'/>" class="page-link">${pageNum}</a>
							</li>
						</c:forEach>
						<c:if test="${pc.next}">
					   <!-- 다음 버튼 -->
					   	 <li class="page-item">
					    	  <a href="<c:url value='/admin/proList${pc.makeURI(pc.endPage+1)}'/>" class="page-link">다음</a>
					   	 </li>
					    </c:if>
				    </ul>
	
		<form action="<c:url value='/admin/proList'/>" method="get" class="row g-3 justify-content-end">
			<input type="hidden" name="condition" value="proName">
			<div class="col-auto">
				<input type="text" name="keyword" id="keyword" class="form-control" placeholder="제품명">
			</div>
			<div class="col-auto">
				<input type="submit" value="검색" class="btn btn-outline-primary">
			</div>
		</form>
		
		<a href="<c:url value='/admin/proAdd'/>">
			<input type="button" value="제품 등록" class="btn btn-outline-dark">
		</a>
</div>
</body>
</html>