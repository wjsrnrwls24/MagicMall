package com.spring.magicMall.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.magicMall.order.commons.OrderSearchVO;
import com.spring.magicMall.order.model.OrderDetailVO;
import com.spring.magicMall.order.service.IBuyService;
import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.service.IUserService;

@Controller
@RequestMapping("/userList")
public class UserListController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IBuyService buyService;
	
	//유저 조회 페이지로
	@GetMapping("")
	public String userList(){
		return"/userList/userListMain";
	}
	
	//유저 로그인 실행
	@PostMapping("/loginEx")
	public String login(UserVO user,Model model,
			HttpServletRequest request,RedirectAttributes redirect) {
		
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
					break;
				}else {
					checkNum=4;
				}
			}
		}
		System.out.println("checkNum : "+checkNum);
		if(checkNum==3) {//로그인 성공 페이지로
			System.out.println("완료");
			HttpSession session = request.getSession();
			session.setAttribute("login", user.getUserNO());
			redirect.addAttribute("userNo",user.getUserNO());
			return"redirect:/mypage/orderList";
		}else {//로그인 실패 페이지로
			System.out.println("완료");
			model.addAttribute("checkNum",checkNum);
			return"/userList/login_fail";
		}
			
	}
	
	//회원 번호 조회 실행
	@PostMapping("/nonUserEx")
	public String nonUserEx(@RequestParam("orderNo") Integer orderNo,
							Model model,RedirectAttributes redirect) {
		System.out.println("회원 번호 조회 실행");
		System.out.println("orderNo:"+orderNo);
		OrderSearchVO orderSearch =new OrderSearchVO();
		orderSearch.setOrderNo(orderNo);
		int checkNum = 0;
		 List<OrderDetailVO> orderDetails = buyService.orderListAndInfo(orderSearch);
		 for(OrderDetailVO orderDetail : orderDetails) {
			 if(orderDetail.getOrderInfo().getOrderNo().equals(orderNo)) {
				 checkNum=3;
				 break;
			 }
		 }
		 if(checkNum==0) {
			 checkNum=1;
			 System.out.println("조회 실패"+checkNum);
			 model.addAttribute("checkNum",checkNum);
			 return"/userList/nonUser_fail";
		 }else {
			 System.out.println("조회 성공:"+checkNum);
			 redirect.addAttribute("orderNo",orderNo);
			 return"redirect:/shippingList";
		 }
		
	}

}
