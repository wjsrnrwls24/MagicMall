package com.spring.magicMall.order.controller;

import java.util.Calendar;
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
import com.spring.magicMall.order.model.OrderInfoVO;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.order.service.IBuyService;

@Controller
@RequestMapping("/shippingList")
public class ShippingListController {
	
	@Autowired
	private IBuyService buyService;
	@Autowired
	private IProductService proService;
	
	
	//주문 배송 페이지 진입
	@GetMapping("")
	public String shippingList(OrderSearchVO orderSearch, Model model) {
		System.out.println("주문배송 페이지 진입 ");
		System.out.println("orderSearch:"+orderSearch.toString());
		List<OrderDetailVO> orderDetails = buyService.orderListAndInfo(orderSearch);
		model.addAttribute("orderDetails",orderDetails);
		model.addAttribute("orderSearch",orderSearch);
		return"/shippingList/main";
	}
	
	//주문 취소 기능 실행
	@PostMapping("/buyCancel")
	public String buyCancel(OrderListVO orderList,  
			RedirectAttributes redirect) {
		System.out.println("orderList:"+orderList.toString());
		System.out.println("orderList:"+orderList.getOrAmount());
		buyService.ordStatChange(orderList);
		proService.proAmountAndBuyNum(orderList);
		redirect.addAttribute("orderNo", orderList.getOrderNo());
		return"redirect:/shippingList";		
	}
	
	//구매완료 기능 실행
	@PostMapping("/buyFinishExectute")
	public String buyFinishEx(OrderListVO orderList,
							RedirectAttributes redirect) {
		System.out.println("orderList:"+orderList.toString());
		buyService.ordStatChange(orderList);
		System.out.println("구매 완료 기능 실행");
		redirect.addAttribute("orderNo", orderList.getOrderNo());
		return"redirect:/shippingList";
	}

}
