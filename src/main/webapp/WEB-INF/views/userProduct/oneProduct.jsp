<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<!--var tt = document.getElementById("tt").value; 자바 스크립트 이용 값 가지고 오기
이거 사용시 <c:url value='/list/categoryList?category=${product.category}'/>
이런거 쓰러면  <c:url value='/list/categoryList?category='/> +변수명 +"문자"+변수명 
이런 식이어야 함--> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
		function shopAdd(){
			var proNo = document.getElementById("proNo").value;
			var shopOrAmount =document.getElementById("Amount").value;
			var userNo =document.getElementById("userNo").value;
			location.href="<c:url value='/basket/productAdd?userNo='/>" + userNo + '&proNo=' + proNo + '&shopOrAmount=' + shopOrAmount;
       	       		
		}
	</script>
<script type="text/javascript">
		function order(){
			var orAmount = document.getElementById("Amount").value;
			var proNo =document.getElementById("proNo").value;
			var proAmount=document.getElementById("proAmount").value;
			
			console.log("orAmount"+orAmount);
			console.log("proNo"+proNo);
			console.log("proAmount"+orAmount);
			console.log(proAmount<orAmount);
			if(${product.proAmount}<orAmount){
				alert("수량 초과");
			}if(orAmount<=0){
				alert("수량을 확인해주세요");
			}else{
			location.href="<c:url value='/buy?proNo='/>" + proNo + '&orAmount=' + orAmount;
			}
       	       		
		}
	</script>
	
</head>
<body>
<c:if test="${userNo==null}">
	<jsp:include page ="../Header.jsp"/>
</c:if>
<c:if test="${userNo!=null}">
	<jsp:include page ="../userHeader.jsp"/>
</c:if>
<div class="container">
<div align="right">
	<a href="<c:url value='/list?category=${product.category}'/>">
		${product.category}
	</a>
	>${product.proName}</div><br>
	<table class="table">
		<tr>
		<td style="width: 50%;">
			<img src="${pageContext.request.contextPath}/resources/images/${product.proPhoto}" alt="사진이 없습니다" class="rounded float-end" height="200" width="200">
		</td>
		<td>
		<div class="p-3 mb-2 bg-info text-dark"><h3>${product.proName}</h3></div><br>
		<span class='text-danger'>■</span>제조사:${product.proMaker}<br>
		<span class='text-danger'>■</span>가격: ${product.proPrice}원<br>
		<span class='text-danger'>■</span>수량:<input type="Number" name="shopOrAmount" id="Amount" value="1" class="form-control" style="width: 15%;">
		<div class="d-grid gap-2 d-md-flex">
		<c:if test="${product.proAmount!=0}">
			<span class='text-danger'>■</span>남은 수량:${product.proAmount}
			<input type="hidden" id="proAmount" value="${product.proAmount}">
		</c:if>
		<c:if test="${product.proAmount==0}"><span class='text-danger'>품절</span></c:if>
		<c:if test="${product.proAmount==0}">
		<form action="<c:url value='/product/amountReEx'/>" method="post">
				<input type="hidden" value="${product.proNo}" name="proNo">
				<input type="submit" value="재고 요청" class="btn btn-outline-primary btn-sm">
			</form>
		</c:if><br>
		</div>
		<span class='text-danger'>■</span>적립금:${product.proSavedMoney}원<br>
		<div class="d-grid gap-2 d-md-flex">
			<c:if test="${userNo!=null}">
				<input type="button" value="장바구니 추가" onclick="shopAdd()" class="btn btn-outline-secondary btn-sm"/>
			</c:if>
			<c:if test="${product.proAmount!=0}">
				<input type="button" value="바로 구매" id="buy" onclick="order()" class="btn btn-outline-success btn-sm"/>
			</c:if>
			<input type="hidden" value="${userNo}" id="userNo">
		</div>
		</td>
		</tr>
		</table>
			<div class="text-center"><h3>상품 상세 정보</h3></div>
		<table class="table">
		<tr>
			<td class="text-center">${product.proDetail}</td>
		</tr>
		<tr>
			<td class="text-center">${product.youtubeAdd}</td>
		</tr>
		</table>
		<div class="text-center text-info"><h3>이런상품은 어떠신가요?</h3></div>
		<table class="table justify-content-center">
		<tr>		
		<c:forEach var="ranPro" items="${ranPros}">
		<td>
		<div class="text-center">
			<a href="<c:url value='/product?proNo=${ranPro.proNo}'/>">
				<img src="${pageContext.request.contextPath}/resources/images/${ranPro.proPhoto}" alt="사진이 없습니다" class="rounded" height="100" width="100"/><br>
			</a>
			<a href="<c:url value='/product?proNo=${ranPro.proNo}'/>">
				<c:out value="${ranPro.proName}"/><br>
			</a>
			<c:out value="${ranPro.proPrice}원"/>
		</div>
		</td>
		</c:forEach>
		</tr>
		</table>
		<div class="text-center text-success"><h3>상품후기</h3></div>
		<form action="<c:url value='/product/reviewEx'/>" method="post">
			<input type="hidden" name="proNo" value="${product.proNo}" id="proNo">
			<table class="table table-sm">
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" name="reviewWriter" class="form-control" style="width: 30%;">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="10" name="reviewContent" class="form-control"></textarea>
					</td>
				</tr>
				<tr>
					<td>평점</td>
					<td>
					<div class="d-grid gap-2 d-md-flex">
						<div class="form-check">
							<input type="radio" name="reviewCompen" value="1" class="form-check-input" type="radio">
							<label class="form-check-label">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 1점.jpg" height="20" width="60">
							</label>
						</div>
						<div class="form-check">
							<input type="radio" name="reviewCompen" value="2" class="form-check-input" type="radio">
							<label class="form-check-label">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 2점.jpg" height="20" width="60">
							</label>
						</div>
						<div class="form-check">
							<input type="radio" name="reviewCompen" value="3" class="form-check-input" type="radio">
							<label class="form-check-label">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 3점.jpg" height="20" width="60">
							</label>
						</div>
						<div class="form-check">
							<input type="radio" name="reviewCompen" value="4" class="form-check-input" type="radio">
							<label class="form-check-label">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 4점.jpg" height="20" width="60">
							</label>
						</div>
						<div class="form-check">
							<input type="radio" name="reviewCompen" value="5" class="form-check-input" type="radio" checked>
							<label class="form-check-label">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 5점.jpg" height="20" width="60">
							</label>
						</div>
					</div>
					</td>
				</tr>
			</table>
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<input type="submit" value="후기등록" class="btn btn-outline-primary">
			</div>
		</form>
		<table class="table table-sm">
			<tr class="table-info">
				<td>이름</td><td>내용</td><td>평점</td>
			</tr>
			<c:forEach var="review" items="${reviews}">
				<tr class="table-light">			
					<td><c:out value="${review.reviewWriter}" /></td>
					<td><c:out value="${review.reviewContent}" /></td>
					<td>
						<c:choose>
							<c:when test="${review.reviewCompen==1}">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 1점.jpg" height="20" width="60">
							</c:when>
							<c:when test="${review.reviewCompen==2}">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 2점.jpg" height="20" width="60">
							</c:when>
							<c:when test="${review.reviewCompen==3}">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 3점.jpg" height="20" width="60">
							</c:when>
							<c:when test="${review.reviewCompen==4}">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 4점.jpg" height="20" width="60">
							</c:when>
							<c:when test="${review.reviewCompen==5}">
								<img src="${pageContext.request.contextPath}/resources/images/review/별점 5점.jpg" height="20" width="60">						
							</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	                  
</div>
</body>
</html>