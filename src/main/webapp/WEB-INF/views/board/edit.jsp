<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>게시물 수정 페이지</title>
</head>
<body>
<c:if test="${board.userNo!=0}">
	<jsp:include page="../userHeader.jsp" />
</c:if>
<c:if test="${board.userNo==0}">
	<jsp:include page ="../adminHeader.jsp"/>
</c:if>
<div class="container">
 <div class="col-lg-12">
		<div class="text-center"><h3>게시글 수정</h3><br></div>
		<form action="<c:url value='/board/editEx'/>" method="post" enctype="multipart/form-data">
		<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
			<label for="title" class="form-label"><span class='text-danger'>*제목</span></label>
			<input type="text" name="title" id="title" value="${board.title}" class="form-control">
		</div>
		<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
			<input type="file" name="file" id="file" class="form-control">
		</div>
		<div class="mb-3" style="width: 35%; float:none; margin:0 auto">
			<label for="exampleFormControlTextarea1" class="form-label"><span class='text-danger'>*내용</span></label>
			<textarea name="content" rows="5" class="form-control" id="exampleFormControlTextarea1">${board.content}</textarea>
		</div>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<input type="hidden" value="${board.postNo}" name="postNo">
			<input type="submit" value="수정하기" class="btn btn-success">
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