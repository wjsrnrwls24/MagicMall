<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>제품 등록 페이지</title>
</head>
<body>
<jsp:include page ="../adminHeader.jsp"/>
<div class="container">		
		<div class="text-center"><h3>제품 수정</h3></div>
		<form action="<c:url value='/admin/proEditEx'/>" method="post" enctype="multipart/form-data">
			<input type="hidden" name="proNo" value="${product.proNo}">
			<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
				<label for="proName" class="form-label"><span class='text-danger'>*제품명</span></label>
				<input type="text" name="proName" id="proName" value="${product.proName}" class="form-control">
			</div>
			<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
				<label for="proMaker" class="form-label"><span class='text-danger'>*제조사</span></label>
				<input type="text" name="proMaker" id="proMaker" value="${product.proMaker}" class="form-control">
			</div>
			<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
				<label for="proPrice" class="form-label"><span class='text-danger'>*가격</span></label>
				<input type="Number" name="proPrice" id="proPrice" value="${product.proPrice}" class="form-control">
			</div>
			<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
				<label for="proAmount" class="form-label"><span class='text-danger'>*수량</span></label>
				<input type="Number" name="proAmount" id="proAmount" value="${product.proAmount}" class="form-control">
			</div>
			<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
				<label for="proSavedMoney" class="form-label">적립금</label>
				<input type="text" name="proSavedMoney" id="proSavedMoney" value="${product.proSavedMoney}" class="form-control">
			</div>
			<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
				<label for="category" class="form-label"><span class='text-danger'>*카테고리</span></label>
			 	<select name="category" id="category" class="form-select">
							<option value="카드" selected>카드</option>
							<option value="동전 ">동전</option>
							<option value="dvd">dvd</option>
							<option value="실크">실크</option>
							<option value="볼">볼</option>
							<option value="무대">무대</option>
							<option value="기타 도구">기타 도구</option>
						</select>
			</div>
			<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
				<input type="file" name="file" id="file" class="form-control">
			</div>
			<div class="text-center"><h3>제품 상세 정보</h3></div>
			<div class="mb-3" style="width: 35%; float:none; margin:0 auto">
				<textarea name="proDetail" cols="30" rows="5" class="form-control"></textarea>
			</div>
			<div class="mb-3" style="width: 20%; float:none; margin:0 auto">
				<label for="youtubeAdd" class="form-label">유튜브 영상 주소(유튜브 영상은 공유->퍼가기->iframe /iframe 전부 복사해서 붙여넣기 해주세요)
				<input type="text" name="youtubeAdd" id="youtubeAdd" class="form-control">
			</div>
			<div class="d-grid gap-2 d-md-flex justify-content-md-center">
				<input type="submit" value="수정하기" class="btn btn-primary">
				<a href="<c:url value='/admin/proList'/>">
					<input type="button" value="취소하기" class="btn btn-secondary">
				</a>
			</div>
		</form>
</div>
</body>
</html>