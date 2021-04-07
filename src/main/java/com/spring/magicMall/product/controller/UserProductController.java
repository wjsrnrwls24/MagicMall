package com.spring.magicMall.product.controller;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.repository.IProductMapper;
import com.spring.magicMall.adminProduct.service.IProductService;
import com.spring.magicMall.board.commons.PageCreater;
import com.spring.magicMall.board.model.BoardVO;
import com.spring.magicMall.product.commons.ProductSearchVO;
import com.spring.magicMall.product.commons.RandomNumCreator;
import com.spring.magicMall.product.commons.UserProductPageCreator;
import com.spring.magicMall.product.model.ReviewVO;
import com.spring.magicMall.product.repository.IReviewMapper;
import com.spring.magicMall.product.service.IReviewService;

@Controller
public class UserProductController {
	
	@Autowired
	private IProductService proService;
	@Autowired
	private IReviewService reviewService;
	
	
	//제품 목록 보기
	@GetMapping("/list")
	public String list(Model model,HttpServletRequest request,ProductSearchVO search) {
		HttpSession session = request.getSession();
		System.out.println("url: /board/list GET->reslut:");
		System.out.println("page 번호"+search.getPage());
		System.out.println("검색 조건"+search.getCondition());
		System.out.println("검색어"+search.getKeyword());
		System.out.println("search:"+search.toString());
		
		UserProductPageCreator pc = new UserProductPageCreator();
		pc.setPaging(search);
		Integer userNo = (Integer)session.getAttribute("login");
		
		
		pc.setArticleTotalCount(proService.userProListCount(search));
		List<ProductVO> products =proService.userProList(search);
		model.addAttribute("products",products);
		model.addAttribute("userNo",userNo);
		model.addAttribute("search",search);
		model.addAttribute("pc",pc);
		return"/userProduct/productList";
	}
	
	//개별 제품 페이지로 이동
	@GetMapping("/product")
	public String product(@RequestParam("proNo") int proNo,
			Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer userNo = (Integer)session.getAttribute("login");
		System.out.println("proNo:"+proNo);
		ProductVO product =proService.selectOnePro(proNo);
		List<ReviewVO> reviews = reviewService.reviews(proNo);
		System.out.println("리뷰 요청 완료");
		
		int[] proNos = proService.proNoGet();//랜덤번호 가져오기
		for(int i= 0;i<proNos.length;i++) {
			System.out.println("pros"+i+":"+proNos[i]);
		}
		System.out.println();
		RandomNumCreator numCre = new RandomNumCreator();
		int[] nums = numCre.randNum(proNos);
		System.out.println(Arrays.toString(nums));
		
		List<ProductVO> ranPros = new ArrayList<ProductVO>();
		for(int j = 0;j<3;j++) {
			ranPros.add(proService.selectOnePro(proNos[nums[j]]));
		}
		System.out.println("랜덤 물품 가져오기 완료");
		
		model.addAttribute("ranPros",ranPros);
		model.addAttribute("product",product);
		model.addAttribute("userNo",userNo);
		model.addAttribute("reviews",reviews);
		return"/userProduct/oneProduct";
	}
	
	//재고 요청 기능 실행
	@PostMapping("/product/amountReEx")
	public String amountReEx(@RequestParam("proNo") int proNo,Model model) {
		System.out.println("proNo:"+proNo);
		proService.proAmountRe(proNo);		
		System.out.println("재고 요청 완료");
		model.addAttribute("proNo",proNo);
		return"/userProduct/proRequest_success";
		
	}
	
	//제품 후기 등록 실행
	@PostMapping("/product/reviewEx")
	public String reviewEx(ReviewVO review,Model model) {
		System.out.println("review:"+review.toString());
		
		int check =0;
		
		if(review.getReviewWriter().equals("")||review.getReviewContent().equals("")) {//공백 체크
			System.out.println("등록 실패");
			check=1;
		}else if(review.getReviewWriter().length()>=10||review.getReviewContent().length()>=30) {//문자 길이 체크
			check=2;
		}else {//성공시
			reviewService.addReview(review);
			System.out.println("등록 성공");
			
		}
		if(check==0) {
			model.addAttribute("proNo",review.getProNo());
			return"/userProduct/reviewAdd_success";
		}else {
			model.addAttribute("check",check);
			model.addAttribute("proNo",review.getProNo());
			return"/userProduct/reviewAdd_fail";
		}
		
		
	}
	
}
