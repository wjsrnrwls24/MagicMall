<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>구매 페이지</title>
	<!-- 저장된 주소 고르기 -->
 <script type="text/javascript">
    
        var openWin;
    
        function openAddressSel(){
        	var userNo = document.getElementById("userNo").value;
            // window.name = "부모창 이름"; 
            window.name = "parentForm";
            // window.open("open할 window", "자식창 이름", "팝업창 옵션");
            openWin = window.open("<c:url value='/buy/address?userNo='/>"+userNo,
                    "childForm", "width=770, height=350, resizable = no, scrollbars = no");    
        }
 
 </script>
 <!-- 적립금 사용 -->
  <script type="text/javascript">
	 function getCheckboxValue(event)  {
 	 	let result = '';
 	 	let sum = '';
 	 	const prices = document.getElementById('price').innerHTML;
 	 	const div_list_length = prices.length;
 	 	    console.log(prices);
 	 	 var shippingCost = 2500;
 	 	 console.log(typeof(prices));
 	 	 console.log(typeof(shippingCost));
 	 	 price=Number(prices);
 	 	 
 		 if(event.target.checked)  {
   		 result = ${userInfo.users.savedMoney};
   		 console.log(typeof(result));
   		 sum= price+shippingCost-${userInfo.users.savedMoney};
 		 }else {
   		 result = 0;
   		 sum= price+shippingCost;
 	 }
  
  	document.getElementById('result').innerText
   	 = result;
  	document.getElementById('sum').innerText
  	 = sum;
}
 </script>
   
</head>
<body>
<c:if test="${userInfo.users.userNO==null}">
	<jsp:include page ="../Header.jsp"/>
</c:if>
<c:if test="${userInfo.users.userNO!=null}">
	<jsp:include page ="../userHeader.jsp"/>
</c:if>
<div class="container">
	<div class="text-center"><h3>구매상품</h3></div>
	<c:set var="allPrice"/><!-- 총구매 가격 변수 -->
	<table class="table">
			<tr class="table-info">
				<td>제품 사진</td>
				<td>제품명</td>
				<td>수량</td>
				<td>적립금</td>
				<td>가격</td>		
			</tr>
		<!-- 개별 제품 페이지 및 제품 리스트에서 구매를 누른 경우 -->
		<c:if test="${checkNum==1}">
		<tr class="table-light">
			<td>
				<img src="${pageContext.request.contextPath}/resources/images/${product.proPhoto}" alt="사진이 없습니다" class="rounded" height="100" width="100">
			</td>
			<td>${product.proName}</td>
			<td>${orderList.orAmount}</td>
			<td>
				${product.proSavedMoney}원
				<input type="hidden" value="${product.proSavedMoney}" name="proSavedMoney">
			</td>
			<td><c:out value="${product.proPrice*orderList.orAmount}"/>원</td>
			</tr>
			<c:set var="allPrice" value="${product.proPrice*orderList.orAmount}"/>
			<c:set var="proSavedMoney" value="${product.proSavedMoney*orderList.orAmount}"/>
		</c:if>
		
		<!-- 장바구니에서 구매 페이지로 -->
		<c:if test="${checkNum==0||checkNum==2}">
			<c:forEach var="basketPro" items="${basketPros}">
				<tr class="table-light">
					<td>
						<img src="${pageContext.request.contextPath}/resources/images/<c:out value='${basketPro.product.proPhoto}'/>" alt="사진이 없습니다" class="rounded" height="100" width="100">
					</td>
					<td>					
						<c:out value='${basketPro.product.proName}'/>
					</td>
					<td>
						<c:out value='${basketPro.basket.shopOrAmount}'/>
					</td>
					<td>
						<c:out value='${basketPro.product.proSavedMoney}'/>원
						<c:set var="proSavedMoney" value="${proSavedMoney+basketPro.product.proSavedMoney*basketPro.basket.shopOrAmount}"/>
					</td>
					<td>
						<c:out value='${basketPro.product.proPrice*basketPro.basket.shopOrAmount}'/>
					</td>
					<c:set var="allPrice" value="${allPrice+basketPro.product.proPrice*basketPro.basket.shopOrAmount}"/>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<span class="text-danger text-end"><h3>총 구매 금액: <c:out value="${allPrice}"/>원</h3><br></span>
	
	<!-- 유저가 아닐경우 주문자 정보 및 배송 정보 -->
	<div class="text-center"><h3> 주문자 정보</h3></div><br>
	<c:if test="${userInfo.users.userNO==null}">
		<form action="<c:url value='/buy/orderEx'/>" method="post">
		<input type="hidden" name="orAmount" value="${orderList.orAmount}">
		<input type="hidden" name="proNo" value="${product.proNo}">
		<input type="hidden" name="proSavedMoney" value="0">
		<input type="hidden" name="userSavedMoney" value="0">
		<input type="hidden" name="moneyUseCheck" value="0">
		<table class="table">
			<tr>
				<td class="table-secondary"><span class="text-danger">*주문자 정보</span></td>
				<td class="table-light"><input type="text" name="orderer" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*이메일</span></td>
				<td class="table-light"><input type="text" name="orEmail" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*휴대전화 번호</span></td>
				<td class="table-light"><input type="text" name="orPhone" class="form-control" style="width: 40%"></td>
			</tr>
		</table>
		<br>
		<div class="text-center"><h3>배송정보</h3></div><br>
		<table class="table">
			<tr>
				<td class="table-secondary"><span class="text-danger">*수신자</span></td>
				<td class="table-light"><input type="text" name="receiver" class="form-control" style="width: 20%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger" class="form-control">*우편 번호</span></td>
				<td class="table-light">
					<div class="d-grid gap-2 d-md-flex">
						<input type="text"name="add1" id="add1" class="form-control" style="width: 20%">
						<input type="button" onclick="execDaumPostcode()" value="우편 번호 찾기" class="btn btn-outline-info btn-sm"/>
					</div>
				</td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*기본 주소</span></td>
				<td class="table-light"><input type="text"name="add2" id="add2" class="form-control" style="width: 40%;"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*상세 주소</span></td>
				<td class="table-light"><input type="text"name="add3" id="add3" class="form-control" style="width: 40%;"></td>
			</tr>
			<tr>
				<td class="table-secondary">주문 메세지</td>
				<td class="table-light">
					<textarea rows="8" name="orMessage" class="form-control">빠른 배송 부탁합니다</textarea>
				</td>
			</tr>
		</table>
		<div class="text-center"><h3>최종 결제 금액</h3></div></p>
		<table class="table">
			<tr class="table-secondary">
				<td>상품 금액</td>
				<td></td>
				<td>배송비</td>
				<td></td>
				<td>결제 예정 금액</td>
			</tr>
			<tr class="table-light">
				<td><h4>${allPrice}원</h4></td>
				<td><span class="text-primary"><h4>+</h4></span></td>
				<td><h4>2500원</h4></td>
				<td><span class="text-success"><h4>=</h4></span></td>
				<td><span class="text-danger"><h4><c:out value="${allPrice+2500}"/>원</h4></span></td>
			</tr>
		</table>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<input type="submit" value="주문하기" class="btn btn-outline-success">	
			<a href="<c:url value='/'/>">
				<input type="button" value="취소하기" class="btn btn-outline-danger">
			</a>
		</div>
	</form>

		
	</c:if>
	
	
	<!-- 유저가 인데 제품 창에서 주문한 경우 주문자 정보 및 배송 정보 -->
	
	<c:if test="${userInfo.users.userNO!=null&&checkNum==1}">
		<form action="<c:url value='/buy/orderEx'/>" method="post">
		<input type="hidden" name="orAmount" value="${orderList.orAmount}">
		<input type="hidden" name="userNo" value="${userInfo.users.userNO}" id="userNo">
		<input type="hidden" name="proNo" value="${product.proNo}">
		<input type="hidden" name="proSavedMoney" value="${proSavedMoney}">
		<input type="hidden" name="userSavedMoney" value="${userInfo.users.savedMoney}">
		<table class="table">
			<tr>
				<td class="table-secondary"><span class="text-danger">*주문자 정보</span></td>
				<td class="table-light"><input type="text" name="orderer" value="${userInfo.users.name}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*이메일</span></td>
				<td class="table-light"><input type="text" name="orEmail" value="${userInfo.users.email}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*휴대전화 번호</span></td>
				<td class="table-light"><input type="text" name="orPhone" value="${userInfo.users.pNumber}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary">사용할 적립금</td>
				<td class="table-light">
					<span id ="userSavedMoney" class="text-danger">사용가능한 적립금 : ${userInfo.users.savedMoney}</span>
					<div class="form-check">
						<input type="checkbox" value="1" name="moneyUseCheck" onclick='getCheckboxValue(event)' class="form-check-input" type="checkbox" checked>
						<label class="form-check-label">적립금 사용하기</label>
					</div>
				</td>
			</tr>
		</table>
		<br>
		<div class="text-center"><h3>배송정보</h3></div><br>
		<table class="table">
			<tr>
				<td class="table-secondary"><span class="text-danger">*수신자</span></td>
				<td class="table-light"><input type="text" name="receiver" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*우편 번호</span></td>
				<td class="table-light">
					<div class="d-grid gap-2 d-md-flex">
						<input type="text" name="add1" id="add1" value="${add1}" class="form-control" style="width: 20%">
						<input type="button" onclick="execDaumPostcode()" value="우편 번호 찾기" class="btn btn-outline-info btn-sm">
						<input type="button" value="주소지 고르기 " onclick="openAddressSel()" class="btn btn-outline-primary btn-sm">
					</div>
				</td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*기본 주소</span></td>
				<td class="table-light"><input type="text"name="add2" id="add2" value="${add2}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*상세 주소</span></td>
				<td class="table-light"><input type="text"name="add3" id="add3" value="${add3}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary">주문 메세지</td>
				<td class="table-light">
					<textarea cols="50" rows="8" name="orMessage" class="form-control">빠른 배송 부탁합니다</textarea>
				</td>
			</tr>
		</table>
		<div class="text-center"><h3>최종 결제 금액</h3></div>
		<table class="table">
			<tr class="table-secondary">
				<td>상품 금액</td>
				<td></td>
				<td>배송비</td>
				<td></td>
				<td>적립금</td>
				<td></td>
				<td>결제 예정 금액</td>
			</tr>
			<tr class="table-light">
				<td><h4><div id ="price">${allPrice}</div>원</h4></td>
				<td><span class="text-primary"><h4>+</h4></span></td>
				<td><h4>2500원</h4></td>
				<td><span class="text-danger"><h4>-</h4></span></td>
				<td><h4><span id="result">${userInfo.users.savedMoney}</span>원</h4></td>
				<td><span class="text-success"><h4>=</h4></span></td>
				<td><h4><div class="text-danger"><span id="sum"><c:out value="${allPrice+2500-userInfo.users.savedMoney}"/></span>원</div></h4></td>
			</tr>			
		</table>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<input type="submit" value="주문하기" class="btn btn-outline-success">
			<a href="<c:url value='/user/main'/>">
				<input type="button" value="취소하기" class="btn btn-outline-danger">
			</a>
		</div>
	</form>
	</c:if>
	
	<!-- 유저가 인데 장바구니 창에서 전체 주문한 경우 주문자 정보 및 배송 정보 -->
	
	<c:if test="${userInfo.users.userNO!=null&&checkNum==0}">
		<form action="<c:url value='/buy/orderEx'/>" method="post">
		<input type="hidden" name="userNo" value="${userInfo.users.userNO}" id="userNo">
		<input type="hidden" name="proSavedMoney" value="${proSavedMoney}">
		<input type="hidden" name="userSavedMoney" value="${userInfo.users.savedMoney}">
		<table class="table">
			<tr>
				<td class="table-secondary"><span class="text-danger">*주문자 정보</span></td>
				<td class="table-light"><input type="text" name="orderer" value="${userInfo.users.name}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*이메일</span></td>
				<td class="table-light"><input type="text" name="orEmail" value="${userInfo.users.email}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*휴대전화 번호</span></td>
				<td class="table-light"><input type="text" name="orPhone" value="${userInfo.users.pNumber}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary">사용할 적립금</td>
				<td class="table-light">
					<span id ="userSavedMoney" class="text-danger">
						사용가능한 적립금 : ${userInfo.users.savedMoney}
					</span>
					<div class="form-check">
						<input type="checkbox" value="1" name="moneyUseCheck" onclick='getCheckboxValue(event)' class="form-check-input" type="checkbox" checked>
						<label class="form-check-label">적립금 사용하기</label>
					</div>
				</td>
			</tr>
		</table>
		<br>
		<div class="text-center"><h3>배송정보</h3></div><br>
		<table class="table">
			<tr>
				<td class="table-secondary"><span class="text-danger">*수신자</span></td>
				<td class="table-light"><input type="text" name="receiver" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*우편 번호</span></td>
				<td class="table-light">
					<div class="d-grid gap-2 d-md-flex">
						<input type="text"name="add1" id="add1" value="${add1}" class="form-control" style="width: 20%">
						<input type="button" onclick="execDaumPostcode()" value="우편 번호 찾기" class="btn btn-outline-info btn-sm">
						<input type="button" value="주소지 고르기 " onclick="openAddressSel()" class="btn btn-outline-primary btn-sm">
					</div>
				</td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*기본 주소</span></td>
				<td class="table-light"><input type="text"name="add2" id="add2" value="${add2}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*상세 주소</span></td>
				<td class="table-light"><input type="text"name="add3" id="add3" value="${add3}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary">주문 메세지</td>
				<td class="table-light">
					<textarea rows="8" name="orMessage" class="form-control">빠른 배송 부탁합니다</textarea>
				</td>
			</tr>
		</table>
		<div class="text-center"><h3>최종 결제 금액</h3></div>
		<table class="table">
			<tr class="table-secondary">
				<td>상품 금액</td>
				<td></td>
				<td>배송비</td>
				<td></td>
				<td>적립금</td>
				<td></td>
				<td>결제 예정 금액</td>
			</tr>
			<tr class="table-light">
				<c:set var="allPrice" value="${allPrice}"/>
				<td><h4><div id ="price">${allPrice}</div>원</h4></td>
				<td><span class="text-primary"><h4>+</h4></span></td>
				<td><h4>2500원</h4></td>
				<td><span class="text-danger"><h4>-</h4></span></td>
				<td><h4><span id="result">${userInfo.users.savedMoney}</span></h4></td>
				<td><span class="text-success"><h4>=</h4></span></td>
				<td><h4><div class="text-danger"><span id="sum"><c:out value="${allPrice+2500-userInfo.users.savedMoney}"/></span>원</div></h4></td>
			</tr>			
		</table>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<input type="submit" value="주문하기" class="btn btn-outline-success">
			<a href="<c:url value='/user/main'/>">
				<input type="button" value="취소하기" class="btn btn-outline-danger">
			</a>
		</div>
	</form>	
</c:if>

	<!-- 유저가 인데 장바구니 창에서 선택 주문한 경우 주문자 정보 및 배송 정보 -->
	
	<c:if test="${userInfo.users.userNO!=null&&checkNum==2}">
	<form action="<c:url value='/buy/orderEx'/>" method="post">
		<input type="hidden" name="userNo" value="${userInfo.users.userNO}" id="userNo">
		<input type="hidden" name="proSavedMoney" value="${proSavedMoney}">
		<input type="hidden" name="userSavedMoney" value="${userInfo.users.savedMoney}">
		<input type="hidden" name="selCheck" value="1">
		<table class="table">
			<tr>
				<td class="table-secondary"><span class="text-danger">*주문자 정보</span></td>
				<td class="table-light"><input type="text" name="orderer" value="${userInfo.users.name}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*이메일</span></td>
				<td class="table-light"><input type="text" name="orEmail" value="${userInfo.users.email}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*휴대전화 번호</span></td>
				<td class="table-light"><input type="text" name="orPhone" value="${userInfo.users.pNumber}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary">사용할 적립금</td>
				<td class="table-light">
					<span id ="userSavedMoney" class="text-danger">
						사용가능한 적립금 : ${userInfo.users.savedMoney}
					</span>
					<div class="form-check">
						<input type="checkbox" value="1" name="moneyUseCheck" onclick='getCheckboxValue(event)' class="form-check-input" type="checkbox" checked>
						<label class="form-check-label">적립금 사용하기</label>
					</div>
				</td>
			</tr>
		</table>
		<br>
		<div class="text-center"><h3>배송정보</h3></div><br>
		<table class="table">
			<tr>
				<td class="table-secondary"><span class="text-danger">*수신자</span></td>
				<td class="table-light"><input type="text" name="receiver" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*우편 번호</span></td>
				<td class="table-light">
					<div class="d-grid gap-2 d-md-flex">
						<input type="text"name="add1" id="add1" value="${add1}" class="form-control" style="width: 20%">
						<input type="button" onclick="execDaumPostcode()" value="우편 번호 찾기" class="btn btn-outline-info btn-sm">
						<input type="button" value="주소지 고르기 " onclick="openAddressSel()" class="btn btn-outline-primary btn-sm">
					</div>
				</td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*기본 주소</span></td>
				<td class="table-light"><input type="text"name="add2" id="add2" value="${add2}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary"><span class="text-danger">*상세 주소</span></td>
				<td class="table-light"><input type="text"name="add3" id="add3" value="${add3}" class="form-control" style="width: 40%"></td>
			</tr>
			<tr>
				<td class="table-secondary">주문 메세지</td>
				<td class="table-light">
					<textarea rows="8" name="orMessage" class="form-control">빠른 배송 부탁합니다</textarea>
				</td>
			</tr>
		</table>
		<div class="text-center"><h3>최종 결제 금액</h3></div>
		<table class="table">
			<tr class="table-secondary">
				<td>상품 금액</td>
				<td></td>
				<td>배송비</td>
				<td></td>
				<td>적립금</td>
				<td></td>
				<td>결제 예정 금액</td>
			</tr>
			<tr class="table-light">
				<c:set var="allPrice" value="${allPrice}"/>
				<td><h4><div id ="price">${allPrice}</div>원</h4></td>
				<td><span class="text-primary"><h4>+</h4></span></td>
				<td><h4>2500원</h4></td>
				<td><span class="text-danger"><h4>-</h4></span></td>
				<td><h4><span id="result">${userInfo.users.savedMoney}</span></h4></td>
				<td><span class="text-success"><h4>=</h4></span></td>
				<td><h4><div class="text-danger"><span id="sum"><c:out value="${allPrice+2500-userInfo.users.savedMoney}"/></span>원</div></h4></td>
			</tr>			
		</table>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<input type="submit" value="주문하기" class="btn btn-outline-success">
			<a href="<c:url value='/user/main'/>">
				<input type="button" value="취소하기" class="btn btn-outline-danger">
			</a>
		</div>
		</form>
</c:if>


</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("add3").value = extraAddr;
                
                } else {
                    document.getElementById("add3").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('add1').value = data.zonecode;
                document.getElementById("add2").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("add3").focus();
            }
        }).open();
    }
</script>	
</body>
</html>