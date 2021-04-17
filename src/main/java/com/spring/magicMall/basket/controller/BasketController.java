package com.spring.magicMall.basket.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.service.IProductService;
import com.spring.magicMall.basket.model.BasketVO;
import com.spring.magicMall.basket.model.ProBasVO;
import com.spring.magicMall.basket.repository.IBasketMapper;
import com.spring.magicMall.basket.service.IBasketService;
import com.spring.magicMall.order.model.OrderCombineVO;
import com.spring.magicMall.order.repository.IBuyMapper;
import com.spring.magicMall.order.service.IBuyService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	@Autowired
	private IBasketService basService;
	@Autowired
	private IProductService proService;
	@Autowired
	private IBuyService buyService;
	
	
	//장바구니 추가
	@GetMapping("/productAdd")
	public String productAdd(HttpServletRequest request,BasketVO basket,Model model) {
		int check =0;
		
		System.out.println("basket:"+basket.toString());
		List<ProBasVO> basketPros = basService.allBasketPro(basket.getUserNo());
		System.out.println("불러오기 성공");
		for(ProBasVO basketPro: basketPros) {
			ProductVO product = basketPro.getProduct();
			System.out.println("product1:"+product.toString());
			System.out.println("basketPro:"+basketPro.getProduct().getProNo());
			if(product.getProNo()==basket.getProNo()) {//장바구니에 제품 들었는지 확인
				check=1;
				System.out.println("이미있는 물건");
				break;
			}
		}
		
		if(check==0) {//수량 초과 확인
			ProductVO dbProduct = proService.selectOnePro(basket.getProNo());
			System.out.println("수량:"+dbProduct.getProAmount());
			if(dbProduct.getProAmount()<basket.getShopOrAmount()) {
					check=2;
					System.out.println("수량 초과");
			}
		}
		if(check==0&&basket.getShopOrAmount()<1) {
			check=3;
			System.out.println("부적절 수량");
			
		}
		
		if(check==0){//장바구니 등록하기
			basService.insertBasket(basket);
			System.out.println("장바구니 등록 성공");
		}
		System.out.println("check:"+check);
		if(check==0) {
			return"/basket/productAdd_success";
		}else {
			model.addAttribute("checkNum",check);
			model.addAttribute("proNo",basket.getProNo());
			return"/basket/productAdd_fail";
		}

	}
	
	
	//장바구니 가기
	@GetMapping("/main")
	public String basket(HttpServletRequest request,Model model) {
		
		HttpSession session = request.getSession();		
			int userNo = (int)session.getAttribute("login");
			System.out.println("login:"+userNo);
			List<ProBasVO> basketPros = basService.allBasketPro(userNo);
			model.addAttribute("basketPros",basketPros);
			model.addAttribute("userNo",userNo);
			return"/basket/main";		
		
	}
	
	//장바구니 수량 조정
	@PostMapping("/shopOrAmountChange")
	public String shopOrAmountChange(BasketVO basket,
									@RequestParam("proAmount") int proAmount
									,Model model) {
		
		int check=0;
		
		if(basket.getShopOrAmount()<1) {//수량이 올바른지 체크
			check=1;
		}else if(basket.getShopOrAmount()>proAmount) {//제품의 수량이 남았는지 체크
			check=2;
		}else {//제품 수량 수정 실행
			basService.changetAmount(basket);			
		}
		
		System.out.println("check:"+check);
		if(check==0) {//성공시
			return"/basket/shopOrAmountChange_success";
		}else {//실패시
			model.addAttribute("checkNum",check);
			model.addAttribute("proAmount",proAmount);
			return"/basket/shopOrAmountChange_fail";
		}
			
	}
	
	//장바구니 제품 삭제
	@PostMapping("/delete")
	public String delete(BasketVO basket) {
		System.out.println("basket:"+basket);
		basService.deleteBasket(basket);
		System.out.println("삭제 성공");
		return"redirect:/basket/main";
		
	}

	//장바구니 제품 전체 주문 하기
	@PostMapping("/orderAll")
	public String order (Model model,@RequestParam("userNo") int userNo) {
		int checkNum =0; 
		List<ProBasVO> basketPros = basService.allBasketPro(userNo);
		OrderCombineVO userInfo = buyService.userInfo(userNo);
		String[] addArray = userInfo.getExtraAdds().getAddress().split("-");//주소 나누기
		System.out.println(Arrays.toString(addArray));
		model.addAttribute("add1",addArray[0]);
		model.addAttribute("add2",addArray[1]);
		model.addAttribute("add3",addArray[2]);
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("basketPros",basketPros);
		model.addAttribute("checkNum",checkNum);
		System.out.println("정보 받음");
		return"/order/orderPage";
		
		
	}
	
	//장바구니 제품 선택 주문 하기
	@GetMapping("/orderSel")
	public String orderSel(@RequestParam("orderPros") String[] orderPros,
							@RequestParam("userNo") int userNo,
							Model model,HttpServletRequest request,HttpSession session) {
		System.out.println("선택 주문 진입 성공");
		int checkNum =2; 
		BasketVO basket = new BasketVO();
		List<ProBasVO> basketPros = new ArrayList<ProBasVO>();
		basket.setUserNo(userNo);
		

		ArrayList<Integer> proList = (ArrayList)session.getAttribute("productlist");//세션 생성해서 해서 리스트 담기
		if(proList==null){
			proList = new ArrayList<Integer>();
		     session.setAttribute("productlist",proList);
		}
		
		
		for(int i=0;i<orderPros.length;i++) {//해당하는 물품 집어넣기고 세션에 저장
			basket.setProNo(Integer.parseInt(orderPros[i]));
			System.out.println("basket"+i+"번째 값:"+basket.toString());
			ProBasVO proBas = basService.basketPro(basket);
			basketPros.add(proBas);
			proList.add(proBas.getBasket().getProNo());
			proList.add(proBas.getBasket().getShopOrAmount());
		}
		for(int i =0;i<proList.size();i++) {
			System.out.println(i+"번째 proList "+proList.get(i));
		}
		
		
		OrderCombineVO userInfo = buyService.userInfo(userNo);
		String[] addArray = userInfo.getExtraAdds().getAddress().split("-");//주소 나누기
		model.addAttribute("add1",addArray[0]);
		model.addAttribute("add2",addArray[1]);
		model.addAttribute("add3",addArray[2]);
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("basketPros",basketPros);
		model.addAttribute("checkNum",checkNum);
		System.out.println("정보 받음");
		return"/order/orderPage";
	}

}
