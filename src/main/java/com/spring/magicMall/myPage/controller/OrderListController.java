package com.spring.magicMall.myPage.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.magicMall.adminProduct.service.IProductService;
import com.spring.magicMall.order.commons.OrderSearchVO;
import com.spring.magicMall.order.model.OrderDetailVO;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.order.service.IBuyService;

@Controller
@RequestMapping("/mypage")
public class OrderListController {
	
	@Autowired
	private IBuyService buyService;
	@Autowired
	private IProductService proService;
	
	//회원 주문 조회 페이지로
	@GetMapping("/orderList")
	public String orderList(OrderSearchVO orderSearch,Model model) {
		System.out.println("주문내역 페이지 진입 ");
		System.out.println("orderSearch:"+orderSearch.toString());
		List<OrderDetailVO> orderDetails = buyService.orderListAndInfo(orderSearch);
		model.addAttribute("orderDetails",orderDetails);
		model.addAttribute("orderSearch",orderSearch);
		return"/mypage/orderList";
	}
	
	//구매완료 기능 실행
	@PostMapping("/buyFinishExectute")
	public String buyFinishEx(OrderListVO orderList,
							@RequestParam("userNo") int userNo,  
							RedirectAttributes redirect) {
		System.out.println("orderList:"+orderList.toString());
		buyService.ordStatChange(orderList);
		System.out.println("구매 완료 기능 실행");
		redirect.addAttribute("userNo", userNo);
		return"redirect:/mypage/orderList";
	}
	
	//주문 취소 기능 실행
	@PostMapping("/buyCancel")
	public String buyCancel(OrderListVO orderList,
			@RequestParam("userNo") int userNo,  
			RedirectAttributes redirect) {
		System.out.println("orderList:"+orderList.toString());
		System.out.println("orderList:"+orderList.getOrAmount());
		buyService.ordStatChange(orderList);
		proService.proAmountAndBuyNum(orderList);
		redirect.addAttribute("userNo", userNo);
		return"redirect:/mypage/orderList";		
	}

}
