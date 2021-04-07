<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- 포맷팅 관련 태그라이브러리 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>마술 게시판 리스트</title>
</head>
<body>
<c:if test="${userNo!=0}">
	<jsp:include page="../userHeader.jsp" />
</c:if>
<c:if test="${userNo==0}">
	<jsp:include page ="../adminHeader.jsp"/>
</c:if>
<div class="container">
	<span class="text-center"><h3>마술 팁 게시판</h3></span>
</div>
<div class="container">
		<table class="table table-striped table-hover" >
			<tr class="table-dark">
				<td>번호</td>
				<td>제목</td>
				<td>작성일</td>			
			</tr>
			<c:forEach var="article" items="${articles}">
				<tr class="table-light">
					<td scope="row">
						<a href="<c:url value='/board/content?postNo=${article.postNo}'/>" class="link-dark">
							<c:out value="${article.postNo}"/>
						</a>
					</td>
					<td>
						<a href="<c:url value='/board/content?postNo=${article.postNo}'/>" class="link-dark">
							<c:out value="${article.title}"/>
						</a>
					</td>
					<td>
						<fmt:formatDate value="${article.postDate}" pattern="yyyy/MM/dd"/>					
					</td>				
				</tr>			
			</c:forEach>		
		</table><br>
		<c:if test="${userNo!=0}">
		<a href="<c:url value='/board/register'/>">
			<input type="button" value="게시글 등록" class="btn btn btn-success">
		</a>
		</c:if>
		<form action="<c:url value='/board/list'/>" method="get" class="row g-3 justify-content-end">
			<div class="col-auto">
				<input type="text" name="keyword" class="form-control" placeholder="제목 검색">
			</div>
			<input type="hidden" value="title" name="condition">
			<div class="col-auto">
				<input type="submit" value="검색" class="btn btn-outline-secondary">
			</div>
		</form>
				
		<!-- 페이징 처리 부분  -->
					<ul class="pagination justify-content-center">
						<c:if test="${pc.prev}" >
							<!-- 이전 버튼 -->
                       		<li class="page-item">
								<a class="page-link" href="<c:url value='/board/list${pc.makeURI(pc.beginPage-1)}'/>">이전</a>
							</li>
						</c:if>
						<!-- 페이지 버튼 -->
						<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
							<li class=" ${(pc.paging.page == pageNum) ? 'page-item active' : 'page-item'}">
						 	  <a href="<c:url value='/board/list${pc.makeURI(pageNum)}'/>" class="page-link"  >${pageNum}</a>
							</li>
						</c:forEach>
						<c:if test="${pc.next}">
					   <!-- 다음 버튼 -->
					   	 <li class="page-item">
					    	  <a class="page-link" href="<c:url value='/board/list${pc.makeURI(pc.endPage+1)}'/>">다음</a>
					   	 </li>
					    </c:if>
				    </ul>
				 </div>

</body>
</html>