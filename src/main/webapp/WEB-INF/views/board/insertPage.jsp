<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>게시물 등록 페이지</title>
</head>
<body>
<c:if test="${userNo!=0}">
	<jsp:include page="../userHeader.jsp" />
</c:if>
<c:if test="${userNo==0}">
	<jsp:include page ="../adminHeader.jsp"/>
</c:if>
<div class="container">
		<div class="text-center"><h3>게시글 등록</h3><br>
		<form action="<c:url value='/board/registerEx'/>" method="post" enctype="multipart/form-data">
		<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
			<label for="title" class="form-label"><span class='text-danger'>*제목</span></label>
			<input type="text" name="title" id="title" class="form-control" placeholder="제목 입력" style="width: 18rem;">
		</div>
		<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
			<input type="file" name="file" id="file" class="form-control" style="width: 18rem;">
		</div>
		<div class="mb-3" style="width: 35%; float:none; margin:0 auto">
  		<label for="exampleFormControlTextarea1" class="form-label"><span class='text-danger'>*내용</span></label>
			<textarea class="form-control" id="exampleFormControlTextarea1" name="content" rows="5" style="width: 30rem;"></textarea>
		</div>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<input type="hidden" value="${userNo}" name="userNo">
			<input type="submit" value="등록하기"  class="btn btn-success">
		</div>
		</form>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
		<a href="<c:url value='/board/list'/>">
			<input type="button" value="취소하기" class="btn btn-danger">
		</a>
		</div>
</div>
</div>
</body>
</html>