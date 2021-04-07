<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>주소록 고르는 페이지</title>
 <script type="text/javascript">
        function giveAdd(btn){
        	let btnStr = String(btn.id);//함수를 스트링으로 바꾸기
            console.log(btnStr.substring(3));
        	let addrDiv=btnStr.substring(3);
        	console.log(addrDiv)
        	const adds = document.getElementsByTagName('div');
        	  const div_list_length = adds.length;
        	  
        	//  alert(div_list_length);
        	  
        	  for(let i = 0; i < div_list_length; i++)  {
        		    console.log(adds[i]);
        		  }
        	  
        	 var addArr = document.getElementById(addrDiv)
        	 		
        	 var add1 =  addArr.childNodes[1].innerHTML;
        	 var add2 =  addArr.childNodes[3].innerHTML;
        	 var add3 =  addArr.childNodes[5].innerHTML;
        	 console.log(add1);
        	
        	 opener.document.getElementById("add1").value = add1;
             opener.document.getElementById("add2").value = add2;
             opener.document.getElementById("add3").value = add3;
             window.close();
        }
</script>
<link href="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/css'/>/bootstrap.min.css" rel="stylesheet" />
<script src="<c:url value='/resources/bootstrap-5.0.0-beta2-dist/js'/>/bootstrap.bundle.js"></script>

</head>
<body>
<div class="container">	
	<div class="text-center"><h3><p>배송지 목록</p></h3></div>
	<table class="table">
		<tr class="table-secondary">
			<td>주소지 이름</td>		
			<td>주소</td>
			<td></td>
		</tr>
		<c:forEach var="address" items="${addresses}">
			<c:set var="i" value="${i+1}"/>
			<tr class="table-light">
				<td><c:out value="${address.addName}"/></td>
				<td>
				<!-- 주소 분리해 내기 -->
					<c:set var="adds" value="${address.address}"/>
					<c:set var="tel" value="${fn:split(adds,'-')}" />
					<c:set var="addNo" value="${i}add"/>
					<div id="${addNo}">
						<c:forEach var="add" items="${tel}">					
								 <span><c:out value="${add}"/></span>
						</c:forEach>
					</div>
					
				</td>
				<td>
					<input id="btn${addNo}" type="button" value="선택" onclick="giveAdd(this)" class="btn btn-outline-primary"/>
				</td>
			</tr>
		</c:forEach>	
	</table>
</div>
</body>
</html>