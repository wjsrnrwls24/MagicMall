<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>배송 주소록 페이지</title>
</head>
<body>
<jsp:include page ="../userHeader.jsp"/>
<div class="container">
	
		<div class="text-center"><h3>배송 주소록</h3></div><br>
		<a href="<c:url value='/mypage'/>">
			<input type="button" value="뒤로가기" class="btn btn-outline-secondary"/>
		</a>	
		<table class="table">
				<tr class="table-info">
					<td>주소지 등록 번호</td>
					<td>주소지 이름</td>
					<td>주소</td>
					<td></td>
				</tr>
				<c:forEach var="address" items="${addresses}">
					<form  action="<c:url value='/mypage/addressDeleteEx'/>" method="post">
						<input type="hidden" id="userNo" name="userNo" value="${userNo}"/>
						<input type="hidden" id="addNo" name="addNo" value="${address.addNo}"/>
						<tr class="table-light">					
    						<td><c:out value="${address.addNo}" /></td>
							<td><c:out value="${address.addName}" /></td>
							<td><c:out value="${address.address}" /></td>
							<td>
								<input type="submit" value="삭제" class="btn btn-outline-danger btn-sm">
							<a href="<c:url value='/mypage/addressEdit?addNo=${address.addNo}'/>">
								<input type="button" value="수정" class="btn btn-outline-warning btn-sm">
							</a>
							</td>
						</tr>
					</form>
				</c:forEach>
		</table>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<a href="<c:url value='/mypage/addressAdd?userNo=${userNo}'/>">
				<input type="button" value="주소지 등록" class="btn btn-outline-primary">
			</a>
		</div>
			
	
</div>












</body>
</html>