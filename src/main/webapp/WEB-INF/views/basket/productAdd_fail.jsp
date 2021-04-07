<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>장바구니 담기 실패 페이지</title>
</head>
<body>
<script type="text/javascript">
			if(${checkNum}==1)	{
				alert("이미 있는 상품입니다");
				location.href="<c:url value='/basket/main'/>"
			}else if(${checkNum}==2){
				alert("수량 초과")
				location.href="<c:url value='/product?proNo=${proNo}'/>"
			}else{
				alert("수량을 확인해주세요")
				location.href="<c:url value='/product?proNo=${proNo}'/>"
			}
			
	  		
</script>

</body>
</html>