package com.spring.magicMall.myPage.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.myPage.model.ReturnExchangeVO;
import com.spring.magicMall.myPage.service.IExchangeAndUserDropService;
import com.spring.magicMall.order.model.OrderDetailVO;
import com.spring.magicMall.order.model.OrderInfoVO;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.order.service.IBuyService;
import com.spring.magicMall.user.service.IUserService;

@Controller
@RequestMapping("/mypage")
public class ExchangeAndUserDropController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IExchangeAndUserDropService exService;
	@Autowired
	private IBuyService buyService;
		
	
	@GetMapping("/userDropEx")//유저 탈퇴
	public String userDropEx(HttpServletRequest request) {
		HttpSession session =request.getSession();
		int userNO = (int)session.getAttribute("login");
		System.out.println("userNo:"+userNO);
		userService.dropUser(userNO);
		System.out.println("유저 탈퇴 성공");
		session.invalidate();		
		return"redirect:/";
	}
	
	//반품 및 교환 페이지로
	@GetMapping("/exchangeApp")
	public String exchangeApp(OrderInfoVO orderInfo, 
							OrderListVO orderList, 
							ProductVO product,
							Model model) {
		System.out.println("반품 및 교환 페이지로 진입");
		System.out.println("orderInfo:"+orderInfo.toString());
		System.out.println("orderList:"+orderList.toString());
		System.out.println("product:"+product.toString());
		model.addAttribute("orderInfo",orderInfo);
		model.addAttribute("orderList",orderList);
		model.addAttribute("product",product);
		return"/exchangeApp/exchangeExPage";		
	}
	
	//반품 및 교환 기능 실행
	@PostMapping("/exchangeAppEx")
	public String exchangeAppEx(ReturnExchangeVO returnExchange,
								@RequestParam("file") MultipartFile file
								,@RequestParam("proName") String proName
								,Model model) throws IllegalStateException, IOException {
		System.out.println("반품 및 교환 기능 진입");
		int checkNum=0;
		String proPhoto;
		
		if(returnExchange.getReExEmail().equals("")
			||returnExchange.getReExChoose()==null) {//필요정보 공백체크
			checkNum=1;
		}else if(returnExchange.getReExEmail().length()>80
				||returnExchange.getReExReason().length()>500) {//정보들 길이 체크
			checkNum=2;
		}else {
			System.out.println("등록 시작");
			Date dateNow  = new Date(System.currentTimeMillis());
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMddhhmmss");
			String pathDate = simpleDate.format(dateNow);
			File f =new File("E:\\it 강의\\spring\\eclipse\\springworkspace\\Magicmall\\src\\main\\webapp\\resources\\images\\reExImages\\"+pathDate,file.getOriginalFilename());
			proPhoto=pathDate+"\\"+file.getOriginalFilename();
			System.out.println(f.getAbsolutePath());
			File folder = new File("E:\\it 강의\\spring\\eclipse\\springworkspace\\Magicmall\\src\\main\\webapp\\resources\\images\\reExImages\\"+pathDate);
			if(!folder.exists()) {//폴더 생성
				folder.mkdir();
				System.out.println("폴더 생성");
			}
			
			if(!(proPhoto.equals(pathDate+"\\"))) {//파일 공백 확인
				file.transferTo(f);
				returnExchange.setReExPhoto(proPhoto);
			}
			System.out.println("중간 체크 return:"+returnExchange.toString());
			exService.returnAndExchangeAdd(returnExchange);//반품 및 교환 신청 등록
			OrderListVO orderList = new OrderListVO();
			if(returnExchange.getReExChoose().equals("반품")) {//반품 및 교환 정보 준비
				orderList.setOrderStat(2);
			}else {
				orderList.setOrderStat(3);
			}
			orderList.setOrderNo(returnExchange.getOrderNo());
			orderList.setProNo(returnExchange.getProNo());
			System.out.println("셋팅된 orderList:"+orderList.toString());
			buyService.ordStatChange(orderList);//상품 정보 변경
			
		}
		System.out.println("checkNum:"+checkNum);
		
		if(checkNum==0) {
			System.out.println("등록성공");
			if(returnExchange.getUserNo()==null) {//유저 비유저 여부 확인
				System.out.println("비유저 성공");
				returnExchange.setUserNo(0);
			}
			model.addAttribute("returnExchange",returnExchange);
			return"/exchangeApp/exchangeApp_success";
		}else {
			System.out.println("등록 실패");
			if(returnExchange.getUserNo()==null) {//유저 비유저 여부 확인
				System.out.println("비유저 실패");
				returnExchange.setUserNo(0);
			}
			model.addAttribute("checkNum",checkNum);
			model.addAttribute("returnExchange",returnExchange);
			model.addAttribute("proName",proName);
			return"/exchangeApp/exchangeApp_fail";
		}
				
	}
}
