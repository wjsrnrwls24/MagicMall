<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>로그인 페이지</title>
	
<!-- 아이디 찾기 기능 -->	
<script language="javascript">
  function showPopup() { 
	  window.open("${pageContext.request.contextPath}/user/findID", "a", "width=400, height=300, left=100, top=50"); 
	  }
 </script>
 <!-- 비밀번호 찾기 기능 -->
<script language="javascript">
   function showPopup2() { 
	  window.open("${pageContext.request.contextPath}/user/findPass", "a", "width=500, height=400, left=100, top=50"); 
	  }
</script>

<!-- 아이디 저장 기능 -->
<script>
    window.onload = function() {
 
        if (getCookie("id")) { // getCookie함수로 id라는 이름의 쿠키를 불러와서 있을경우
            document.loginEx.id.value = getCookie("id"); //input 이름이 id인곳에 getCookie("id")값을 넣어줌
            document.loginEx.saveId.checked = true; // 체크는 체크됨으로
        }
 
    }
 
    function setCookie(name, value, expiredays) //쿠키 저장함수
    {
        var todayDate = new Date();
        todayDate.setDate(todayDate.getDate() + expiredays);
        document.cookie = name + "=" + escape(value) + "; path=/; expires="
                + todayDate.toGMTString() + ";"
    }
 
    function getCookie(Name) { // 쿠키 불러오는 함수
        var search = Name + "=";
        if (document.cookie.length > 0) { // if there are any cookies
            offset = document.cookie.indexOf(search);
            if (offset != -1) { // if cookie exists
                offset += search.length; // set index of beginning of value
                end = document.cookie.indexOf(";", offset); // set index of end of cookie value
                if (end == -1)
                    end = document.cookie.length;
                return unescape(document.cookie.substring(offset, end));
            }
        }
    }
 
    function sendit() {
        if (document.loginEx.saveId.checked == true) { // 아이디 저장을 체크 하였을때
            setCookie("id", document.loginEx.id.value, 7); //쿠키이름을 id로 아이디입력필드값을 7일동안 저장
        } else { // 아이디 저장을 체크 하지 않았을때
            setCookie("id", document.loginEx.id.value, 0); //날짜를 0으로 저장하여 쿠키삭제
        }
    }
</script>
<script src='https://www.google.com/recaptcha/api.js'></script>
<script>
	function check_recaptcha(){
		var v = grecaptcha.getResponse();
	     if(v.length == 0){
	    	 alert("리캡차를 해주세요")
	         return false;
	     }else{
	         return true;
	     }
	}
</script>
</head>
<body>
<jsp:include page ="../Header.jsp"/>
<div class="container">	
<div class="col-sm-6" style="width: 40%; float:none; margin:0 auto">
		<div class="card " >
			<div class="card-header text-center card text-white bg-secondary mb-3"><h3>로그인</h3></div>
		<div class="card-body bg-light">
			<form name="loginEx" id="loginEx" method="post" action="<c:url value='/user/loginEx'/>" onsubmit="return check_recaptcha()">
				<div class="mb-3">
					<label class="form-label">아이디</label>
					<input type="text" name="id" id="id" class="form-control">
				</div>
				<div class="mb-3">
					<label class="form-label">비밀번호	</label>   
					<input type="password" name="password" id="password" class="form-control">
				</div>
				<div class="form-check">
					<input type="checkbox" name="saveId" id="saveId" class="form-check-input" type="checkbox">
					<label class="form-check-label">아이디 저장</label>
				</div>
					<div class="d-grid gap-2 d-md-flex justify-content-md-center">
						<input type="submit" id="loginRequest" name="loginRequest" value="로그인" onclick="sendit()" class="btn btn-success">
					</div>
					<div class="d-grid gap-2 d-md-flex justify-content-md-center">
						<div class="g-recaptcha" data-sitekey="6LfJBpYaAAAAAENFiB9ALAyCrXWoDGCy3PsRun6C"></div>
					</div>
				</form>
		</div>
	 <div class="card-footer text-center bg-light">	
			<span class="text-danger">☞</span>아직 회원이 아니신가요?<br>
			<div class="d-grid gap-2 d-md-flex justify-content-md-center">
				<a href="<c:url value='/user/register'/>">
					<input type="button" value="회원가입" class="btn btn-primary btn-sm">
				</a>
			</div>
			<span class="text-danger">☞</span>아이디 혹은 비밀번호가 기억나지 않으신가요?<br>
			<div class="d-grid gap-2 d-md-flex justify-content-md-center">
				<input type="button" value="아이디 찾기"  onclick="showPopup()" class="btn btn-warning btn-sm"/>
				<input type="button" value="비밀번호 찾기" onclick="showPopup2()" class="btn btn-info btn-sm"/>
			</div>
	</div>
		
	
</div>	
</div>
	
</div>
</body>
</html>