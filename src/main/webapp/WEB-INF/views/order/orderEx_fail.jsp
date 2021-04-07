<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>주문 실패 페이지</title>
</head>
<body>
	<script type="text/javascript">
		if(${checkNum}==1){
			alert("정보를 전부 입력해주세요. 중복 구매 방지를 위해 제품 리스트로 이동합니다");
	  	}else if(${checkNum}==2){
			alert("각 입력칸에 비정상적으로 길게 입력하셨습니다. 정상적인 정보를 입력해주세요");
	  	}else{
			alert("주문실패");
	  	}
		
		location.href="<c:url value='/list'/>"
  		
	</script>
	

</body>
</html>