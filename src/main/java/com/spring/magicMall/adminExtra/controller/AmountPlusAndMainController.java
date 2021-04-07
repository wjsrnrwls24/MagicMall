package com.spring.magicMall.adminExtra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.service.IProductService;
import com.spring.magicMall.order.model.OrderDetailVO;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.order.service.IBuyService;

@Controller
@RequestMapping("/admin")
public class AmountPlusAndMainController {
	
	@Autowired
	private IProductService productService;
	@Autowired
	private IBuyService buyService;
	
	//관리자 페이지 진입
	@GetMapping("/main")
	public String main(SearchVO search, Model model) {
		System.out.println("관리자 페이지 진입");
		search.setCondition("request");
		List<ProductVO> amountRePros = productService.selectAllPro(search);//재고 요청 체크
		search.setCondition(null);
		search.setMostSale("yes");
		List<ProductVO> mostSalePros = productService.selectAllPro(search);//가장 많이 팔린 물건들 체크
		search.setMostSale(null);
		search.setCondition("cancel");
		List<OrderDetailVO> cancelOrders = buyService.orderStatCheck(search);//주문 취소 체크
		model.addAttribute("amountRePros",amountRePros);
		model.addAttribute("mostSalePros",mostSalePros);
		model.addAttribute("cancelOrders",cancelOrders);
		return"/adminAmountPlusAndMain/adminMain";
	}
	
	//재고 처리 완료 버튼
	@PostMapping("/amountPlusEx")
	public String amountPlusEx(ProductVO product) {
		System.out.println("재고 처리 시스템 진입");
		System.out.println("product:"+product.toString());
		productService.proAmountReFin(product.getProNo());
		System.out.println("재고 처리 완료");
		return"redirect:/admin/main";
		
	}
	
	//주문 취소 확인 버튼
	@PostMapping("/orderCancelEx")
	public String orderCancelEx(OrderListVO orderList) {
		System.out.println("주문 취소 기능 시작");
		System.out.println("orderList:"+orderList.getOrderNo());
		buyService.orderInfoDel(orderList);
		System.out.println("주문 취소 확인 완료");
		return"redirect:/admin/main";
	}
	
	//재고 부족 제품 페이지로
	@GetMapping("/FewAmount")
	public String FewAmount(SearchVO search,Model model) {
		System.out.println("제품 부족 페이지로");
		search.setCondition("lack");
		List<ProductVO> products = productService.selectAllPro(search);
		model.addAttribute("products",products);
		return"/adminAmountPlusAndMain/fewAmount";
		
	}

}
