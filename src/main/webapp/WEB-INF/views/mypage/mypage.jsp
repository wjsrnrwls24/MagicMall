<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>마이 페이지</title>
	<script type="text/javascript">
		function outChk2(){
       		if(confirm("정말 탈퇴하시겠습니까?")){
       			location.href="<c:url value='/mypage/userDropEx'/>"
       		}
       		return false;
		}
	</script>
	
</head>
<body>
<jsp:include page ="../userHeader.jsp"/>
<div class="container">
<div class="col-sm-6" style="width: 50%; float:none; margin:0 auto">
	<div class="card">
		<div class="card-header text-center card text-white bg-secondary mb-3"><h3>${user.id}님 환영합니다</h3></div><br>
		<div class="card-body bg-light text-center">
			<h3>현재 사용가능 적립 금액 : <span class="text-info">${user.savedMoney}원</span></h3>
		</div>
		<div class="card-footer">
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<a href="#" onclick="outChk2()">
				<input type="button" value="회원 탈퇴" class="btn btn-outline-danger">
			</a>
			<a href ="<c:url value='/mypage/address?userNo=${user.userNO}'/>">
				<input type="button" value="배송 주소록 관리" class="btn btn-outline-primary">
			</a>
			<a href ="<c:url value='/user/edit'/>">
				<input type="button" value="회원정보 수정" class="btn btn-outline-primary">
			</a>
			<a href ="<c:url value='/mypage/orderList?userNo=${user.userNO}'/>">
				<input type="button" value="주문내역 조회" class="btn btn-outline-primary">
			</a>
		</div>
	</div>
	</div>
</div>
</div>
</body>
</html>