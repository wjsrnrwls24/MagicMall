<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>로그인 실패 페이지</title>
</head>
<body>
	<script type="text/javascript">
		if(${checkNum}==1){
			alert("아이디를 입력해주세요");
		}else if(${checkNum}==2){
			alert("비밀번호를 입력해주세요");
		}else{
			alert("아이디 또는 비밀번호가 잘못 됬습니다");
		}
  		location.href="<c:url value='/user/login'/>"
	</script>
	
	
</body>
</html>