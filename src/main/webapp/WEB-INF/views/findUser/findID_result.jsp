<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>아이디 찾기 결과 페이지</title>
	
<script language="javascript">
  function selfClose() { 
	  self.close(); 
	  }
  </script>
<link href="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/css'/>/bootstrap.min.css" rel="stylesheet" />
<script src="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/js'/>/bootstrap.bundle.js"></script>
</head>
<body>
	
	<div class="text-center"><h3><p>${email}님의 아이디는</p></h3><br><br>
		<c:forEach var="user" items="${users}">
    		<span class="text-danger"><c:out value="${user.id}" /></span><br>
		</c:forEach>
		<br><br>
		<h3>입니다</h3><br>
	</div>
	
			<input type="button" value="로그인" onclick="selfClose()" class="btn btn-outline-success" >
	
	
			<a href="<c:url value='/user/findPass'/>">
				<input type="button" value="비밀번호 찾기" class="btn btn-outline-info">
			</a>
	
		
	

</body>
</html>