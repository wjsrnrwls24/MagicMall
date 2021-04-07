package com.spring.magicMall.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserEditController {
	
	@Autowired
	private IUserService userService;
	
	
	//회원 수정 페이지로
	@GetMapping("/edit")
	public String edit(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		int userNO=(int)session.getAttribute("login");
		System.out.println("userNo:"+userNO);
		model.addAttribute("userNO",userNO);
		return"/mypage/userEdit";
	}
	//회원 수정 실행
	@PostMapping("/editEx")
	public String editEx(UserVO user,
			@RequestParam("passwordCheck") String passwordCheck,
			Model model) {
		System.out.println("user:"+user.toString());
		System.out.println("passwordCheck:"+passwordCheck);
		
		int checkNum =0 ;
		
		
		if(user.getPassword().equals("")||passwordCheck.equals("")
				||user.getEmail().equals("")||user.getpNumber().equals(""))
				 {//공백체크
			
			checkNum=1;
			
		}else if(user.getEmail().length()>50||user.getpNumber().length()>100) {
			checkNum=1;
			
		}else if(!(user.getPassword().equals(passwordCheck))) {//비밀번호 확인 체크
			checkNum=2;			
		}else if(!(user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$"))) {//비밀번호 조건(영문+숫자)
			checkNum=3;
		}else if(user.getPassword().length()<4||user.getPassword().length()>16){//비밀 번호 길이
			checkNum=3;
		}else {//성공시
			userService.editUser(user);//유저 테이블에 수정
			System.out.println("수정 성공");				
		}
		
		System.out.println("checkNum:"+checkNum);
		
		if(checkNum==0) {
			return"/mypage/userEdit_success";
		}else {
			model.addAttribute("checkNum", checkNum);
			return"/mypage/userEdit_fail";
		}
	}

}
