<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>유저 목록 페이지</title>
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">
<div class="text-center"><span class="text-info"><h3>회원 목록</h3></span></div>
	<table class="table">
		<tr class="table-primary">
			<td>번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>가입날짜</td>
		</tr>
		<c:if test="${users!=null}">
		<c:forEach var="user" items="${users}">
			<tr class="table-light">
				<td>
					<a href="<c:url value='/admin/userOrder?userId=${user.id}&userNo=${user.userNO}'/>" class="link-secondary">
						<c:out value="${user.userNO}"/>
					</a>
				</td>
				<td>
					<a href="<c:url value='/admin/userOrder?userId=${user.id}&userNo=${user.userNO}'/>" class="link-secondary">
						<c:out value="${user.id}"/>	
					</a>		
				</td>
				<td>
					<a href="<c:url value='/admin/userOrder?userId=${user.id}&userNo=${user.userNO}'/>" class="link-secondary">
						<c:out value="${user.name}"/>	
					</a>		
				</td>
				<td>
					<c:out value="${user.email}"/>			
				</td>
				<td>
					<c:out value="${user.pNumber}"/>			
				</td>
				<td>
					<fmt:formatDate value="${user.regDate}" pattern="yyyy/MM/dd"/>			
				</td>			
			</tr>		
		</c:forEach>
		</c:if>
		<c:if test="${fn:length(users)==0}">
			<tr>
				<td colspan="6"><div class="text-center"><span class="text-danger"><h3>검색 결과가 없습니다.</h3></span></div></td>
			</tr>			
		</c:if>	
	</table><br>
	<form action="<c:url value='/admin/userFind'/>" method="get" class="row g-3 justify-content-end">
		<div class="col-auto">
			<input type ="text" name="id" class="form-control" placeholder="아이디">
		</div>
		<div class="col-auto">
			<input type="submit" value="검색" class="btn btn-outline-primary">
		</div>
	</form>
</div>
</body>
</html>