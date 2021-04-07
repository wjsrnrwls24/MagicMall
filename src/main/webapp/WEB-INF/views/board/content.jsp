<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>게시글 페이지</title>
</head>
<body>
<c:if test="${userNo!=0}">
	<jsp:include page="../userHeader.jsp" />
</c:if>
<c:if test="${userNo==0}">
	<jsp:include page ="../adminHeader.jsp"/>
</c:if>
<div class="container">
<div class="text-center"><h3>게시물</h3></div>
	<table class="table table-bordered">
		<tr>
			<td class="table-active">제목</td>
			<td class="table-light">${board.title}</td>
		</tr>
		<tr>
			<td class="table-active">내용</td>
			<td class="table-light">
				<img src="${pageContext.request.contextPath}/resources/images/board/${board.picName}" alt="사진이 없습니다" class="rounded" height="200" width="200"><br><br>
				${board.content}
			</td>	
		</tr>	
	</table>
	<div class="d-grid gap-2 d-md-flex justify-content-md-center">
	<c:if test="${userNo==board.userNo}">		
			<a href="<c:url value='/board/edit?postNo=${board.postNo}&title=${board.title}&content=${board.content}'/>">
				<input type="button" value="수정하기" class="btn btn-primary">
			</a>		
		<form action="<c:url value='/board/deleteEx'/>" method="post">
			<input type="hidden" value="${board.postNo}" name="postNo">		
			<input type="submit" value="삭제하기" class="btn btn-success">	
		</form>	
	</c:if>
	<c:if test="${userNo==0}">
		<form action="<c:url value='/board/deleteEx'/>" method="post">
			<input type="hidden" value="${board.postNo}" name="postNo">		
			<input type="submit" value="삭제하기" class="btn btn-success">	
		</form>		
	</c:if>
	</div>
</div>
</body>
</html>