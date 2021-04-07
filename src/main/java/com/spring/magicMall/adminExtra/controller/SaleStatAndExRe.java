package com.spring.magicMall.adminExtra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.magicMall.adminExtra.commons.SaleStatPageCreator;
import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.service.IProductService;
import com.spring.magicMall.myPage.model.ReExInfoVO;
import com.spring.magicMall.myPage.model.ReturnExchangeVO;
import com.spring.magicMall.myPage.service.IExchangeAndUserDropService;
import com.spring.magicMall.order.model.OrderInfoVO;
import com.spring.magicMall.order.model.OrderListVO;


@Controller
@RequestMapping("/admin")
public class SaleStatAndExRe {
	
	@Autowired
	private IProductService productservice;
	@Autowired
	private IExchangeAndUserDropService exchangeService;
	
	//매출 확인 페이지로
	@GetMapping("/saleStat")
	public String saleStat(SearchVO search,Model model) {
		System.out.println("매출 확인 진입");
		
		
		System.out.println("url: /board/list GET->reslut:");
		System.out.println("page 번호"+search.getPage());
		System.out.println("검색어"+search.getKeyword());
		
		SaleStatPageCreator pc = new SaleStatPageCreator();
		pc.setPaging(search);
		int allPrice =0;
		List<ProductVO> products = productservice.selectMostSaleReal(search);
		List<ProductVO> productsForPrice = productservice.selectAllPro(search);
		for(ProductVO product : productsForPrice) {
			allPrice = allPrice+(product.getProBuyNum()*product.getProPrice());
		}
		pc.setArticleTotalCount(productservice.countProductAdmin(search));
		model.addAttribute("products",products);
		model.addAttribute("pc",pc);
		model.addAttribute("allPrice",allPrice);
		
		return"/adminAmountPlusAndMain/saleStat";
		
	}
	
	//반품 및 교환 페이지로
	@GetMapping("/ExRe")
	public String ExRe(Model model) {
		System.out.println("반품 및 교환 페이지로 진입");
		List<ReExInfoVO> reExLists = exchangeService.reExInfo();
		System.out.println("정보 받음");
		model.addAttribute("reExLists",reExLists);
		return"/adminReEx/main";
		
	}
	
	//반품 및 교환 승인
	@PostMapping("/ExReExecute")
	public String ExReExecute(ReturnExchangeVO reEx) {
		
		System.out.println("반품 및 교환 승인");
		System.out.println("reEx:"+reEx.toString());
		
		if(reEx.getReExChoose().equals("교환")) {//교환 여부 확인
			System.out.println("교환 입니다");
			OrderListVO orderList = new OrderListVO();
			orderList.setOrderStat(6);
			orderList.setOrAmount(reEx.getReExAmount());
			orderList.setProNo(reEx.getProNo());
			System.out.println("orderList 2차:"+orderList.toString());
			productservice.proAmountAndBuyNum(orderList);
			System.out.println("교환 성공");
			
		}
		if(reEx.getReExChoose().equals("반품")) {//반품일 경우 처리
			System.out.println("반품입니다");
			OrderListVO orderList = new OrderListVO();
			orderList.setOrderStat(7);
			orderList.setOrAmount(reEx.getReExAmount());
			orderList.setProNo(reEx.getProNo());
			System.out.println("orderList 2차:"+orderList.toString());
			productservice.proAmountAndBuyNum(orderList);
			System.out.println("반품 성공");
		}
		
		exchangeService.returnAndExchangeDel(reEx);
		System.out.println("삭제 성공");
		
		return"/adminReEx/ExReExecute_success";
	}
	
	//반품 및 교환 이유 보기
	@GetMapping("/ExReAppli")
	public String ExReAppli(ReturnExchangeVO reEx,Model model) {
		System.out.println("반품 및 교환 이유 페이지로 진입");
		List<ReExInfoVO> reExLists = exchangeService.reExInfo();
		System.out.println("reEx:"+reEx.toString());
		for(ReExInfoVO reExInfo : reExLists ) {
			System.out.println("reExInfo orderNo:"+reExInfo.getReturnExchange().getOrderNo()+"reEx orderNo:"+reEx.getOrderNo());
			System.out.println("reExInfo proNo:"+reExInfo.getReturnExchange().getProNo()+"reEx proNo:"+reEx.getProNo());
			System.out.println(reExInfo.getReturnExchange().getOrderNo().equals(reEx.getOrderNo()));
			
			if(reExInfo.getReturnExchange().getProNo().equals(reEx.getProNo())
					&&reExInfo.getReturnExchange().getOrderNo().equals(reEx.getOrderNo())){				
				model.addAttribute("product",reExInfo.getProduct());
				model.addAttribute("reEx",reExInfo.getReturnExchange());
				System.out.println("값을 넣음");
				break;					
				}
		}
		return"/adminReEx/ReExDetail";
		
	}

}
