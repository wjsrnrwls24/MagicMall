package com.spring.magicMall.adminExtra.commons.intercepter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminIntercepter extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			HttpSession session = request.getSession();
			
			if(session.getAttribute("login")==null||(int)session.getAttribute("login")!=0) {//관리자 페이지 인터셉터
				System.out.println("관리자 인증 실패");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				String element = "<script>"
								+"alert('관리자 로그인을 해주세요');"
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
