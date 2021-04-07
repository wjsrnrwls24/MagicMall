<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>수량 수정 실패 페이지</title>
</head>
<body>
<script type="text/javascript">
			if(${checkNum}==1)	{
				alert("수량을 확인해주세요");
			}else if(${checkNum}==2){
				alert("현재 재품의 제고가"+${proAmount}+"개 남았습니다. 수량을 조정해 주세요")
			}
			
			location.href="<c:url value='/basket/main'/>"	  		
</script>