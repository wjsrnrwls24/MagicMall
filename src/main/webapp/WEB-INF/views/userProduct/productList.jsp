<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>제품 리스트</title>
<script src="https://kit.fontawesome.com/64a89b0e42.js" crossorigin="anonymous"></script>
</head>
<body>
<c:if test="${userNo==null}">
	<jsp:include page ="../Header.jsp"/>
</c:if>
<c:if test="${userNo!=null}">
	<jsp:include page ="../userHeader.jsp"/>
</c:if>
<div class="container">
	<c:if test="${search.category!=null}">
		<div align="left">${search.category}></div>
	</c:if>
		<div class="text-center"><h3><i class="fas fa-search"></i>상세검색</h3></div>
		<form action="<c:url value='/list'/>" method="get">
		<table class="table">
			<tr>
				<td>상품 종류</td>
				<td><select name="category" class="form-select" style="width: 30%;">
									<option value="카드" selected>카드</option>
									<option value="동전 ">동전</option>
									<option value="dvd">dvd</option>
									<option value="실크">실크</option>
									<option value="볼">볼</option>
									<option value="무대">무대</option>
									<option value="기타 도구">기타 도구</option>
								</select>
				</td>
			</tr>
			<tr>
			<td>판매 가격대</td>
			<td>
				<div class="d-grid gap-2 d-md-flex">
					<input type="Number" name="lowPrice" step="10000" value="0" class="form-control" style="width: 20%;">
					~<input type="Number" name="highPrice" step="10000" value="10000" class="form-control" style="width: 20%;">
					<span class="text-danger">*10000원 단위</span>
				</div>
			</td>
			</tr>
			<tr>
			<td>제품명</td>
				<td>
					<div class="d-grid gap-2 d-md-flex">
						<input type="text" name="keyword" class="form-control" style="width: 45%;">
						<input type="hidden" value="proName" name="condition">
						<input type="submit" value="검색" class="btn btn-outline-success">
					</div>
				</td>
			</tr>
		</table>
		</form>		
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
	<c:if test="${search.category==null}">
		<a href="<c:url value='/list?priceSet=highestPrice'/>">
			<input type="button" value="높은 가격순" class="btn btn-outline-secondary btn-sm">
		</a>
		<a href="<c:url value='/list?priceSet=lowestPrice'/>">
			<input type="button" value="낮은 가격순" class="btn btn-outline-secondary btn-sm">
		</a>
	</c:if>
	<c:if test="${search.category!=null}">
		<a href="<c:url value='/list?category=${search.category}&priceSet=highestPrice'/>">
			<input type="button" value="높은 가격순" class="btn btn-outline-secondary btn-sm">
		</a>
		<a href="<c:url value='/list?category=${search.category}&priceSet=lowestPrice'/>">
			<input type="button" value="낮은 가격순" class="btn btn-outline-secondary btn-sm">
		</a>
	</c:if>
	</div>	
	
	
	
	
	<div class="text-center"><h3><i class="fas fa-search"></i>결과</h3></div>
	
		<table class="table">
		<c:forEach var="product" items="${products}">
			<input type="hidden" name="proNo" value="${product.proNo}" id="proNo">
			<tr>
				<td style="width: 20%;">
					<a href="<c:url value='/product?proNo=${product.proNo}'/>">
    					<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${product.proPhoto}'/>" alt="사진이 없습니다" class="rounded float-end" height="200" width="200">
    				</a>
    			</td>
    			<td>						
					<a href="<c:url value='/product?proNo=${product.proNo}'/>" class="link-dark">
						<span class="fs-3"><c:out value="${product.proName}"/></span><br>
					</a>								
					<span class="fs-5"><c:out value="${product.proPrice}" />원</span><br>
					<span class="text-break"><c:out value="${product.proDetail}"/></span><br>
					<span class="fs-5">구매:<c:out value="${product.proBuyNum}" /></span><br>
					<c:if test="${product.proAmount==0}">
					<div class="fs-5" ><span class="text-danger">품절</span></div>
					</c:if>
					<c:if test="${product.proBuyNum<50}">
						<div class="fs-5" ><span class="text-info">신상품</span></div>
					</c:if>
					<c:if test="${userNo!=null}">
						<form action="<c:url value='/basket/productAdd'/>" method="get">
							<input type="hidden" name="userNo" value="${userNo}">
							<input type="hidden" name="proNo" value="${product.proNo}">
							<input type="hidden" name="shopOrAmount" value="1">
							<input type="submit" value="장바구니 추가" class="btn btn-outline-success btn-sm">
						</form>
					</c:if>						
					</td>		
					</tr>	
				</c:forEach>
		</table>
		<!-- 페이징 처리 부분  -->
					<ul class="pagination justify-content-center">
						<c:if test="${pc.prev}" >
							<!-- 이전 버튼 -->
                       		<li class="page-item">
								<a href="<c:url value='/list${pc.makeURI(pc.beginPage-1)}'/>" class="page-link">이전</a>
							</li>
						</c:if>
						<!-- 페이지 버튼 -->
						<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
							<li class=" ${(pc.paging.page == pageNum) ? 'page-item active' : 'page-item'}">
						 	  <a href="<c:url value='/list${pc.makeURI(pageNum)}'/>" class="page-link">${pageNum}</a>
							</li>
						</c:forEach>
						<c:if test="${pc.next}">
					   <!-- 다음 버튼 -->
					   	 <li class="page-item">
					    	  <a href="<c:url value='/list${pc.makeURI(pc.endPage+1)}'/>" class="page-link">다음</a>
					   	 </li>
					    </c:if>
				    </ul>
		
	
	
	
</div>
</body>
</html>