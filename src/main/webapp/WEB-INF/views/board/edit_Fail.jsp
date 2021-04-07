<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>게시글 수정 실패 페이지</title>
</head>
<body>
	<script type="text/javascript">
		if(${checkNum}==1){
			alert("빈칸이 있습니다");
		}else if(${checkNum}==2){
			alert("제목 또는 내용이 너무 깁니다");
		}
		
  		location.href="<c:url value='/board/edit?postNo=${article.postNo}&title=${board.title}&content=${board.content}'/>"
	</script>
	
	
</body>
</html>