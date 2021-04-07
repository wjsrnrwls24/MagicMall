<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/css'/>/bootstrap.min.css" rel="stylesheet" />
<script src="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/js'/>/bootstrap.bundle.js"></script>
<style type="text/css"> 
a { text-decoration:none } 
</style>
<div class="container">
	<script type="text/javascript">
		function outChk(){
       		if(confirm("로그아웃 하시겠습니까?")){
       			location.href="<c:url value='/user/logout'/>"
       		}
       		return false;
		}
	</script>
	<a href="<c:url value='/admin/main'/>">관리자 페이지
			<img src="${pageContext.request.contextPath}/resources/images/main/마법사 아이콘.jpg" class="rounded mx-auto d-block" height="200" width="200">
	</a>
	<div align="right">	
		<a href="#" onclick="outChk()">로그아웃</a>
	</div><br>
	<nav class="navbar navbar-expand-lg navbar navbar-light" style="background-color: #e3f2fd;">
		<div class="container-fluid">
 		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/admin/proList'/>">제품 목록</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/admin/user'/>">회원 목록</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/admin/saleStat'/>">매출 관리</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/admin/ordererList'/>">주문한 사람 목록</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/admin/ExRe'/>">반품 및 교환 내역</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/admin/FewAmount'/>">재고 부족 제품</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/board/list'/>">
				마술팁 게시판
			</a>
		</li>
	
	</ul>
	</div>
	</div>
	</nav>
	
	
	
</div>	
