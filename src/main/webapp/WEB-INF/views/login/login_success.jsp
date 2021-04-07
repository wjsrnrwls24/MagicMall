<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>로그인 성공 페이지</title>
</head>
<body>
	<script type="text/javascript">
		if(${checkNum}==3){
			alert("로그인이 성공하였습니다");
	  		location.href="<c:url value='/user/main'/>"
		}else if(${checkNum}==5){
			alert("관리자 로그인이 성공하였습니다");
	  		location.href="<c:url value='/admin/main'/>"
		}else{
			alert("오류");
	  		location.href="<c:url value='/'/>"
		}
  		
	</script>
	
	
</body>
</html>