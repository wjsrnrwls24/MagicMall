package com.spring.magicMall.myPage.commons.intercepter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MypageIntercepter extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			HttpSession session = request.getSession();
			
			if(session.getAttribute("login")==null) {//유저 메인 페이지 인터셉터
				System.out.println("회원 인증 실패");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				String element = "<script>"
								+"alert('로그인을 해주세요');"
								+"location.href ='/';"
								+"</script>";
				out.print(element);
				out.flush();//브라우저 출력버퍼 비우기
				out.close();
				
				return false;
			}else {
				return true;
			}
		
	}

}
