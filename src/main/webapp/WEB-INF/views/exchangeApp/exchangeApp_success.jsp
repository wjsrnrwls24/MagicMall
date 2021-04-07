<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>반품 교환 등록 성공 페이지</title>
</head>
<body>
<script type="text/javascript">
		alert("반품 및 교환 신청이 접수 되었습니다")
		if(${returnExchange.userNo}!=0){
			location.href="<c:url value='/mypage/orderList?userNo=${returnExchange.userNo}'/>"
		}else{
			location.href="<c:url value='/'/>"
		}
</script>
	
	

</body>
</html>