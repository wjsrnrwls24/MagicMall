<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>리뷰 등록 실패</title>
</head>
<body>
	<script type="text/javascript">
  	if(${check}==1){
  		alert("이름과 내용을 적어주세요");
  	}else if(${check}==2){
  		alert("이름은 10글자 후기는 30글자 입니다")
  		
  	}else{
  		alert("오류")
  	}
	
  	location.href="<c:url value='/product?proNo=${proNo}'/>"
	</script>
	

</body>
</html>