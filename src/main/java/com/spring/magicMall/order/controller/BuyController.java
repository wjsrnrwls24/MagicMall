package com.spring.magicMall.order.controller;

import java.util.Arrays;
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

import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.service.IProductService;
import com.spring.magicMall.basket.model.BasketVO;
import com.spring.magicMall.basket.model.ProBasVO;
import com.spring.magicMall.basket.service.IBasketService;
import com.spring.magicMall.order.commons.MoneyCheckVO;
import com.spring.magicMall.order.commons.OrderNumberMaker;
import com.spring.magicMall.order.model.OrderCombineVO;
import com.spring.magicMall.order.model.OrderInfoVO;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.order.service.IBuyService;
import com.spring.magicMall.user.model.ExtraAddressVO;
import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.service.IExtraAddressService;
import com.spring.magicMall.user.service.IUserService;

@Controller
@RequestMapping("/buy")
public class BuyController {
	
	@Autowired
	private IBuyService buyService;
	@Autowired
	private IProductService proService;
	@Autowired
	private IBasketService basService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IExtraAddressService addService;
	
	//제품 페이지에서 주문 페이지로
	@GetMapping("")
	public String order(OrderListVO orderList,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		int checkNum=1;
		ProductVO product = proService.selectOnePro(orderList.getProNo());
		System.out.println("orderList:"+orderList);
		System.out.println("product:"+product.toString());
		
		if(session.getAttribute("login")!=null) {//유저
			System.out.println("유저");
			int userNo=(int)session.getAttribute("login");
			OrderCombineVO userInfo = buyService.userInfo(userNo);
			String[] addArray = userInfo.getExtraAdds().getAddress().split("-");//주소 나누기
			System.out.println(Arrays.toString(addArray));
			model.addAttribute("add1",addArray[0]);
			model.addAttribute("add2",addArray[1]);
			model.addAttribute("add3",addArray[2]);
			model.addAttribute("orderList",orderList);
			model.addAttribute("userInfo",userInfo);
			model.addAttribute("checkNum",checkNum);
			model.addAttribute("product",product);
			return"/order/orderPage";
		}else {//유저아님 
			System.out.println("유저 아님");
			model.addAttribute("orderList",orderList);
			model.addAttribute("checkNum",checkNum);
			model.addAttribute("product",product);
			return"/order/orderPage";
		}
		
	}
	
	//주문 실행
	@PostMapping("/orderEx")
	public String orderEx(OrderListVO orderList,OrderInfoVO orderInfo,MoneyCheckVO money
						, @RequestParam("add1") String add1
						, @RequestParam("add2") String add2
						, @RequestParam("add3") String add3
						, @RequestParam("proSavedMoney") int proSavedMoney
						, @RequestParam("userSavedMoney") int userSavedMoney
						, Model model) {
		
		System.out.println("orderList:"+orderList.toString());
		System.out.println();
		System.out.println("orderInfo:"+orderInfo.toString());
		System.out.println("proSavedMoney:"+proSavedMoney);
		System.out.println("userSavedMoney:"+userSavedMoney);
		System.out.println("moneyUseCheck:"+money.getMoneyUseCheck());
		
		int checkNum =0;
		
		if(orderInfo.getOrderer().equals("")||orderInfo.getOrEmail().equals("")
			||orderInfo.getOrPhone().equals("")||orderInfo.getReceiver().equals("")
			||orderList.getOrMessage().equals("")||add1.equals("")||add2.equals("")
			||add3.equals("")) {//빈칸 체크
			checkNum=1;
		}else if(orderInfo.getOrderer().length()>17||orderInfo.getOrEmail().length()>100
				||orderInfo.getOrPhone().length()>100||orderInfo.getReceiver().length()>17
				||orderList.getOrMessage().length()>1000||(add1+add2+add3).length()>95) {//입력 길이 체크
			checkNum=2;
		}else {//주문시작
			if(orderList.getOrAmount()!=null) {//장바구니에서 안온경우
				System.out.println("장바구니에서 안옴");
				if(orderInfo.getUserNo()!=null) {//적립금 사용 및 적립
					UserVO user= new UserVO();
					user.setUserNO(orderInfo.getUserNo());
					if(money.getMoneyUseCheck()==1) {
						System.out.println("적립금 사용함");
						user.setSavedMoney(userSavedMoney);
						userService.minSavedMoney(user);
					}
					user.setSavedMoney(proSavedMoney);
					userService.addSavedMoney(user);
					System.out.println("적립금 해결");
				}
				OrderNumberMaker number = new OrderNumberMaker();
				Integer orderNo = Integer.parseInt(number.numberMaker(orderList.getProNo()));//주문 번호 생성
				orderList.setOrderNo(orderNo);
				orderInfo.setOrderNo(orderNo);
				orderInfo.setOrAddress(add1+"-"+add2+"-"+add3);
				orderList.setShippingStat("배송중");
				System.out.println("밑 준비 완료");
				buyService.orderInfoSave(orderInfo);
				buyService.orderListSave(orderList);
				proService.proAmountAndBuyNum(orderList);
				System.out.println("주문 완료");
			}else {//장바구니에서 온경우
				System.out.println("장바구니에서 옴");
				if(orderInfo.getUserNo()!=null) {//적립금 사용 및 적립
					UserVO user= new UserVO();
					user.setUserNO(orderInfo.getUserNo());
					if(money.getMoneyUseCheck()==1) {
						System.out.println("적립금 사용함");
						user.setSavedMoney(userSavedMoney);
						userService.minSavedMoney(user);
					}
					user.setSavedMoney(proSavedMoney);
					userService.addSavedMoney(user);
					System.out.println("적립금 해결");
				}
				BasketVO delBasket = new BasketVO();
				delBasket.setUserNo(orderInfo.getUserNo());
				List<ProBasVO> basketPros = basService.allBasketPro(orderInfo.getUserNo());
				System.out.println("값받음");
				for(ProBasVO basketPro : basketPros) {	
					System.out.println("basket:"+basketPro.getBasket().toString());
					System.out.println();
					System.out.println("product"+basketPro.getProduct().getProNo());
					orderList.setProNo(basketPro.getProduct().getProNo());
					OrderNumberMaker number = new OrderNumberMaker();
					Integer	orderNo = Integer.parseInt(number.numberMaker(orderList.getProNo()));//주문번호 생성
					orderList.setOrderNo(orderNo);
					orderInfo.setOrderNo(orderNo);
					orderInfo.setOrAddress(add1+"-"+add2+"-"+add3);
					orderList.setShippingStat("배송중");
					orderList.setOrAmount(basketPro.getBasket().getShopOrAmount());
					System.out.println("장바구니 주문 밑 준비 완료");
					buyService.orderInfoSave(orderInfo);
					buyService.orderListSave(orderList);
					proService.proAmountAndBuyNum(orderList);
					System.out.println("장바구니 주문 완료");
				}
				basService.deleteBasket(delBasket);//장바구니 비우기				
			}
		}
		if(checkNum==0&&orderInfo.getUserNo()==null) {//비유저 성공
			model.addAttribute("orderNo",orderList.getOrderNo());
			return"/order/orderEx_successNonUser";
		}else if(checkNum==0&&orderInfo.getUserNo()!=null) {//유저 성공
			return"/order/orderEx_successUser";
		}else {
			model.addAttribute("checkNum",checkNum);
			return"/order/orderEx_fail";
		}
		
			
		
		
	}
	
	//배송지 고르기 페이지로
	@GetMapping("/address")
	public String address(@RequestParam("userNo") int userNo,Model model) {
		System.out.println("userNo 받음:"+userNo);
		List<ExtraAddressVO> addresses = addService.addresses(userNo);
		model.addAttribute("addresses",addresses);
		return"/mypage/addressSel";
		
	}
}
