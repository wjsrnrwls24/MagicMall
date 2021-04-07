<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/css'/>/bootstrap.min.css" rel="stylesheet" />
<script src="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/js'/>/bootstrap.bundle.js"></script>
<style type="text/css"> 
a { text-decoration:none } 
</style>
<div class="container">
	<a href="<c:url value='/'/>">
		<img src="${pageContext.request.contextPath}/resources/images/main/메인 페이지 마술사 아이콘.jpg" class="rounded mx-auto d-block" height="200" width="200" >
	</a>
	<div align="right">	
		<a href="<c:url value='/user/login'/>">로그인</a>  <a href="<c:url value='/user/register'/>">회원가입</a> <a href="<c:url value='/userList'/>">  배송 조회</a>
	</div><br>

<nav class="navbar navbar-expand-lg navbar navbar-light" style="background-color: #e3f2fd;">
<div class="container-fluid">
 <div class="collapse navbar-collapse" id="navbarSupportedContent">
	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		<li class="nav-item">
	 		<a class="nav-link active" href="<c:url value='/list'/>">
	 			도구목록
		 	</a>
	 	</li>
	 	<li class="nav-item dropdown">
	 	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	 		도구종류
	 	</a>
	 	<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	 	 <li>
			 <a href="<c:url value='/list?category=카드'/>" class="dropdown-item">
				 #카드
			 </a>
		</li>
		<li>
		 	<a href="<c:url value='/list?category=동전'/>" class="dropdown-item">
		 		#동전
			 </a>
		</li>
		<li>
			 <a href="<c:url value='/list?category=실크'/>" class="dropdown-item">
				 #실크
			 </a>
		</li>
		<li>
			 <a href="<c:url value='/list?category=볼'/>" class="dropdown-item">
				 #볼
			 </a>
		</li>
		<li>
		 	<a href="<c:url value='/list?category=dvd'/>" class="dropdown-item">
				 #DVD렉처
			 </a>
		</li>
		<li>
		 	<a href="<c:url value='/list?category=무대'/>" class="dropdown-item">
				 #스테이지
			 </a>
		</li>
		<li>
			 <a href="<c:url value='/list?category=기타 도구'/>" class="dropdown-item">
				 #기타도구
			 </a>
		 </li>
		 </ul>
		 </li>
		 </ul>
		 <form name="findProduct" method="get" action="<c:url value='/list'/>" class="d-flex">
		<select name="condition" class="form-select">
						<option value="proName">제품명</option>
						<option value="proMaker">제작자</option>		
				   </select>
					<input type="text" name="keyword" id="keyword" class="form-control me-2" placeholder="제품 검색">
					<input type="submit" name="findButton" id="findButton" value="검색" class="btn btn-outline-success">	
	</form>
	 </div>
	 </div>
</nav>
</div>