<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<script type="text/javascript">
		if(${checkNum}==1){
			alert("필요정보를 등록해주세요");
		}else if(${checkNum}==2){
			alert("가격과 수량을 확인해 주세요");			
		}else{
			alert("오류");	
		}
		
		location.href="<c:url value='/admin/proEdit?proNo=${proNo}'/>"  		
	</script>

</body>
</html>