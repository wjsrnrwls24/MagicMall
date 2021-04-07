package com.spring.magicMall.adminOrAndUser.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.magicMall.adminOrAndUser.commons.AdminOrderListPageCreator;
import com.spring.magicMall.board.commons.PageCreater;
import com.spring.magicMall.board.model.BoardVO;
import com.spring.magicMall.order.commons.OrderSearchVO;
import com.spring.magicMall.order.model.OrderDetailVO;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.order.service.IBuyService;
import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.service.IUserService;

@Controller
@RequestMapping("/admin")
public class UserAndOrderList {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBuyService buyService;
	
	
	//회원 목록 보기
	@GetMapping("/user")
	public String user(Model model) {
		System.out.println("유저 관리 페이지 진입");
		List<UserVO> users = userService.login();
		System.out.println("유저 정보 가지고 옴");
		model.addAttribute("users",users);
		return"/adminUserCheck/main";
		
	}
	
	//회원 목록 보기 검색
	@GetMapping("/userFind")
	public String userFind(@RequestParam("id") String id,Model model) {
		System.out.println("유저 검색 진입");
		List<UserVO> users = userService.findUser(id);
		model.addAttribute("users",users);
		return"/adminUserCheck/main";
		
	}
	
	//회원 주문 조회 페이지로
	@GetMapping("/userOrder")
	public String userOrder(OrderSearchVO orderSearch,Model model) {
		System.out.println("유저 주문 페이지 진입 ");
		System.out.println("orderSearch:"+orderSearch.toString());
		List<OrderDetailVO> orderDetails = buyService.orderListAndInfo(orderSearch);
		model.addAttribute("orderDetails",orderDetails);
		model.addAttribute("orderSearch",orderSearch);
		return"/adminUserCheck/userOrder";
	}
	
	//주문한 사람 목록 페이지로
	@GetMapping("/ordererList")
	public String orderList(OrderSearchVO orderSearch,Model model) {
		System.out.println("주문한 사람 목록 불러오기 진입");
				
		System.out.println("url: /board/list GET->reslut:");
		System.out.println("page 번호"+orderSearch.getPage());
		System.out.println("검색 조건"+orderSearch.getCondition());
		System.out.println("검색어"+orderSearch.getKeyword());
		
		AdminOrderListPageCreator pc = new AdminOrderListPageCreator();
		pc.setPaging(orderSearch);
		pc.setArticleTotalCount(buyService.countOrderListAndInfoAdmin(orderSearch));
		List<OrderDetailVO> orderDetails = buyService.orderListAndInfoAdmin(orderSearch);
		
		model.addAttribute("orderDetails",orderDetails);
		model.addAttribute("pc",pc);
		return"/adminOrderList/main";
		
	}
	
	//배송완료 처리
	@PostMapping("/orderFinishEx")
	public String orderFinishEx(OrderListVO orderList) {
		System.out.println("배송완료 처리 시작");
		buyService.shippingStatChange(orderList);
		return"redirect:/admin/ordererList";
		
	}
	

}
