package com.spring.magicMall.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.service.IUserService;
import com.spring.magicMall.user.service.UserService;

@Controller
@RequestMapping("/user")
public class FindController {
	
	@Autowired
	private IUserService userService;
	
	
	//아이디 찾기 페이지로
	@GetMapping("/findID")
	public String findID() {
		System.out.println("아이디 찾기 페이지로 이동");
		return"findUser/findId";
	}
	
	//아이디 찾기 기능 실행
	@PostMapping("/findIDExecute")
	public String findIDExecute(UserVO user,Model model) {
		System.out.println("이메일 주소:"+user.getEmail());
		List<UserVO> users= userService.findIdAndPass(user.getEmail());
		
		if(users.isEmpty())	{
			System.out.println("실패");
			return"findUser/findID_fail";
		}else{
			System.out.println("성공");
			model.addAttribute("users",users);
			model.addAttribute("email",user.getEmail());
			return"findUser/findID_result";
			
		}
		
	
	}
	
	//비밀번호 찾기 페이지로
	@GetMapping("/findPass")
	public String findPass() {
		System.out.println("비밀번호 찾기 페이지로 이동");
		return"findUser/findPass";
	}
	
	//비밀번호 찾기 기능 실행
	@PostMapping("/findPassExecute")
	public String findPassExecute(UserVO user,Model model) {
		UserVO dbUser = new UserVO();
		int checkNum = 0;
		
		System.out.println("user: "+user.toString());
		
		if(user.getId().equals("")||user.getEmail().equals("")
				||user.getPassCheckQuestion().equals("")
				||user.getPassCheckAnswer().equals(""))	{//공백 체크
			checkNum=1;
			
		}else {//찾기 실행
		List<UserVO> dbUsers = userService.findIdAndPass(user.getEmail());
		if(dbUsers.isEmpty()) {//못찾을시
			checkNum=1;
		}else {//찾았을때
			for(UserVO check : dbUsers) {
				if(check.getId().equals(user.getId())) {
					dbUser=check;
					break;
				}
			}
		}
		System.out.println("dbUser:"+dbUser.toString());
			
		if(!(dbUser.getPassCheckQuestion().equals(user.getPassCheckQuestion())
				&&dbUser.getPassCheckAnswer().equals(user.getPassCheckAnswer()))){//패스워드 질문 과 답 체크
				
			checkNum=1;
			}
		}
		
		System.out.println("checkNUm:"+checkNum);
		
		if(checkNum==0) {//비밀번호 변경 진입		
			model.addAttribute("userNO",dbUser.getUserNO());
			return"/changePass/changePass";
		}else {//틀림
			return"/findUser/findPass_fail";
		}
		
	}
	
	//비밀번호 변경 기능 실행
	@PostMapping("/changePassExecute")
	public String changePassExecute(UserVO user,
			@RequestParam ("passwordCheck") String passwordCheck,
			Model model) {
		
		int checkNum = 0;
		
		System.out.println("user: "+user.toString());
		System.out.println("passwordCheck:"+passwordCheck);
		
		if(user.getPassword().equals("")
				||passwordCheck.equals("")) {//공백체크
						checkNum=1;			
		}else if(!(user.getPassword().equals(passwordCheck))) {//비밀번호 확인 체크
			checkNum=2;			
		}else if(!(user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$"))) {//비밀번호 조건(영문+숫자)
			checkNum=3;
		}else if(user.getPassword().length()<4||user.getPassword().length()>16){//비밀 번호 길이
			checkNum=3;
		}else {//비밀 번호 변경 실행
			userService.changePassword(user);
			System.out.println("비밀 번호 변경 성공");
		}
		
		System.out.println("checkNum:"+checkNum);
				
		if(checkNum==0) {
			return"/changePass/changePass_success";
		}else {
			model.addAttribute("checkNum",checkNum);
			return"/changePass/changePass_fail";
		}
	}
}
