<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 가입 페이지</title>
</head>
<body>
<jsp:include page ="../Header.jsp"/> 
<div class="container">
	
		<div class="text-center"><h3>가입 정보 입력</h3></div>
		<form method="post" action="<c:url value='/user/registerExecute'/>" name="registerEx">
			<table class="table">
				<tr>
					<td class="table-secondary" style="width: 20%;"><span class="text-danger">*아이디</span></td>
					<td class="table-light">
					<div class="d-grid gap-2 d-md-flex">
						
							<input type="text" name="id" id="id" class="form-control" style="width: 40%;">
						
						
							<input type="button" id="idCheck" value="중복체크" class="btn btn-outline-primary btn-sm" >
						
						
							<span id="idCheckResult"></span><span class="text-danger">*4~16길이의 문자 및 숫자</span>
						
					</div>
					</td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*비밀번호</span></td>
					<td class="table-light">
						<div class="d-grid gap-2 d-md-flex">
							<input type="password" name="password" id="password" class="form-control" style="width: 50%;">
							<span class="text-danger">*영문 숫자를 혼합한 4~16길이의 문자 및 숫자</span>
						</div>
					</td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*비밀번호 확인</span></td>
					<td class="table-light"><input type="password" name="passwordCheck" id="passwordCheck" class="form-control" style="width: 50%;"></td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*이름</span></td>
					<td class="table-light"><input type="text"name="name" id="name" class="form-control" style="width: 40%;"></td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*우편 번호</span></td>
					<td class="table-light">
						<div class="d-grid gap-2 d-md-flex">
							<input type="text"name="add1" id="add1" class="form-control" style="width: 20%;">
							<input type="button" onclick="execDaumPostcode()" value="우편 번호 찾기" class="btn btn-outline-primary btn-sm">
						</div>
					</td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*기본 주소</span></td>
					<td class="table-light"><input type="text"name="add2" id="add2" class="form-control" style="width: 60%;"></td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*상세 주소</span></td>
					<td class="table-light"><input type="text"name="add3" id="add3" class="form-control" style="width: 60%;"></td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*이메일</span></td>
					<td class="table-light"><input type="text"name="email" id="email" class="form-control" style="width: 60%;"></td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*휴대전화 번호</span></td>
					<td class="table-light"><input type="text"name="pNumber" id="pNumber" class="form-control" style="width: 60%;"></td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*비밀번호 확인 질문</span></td>
					<td class="table-light"  class="form-select" style="width: 50%;">
						<select name="passCheckQuestion">
							<option value="fatherHome">아버지 고향은?</option>
							<option value="dream">너의 꿈은?</option>
							<option value="age">너의 나이는?</option>
						</select>				
					</td>
				</tr>
				<tr>
					<td class="table-secondary"><span class="text-danger">*비밀번호 확인 질문 답변</span></td>
					<td class="table-light"><input type="text"name="passCheckAnswer" id="passCheckAnswer" class="form-control" style="width: 60%;"></td>
				</tr>		
			</table>
			<div class="d-grid gap-2 d-md-flex justify-content-md-center">
				<input type="submit" value="회원 가입" id="registerRequest" name="registerRequest" class="btn btn-outline-success" disabled/>
				<a href="<c:url value='/'/>"><input type="button" value="취소하기" id="registerCancel" name="registerCancel" class="btn btn-outline-danger"/></a>
			</div>
		</form>
</div>
	
	
	
<script>
(function() {
	  var httpRequest;
	  document.getElementById("idCheck").addEventListener('click', makeRequest);

	  function makeRequest() {
	    httpRequest = new XMLHttpRequest();

	    if(!httpRequest) {
	      alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
	      return false;
	    }
	    httpRequest.onreadystatechange = alertContents;
		//GET으로 요청
	    //httpRequest.open('GET', "${pageContext.request.contextPath}/idCheck?id="+document.getElementById("id"));
	    //httpRequest.send();

	    //POST로 요청
	    httpRequest.open('POST', "${pageContext.request.contextPath}/user/register/idCheck");
	    httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    httpRequest.send('id=' + encodeURIComponent(document.getElementById("id").value));
	  }

	  function alertContents() {
	    if (httpRequest.readyState === XMLHttpRequest.DONE) {
	      if (httpRequest.status === 200) {
	    	  var results=httpRequest.responseText.split('-');
	    	  if(results[1]=='0'){
	    		 const registBtn= document.getElementById("registerRequest")
	    		 registBtn.disabled = false;
	    	  }
	    	document.getElementById("idCheckResult").innerHTML = results[0];
	      } else {
	        alert('request에 뭔가 문제가 있어요.');
	      }
	    }
	  }
	})();
</script>

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