package com.spring.magicMall.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.service.IProductService;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
	
	@Autowired
	IProductService proService;
	
	
	//위시리스트로 가기
	@GetMapping("")
	public String wishlistPage(HttpServletRequest request,
								Model model) {
		System.out.println("위시리스트 페이지로");
		Cookie[] cookies = request.getCookies();
		List<ProductVO> products = new ArrayList<ProductVO>();
		 for (Cookie cookie : cookies) {
			 if(cookie.getName().equals("wishlist")) {
				String[] wishlist = cookie.getValue().split("-");				
				for(int i=0;i<wishlist.length;i++) {//물품들 가져오기
					products.add(proService.selectOnePro(Integer.parseInt(wishlist[i])));
				}
				break;
			 }
		 }
		
		model.addAttribute("products",products);
		return"/wishList/main";
	}
	
	
	
	//위시리스트에 추가
	@RequestMapping(value="/addList",  produces="application/x-www-form-urlencoded;charset=UTF-8", method=RequestMethod.GET)
	@ResponseBody
	public String addWishList(@RequestParam("proNo") String proNo,
							HttpServletRequest request,
							HttpServletResponse response) {
		boolean cookieCheck = false;
		Cookie[] cookies = request.getCookies();
		 for (Cookie cookie : cookies) {
			 if(cookie.getName().equals("wishlist")) {//이미 위시리스트에 추가했을시
				 System.out.println("이미 있음");
				 String[] proNos = cookie.getValue().split("-");
				 for(String no : proNos) {//같은 제품이 있는지 체크
					 if(no.equals(proNo)) {
						 return "이미 상품이 위시리스트에 존재합니다";
					 }
				 }
				 String newCookie = cookie.getValue()+"-"+proNo;
				 cookie.setValue(newCookie);
				 cookie.setPath("/");
				 cookie.setMaxAge(60*60*24*7);
				 response.addCookie(cookie);
				 cookieCheck = true;
				 break;
			 }		
		 }
		if(cookieCheck==false) {//새로 추가한 경우
			System.out.println("새로만들기");
			Cookie cookie = new Cookie("wishlist", proNo);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
		}
		
		return"위시리스트 추가 완료";
	}
	
	//위시리스트에 삭제
	@PostMapping("/delList")
	public String delList(@RequestParam("proNo") String proNo,
							HttpServletRequest request,
							HttpServletResponse response) {
		System.out.println("위시리스트 삭제 실행");
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			 if(cookie.getName().equals("wishlist")) {//상품제거
				String[] cookieVals = cookie.getValue().split("-");
				if(cookieVals[0].equals(proNo)&&cookieVals.length!=1) {
					System.out.println("가장 앞에거 삭제");
					String newWishlist = cookie.getValue().replace(proNo+"-","");
					cookie.setValue(newWishlist);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
					break;
				}else if(cookieVals.length==1) {
					System.out.println("한개 남았을때 삭제");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}else {
					System.out.println("일반 삭제");
				String newWishlist = cookie.getValue().replace("-"+proNo,"");
				System.out.println("바뀐 쿠키:"+newWishlist);
				cookie.setValue(newWishlist);
				cookie.setPath("/");
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
				break;
				}
			 }
		}
		System.out.println("삭제 완료");
		return"/wishList/del_success";
		
		
	}

}
