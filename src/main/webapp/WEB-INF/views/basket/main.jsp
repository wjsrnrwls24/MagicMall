<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>장바구니 페이지</title>

<!-- 선택 주문 기능 -->
<script>
    function checkedOrder() {
        var pro_length = document.getElementsByName("checkedPro").length;
        var orderPros = [];
        var count = 0;
        var userNo = document.getElementById("userNo").value;
        console.log(userNo);
  		
  			for (var i=0; i<pro_length; i++) {
  	            if (document.getElementsByName("checkedPro")[i].checked == true) {
  	                console.log(document.getElementsByName("checkedPro")[i].value);
  	                console.log(typeof document.getElementsByName("checkedPro")[i].value);
  	                orderPros[count]=document.getElementsByName("checkedPro")[i].value;
  	                count++;
  	            }
  	        }
  			if(count==0){
  				alert("체크박스를 선택해주세요")
  			}else{
  				location.href="<c:url value='/basket/orderSel?orderPros='/>" + orderPros + "&userNo=" + userNo
  			}
  	        
  	      
  	   	
  	    	
  	}
        
</script>	
	
</head>
<body>
<jsp:include page ="../userHeader.jsp"/>
<div class="container">
	<div class="text-center"><span class="text-info"><h3>
	<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-bag-plus" viewBox="0 0 16 16">
  	<path fill-rule="evenodd" d="M8 7.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V12a.5.5 0 0 1-1 0v-1.5H6a.5.5 0 0 1 0-1h1.5V8a.5.5 0 0 1 .5-.5z"/>
  	<path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
	</svg>장바구니</h3></span></div>
	<div align="left">
		<a href="<c:url value='/list/'/>">
			<input type="button" value="계속 쇼핑" class="btn btn-success">
		</a>
	</div>
	
		<table class="table">
			<tr class="table-primary">
				<td></td>
				<td>제품 사진</td>
				<td>제품명</td>
				<td><div class="text-center">수량</div></td>
				<td>적립금</td>
				<td>가격</td>
				<td>취소</td>
			</tr>
				
					<c:forEach var="basketPro" items="${basketPros}">
						<tr class="table-light">
							<td>
								<div class="form-check">
									<input type="checkbox" name="checkedPro" value="${basketPro.product.proNo}" class="form-check-input">
								</div>
							</td>
							<td>
								<a href="<c:url value='/product?proNo=${basketPro.product.proNo}'/>">
								<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${basketPro.product.proPhoto}'/>" alt="사진이 없습니다" class="rounded" height="100" width="100">
								</a>
							</td>
							<td>
								<a href="<c:url value='/product?proNo=${basketPro.product.proNo}'/>">
									<c:out value='${basketPro.product.proName}'/>
								</a>
							</td>
							<form action="<c:url value='/basket/shopOrAmountChange'/>" method="post">
								<td class="col-6 col-md-4">
									<c:if test="${basketPro.product.proAmount==0}">
										<span class="text-danger"><h5>품절</h5></span>
									</c:if>
									<c:if test="${basketPro.product.proAmount!=0}">
										<input type="hidden" value="${basketPro.product.proNo}" name="proNo">
										<input type="hidden" value="${userNo}" name="userNo">
										<input type="hidden" value="${basketPro.product.proAmount}" name="proAmount">
										<div class="d-grid gap-2 d-md-flex justify-content-md-center">
										<div class="col-6 col-md-4">
											<input type="Number" value="${basketPro.basket.shopOrAmount}" name="shopOrAmount" class="form-control">
										</div>
										<div class="col-auto">
											<input type="submit" value="수량조정" class="btn btn-success btn-sm">
										</div>
										</div>
									</c:if>
								</td>
							</form>
							<td><c:out value='${basketPro.product.proSavedMoney}'/>원</td>
							<td><c:out value='${basketPro.product.proPrice}'/>원</td>
						<form action="<c:url value='/basket/delete'/>" method="post">
							<td>
								<input type="hidden" value="${basketPro.product.proNo}" name="proNo">
								<input type="hidden" value="${userNo}" name="userNo">
								<input type="submit" value="제품삭제" class="btn btn-danger btn-sm">
							</td>
						</form>
						</tr>
					</c:forEach>
					  
					
		</table>
				<div class="d-grid gap-2 d-md-flex justify-content-md-center">
					<form action="<c:url value='/basket/orderAll'/>" method="post">
						<input type="hidden" value="${userNo}" name="userNo" id="userNo">
						<div class="col-auto">
							<input type="submit" value="전체 주문" class="btn btn-outline-primary">
						</div>
					</form>
					<input type="button" value="선택 주문" onclick="checkedOrder()" class="btn btn-outline-primary">
					<form action="<c:url value='/basket/delete'/>" method="post">
						<input type="hidden" value="${userNo}" name="userNo">
						<div class="col-auto">
							<input type="submit" value="전체 삭제" class="btn btn-outline-danger">
						</div>
					</form>
				</div>
	
	
	
	
</div>
	
</body>
</html>