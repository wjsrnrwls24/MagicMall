<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>반품 교환 등록 실패 페이지</title>
</head>
<body>
<script type="text/javascript">
	
	if(${checkNum}==1){
		alert("필요정보를 전부 입력해주세요");
	}else{
		alert("이메일 또는 이유가 너무 깁니다 다시 입력해주세요");
	}	
	
	if(${returnExchange.userNo}!=0){//유저일 경우
		location.href="<c:url value='/mypage/exchangeApp?userNo=${returnExchange.userNo}&proNo=${returnExchange.proNo}&orAmount=${returnExchange.reExAmount}&orderNo=${returnExchange.orderNo}&orderer=${returnExchange.reExOrderer}&orEmail=${returnExchange.reExEmail}&proName=${proName}'/>";
	}else{
		location.href="<c:url value='/mypage/exchangeApp?proNo=${returnExchange.proNo}&orAmount=${returnExchange.reExAmount}&orderNo=${returnExchange.orderNo}&orderer=${returnExchange.reExOrderer}&orEmail=${returnExchange.reExEmail}&proName=${proName}'/>";
	}
	  		
		
  		
</script>