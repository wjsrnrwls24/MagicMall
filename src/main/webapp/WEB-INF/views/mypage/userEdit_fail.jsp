<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 정보 수정 성공</title>
</head>
<body>
	<script type="text/javascript">
  		if(${checkNum}==1){
  			alert("공백이 있거나 입력길이가 너무 깁니다");
  		}else if(${checkNum}==2){
  			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
  		}else if(${checkNum}==3){
  			alert("비밀번호는 영문 대소문자를 포함한 4~16자 입니다");
  		}else{
  			alert("오류");
  		}
  		location.href="<c:url value='/mypage'/>"
	</script>
</body>
</html>