package com.spring.magicMall.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.service.IProductService;
import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.service.IExtraAddressService;
import com.spring.magicMall.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	
	@Autowired
	private IExtraAddressService addService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IProductService proService;
	
	
	//유저 메인화면으로
	@GetMapping("/main")
	public String userMain(Model model,SearchVO search,HttpServletRequest request) {
		List<ProductVO> products = proService.selectAllPro(search);
		System.out.println("list 받음");
		HttpSession session = request.getSession();
		int userNo=(int)session.getAttribute("login");
		
		model.addAttribute("products",products);
		model.addAttribute("userNo",userNo);
		return"userHome";
	}
	
	
	//로그인 페이지로 가능 컨트롤
	@GetMapping("/login")
	public String login() {
		System.out.println("로그인 페이지로");
		return"login/login_page";
	}
	
	//로그인 기능 실행
	@PostMapping("/loginEx")
	public String login(UserVO user,Model model,
			HttpServletRequest request) {
		
		List<UserVO> checkUser=userService.login();//아이디들 db에서
		int checkNum =0;
		
		System.out.println(user.toString());		
				
		if(user.getId().equals("")) {//아이디 공백 확인
			checkNum=1;			
		}else if(user.getPassword().equals("")){//패스워드 공백 확인
			checkNum=2;			
		}else {//아이디 비번 맞는지 체크
			for(UserVO check: checkUser) {
				if(check.getId().equals(user.getId())&&check.getPassword().equals(user.getPassword())) {
					checkNum=3;
					user.setUserNO(check.getUserNO());//유저 번호 셋팅
					if(user.getId().equals("admin")&&user.getPassword().equals("admin")) {
						checkNum=5;
					}
					break;
				}else {
					checkNum=4;
				}
			}
		}
		System.out.println("checkNum : "+checkNum);
		if(checkNum==3||checkNum==5) {//로그인 성공 페이지로
			System.out.println("완료");
			HttpSession session = request.getSession();
			session.setAttribute("login", user.getUserNO());
			model.addAttribute("checkNum",checkNum);
			return"/login/login_success";
		}else {//로그인 실패 페이지로
			System.out.println("완료");
			model.addAttribute("checkNum",checkNum);
			return"/login/login_fail";
		}
			
	}
	
	//유저 로그아웃 기능 실행
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("세션 삭제 완료");
		return"redirect:/";
	}
	
	
	
	
	//회원 가입 페이지로
	@GetMapping("/register")
	public String register() {
		System.out.println("회원 가입 페이지로");
		return"/register/register";
	}
	
	//회원 가입 기능 실행
	@PostMapping("/registerExecute")
	public String reigsterEx(UserVO user, 
							@RequestParam("passwordCheck") String passwordCheck,
							@RequestParam("add1") String add1,
							@RequestParam("add2") String add2,
							@RequestParam("add3") String add3,
							Model model) {
		
		System.out.println("user"+user.toString());
		System.out.println("passwordCheck"+passwordCheck);
		System.out.println("add1"+add1);
		System.out.println("add2"+add2);
		System.out.println("add3"+add3);
		
		int checkNum =0 ;
		
		
		if(user.getId().equals("")||user.getPassword().equals("")
				||passwordCheck.equals("")||user.getName().equals("")
				||add1.equals("")||add2.equals("")||add3.equals("")
				||user.getEmail().equals("")||user.getPassCheckQuestion().equals("")
				||user.getPassCheckAnswer().equals("")||user.getpNumber().equals("")) {//공백체크
			
			checkNum=1;
			
		}else if(user.getName().length()>10||add1.length()>20||add2.length()>30||add3.length()>30
				||user.getEmail().length()>50||user.getPassCheckAnswer().length()>70||user.getpNumber().length()>100) {
			checkNum=1;
		}else if(!(user.getPassword().equals(passwordCheck))) {//비밀번호 확인 체크
			checkNum=2;
			
		}else if(!(user.getId().matches("[a-zA-Z0-9]{4,16}$"))) {//아이디 조건
			checkNum=3;
		}else if(!(user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$"))) {//비밀번호 조건(영문+숫자)
			checkNum=4;
		}else if(user.getPassword().length()<4||user.getPassword().length()>16){//비밀 번호 길이
			checkNum=4;
		}else {//성공시
			userService.insert(user);//유저 테이블에 등록
			System.out.println("등록 성공");
			int userNo=userService.findUserNO(user.getId());
			System.out.println("userNo:" +userNo);
			addService.defaultAdd(userNo,add1,add2,add3);
			
		}
		System.out.println("checkNum:"+checkNum);
		
		if(checkNum==0) {
			return"/register/register_success";
		}else {
			model.addAttribute("checkNum", checkNum);
			return"/register/register_fail";
		}
				
	}
	
	//id체크 기능 실행
	@RequestMapping(value="/register/idCheck",  produces="application/x-www-form-urlencoded;charset=UTF-8", method=RequestMethod.POST)
	@ResponseBody
	public String idCheck(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		int result =userService.checkId(id);
		String responseString = "";
		if(result==0) {
			responseString += "<span style='color:green'>사용할 수 있는 아이디 입니다.</span>";
			
		}else {
			responseString += "<span style='color:red'>사용할 수 없는 아이디 입니다.</span>";
			
		}
		
		return responseString+"-"+result;
		
	}
		
		
//	}
	
	
	
}
