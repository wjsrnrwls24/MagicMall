package com.spring.magicMall.adminProduct.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.magicMall.adminProduct.commons.AdminProdcutPageCreator;
import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.service.IProductService;
import com.spring.magicMall.board.commons.PageCreater;
import com.spring.magicMall.board.model.BoardVO;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private IProductService proService;
	
	//제품 추가 페이지로
	@GetMapping("/proAdd")
	public String proAddEdit() {
		
		return"/adminProduct/proAdd";
	}
	//제품 추가 기능 실행
	@PostMapping("/proAddEx")
	public String proAddEx(ProductVO product,
						@RequestParam("file") MultipartFile file,
						Model model) throws IllegalStateException, IOException {
		System.out.println("prodcut:"+product.toString());
		System.out.println("사진이름 : "+file.getOriginalFilename());
		
		int checkNum=0;
		String proPhoto;
		
		if(product.getProName().equals("")||product.getProMaker().equals("")) {//공백 체크
			checkNum=1;
		}else if(product.getProPrice()==-1||product.getProAmount()==-1) {
			checkNum=2;
		}
		else {
			File f =new File("E:\\it 강의\\spring\\eclipse\\springworkspace\\Magicmall\\src\\main\\webapp\\resources\\images",file.getOriginalFilename());
			proPhoto=file.getOriginalFilename();
			System.out.println(f.getAbsolutePath());
			if(!(proPhoto.isEmpty())) {//파일 공백 확인
				file.transferTo(f);
				product.setProPhoto(proPhoto);
			}
			
						
			System.out.println("product check2:"+product.toString());
			proService.insertPro(product);
			System.out.println("제품 저장 완료");
			
		}
		
		if(checkNum==0) {
			return"/adminProduct/proAdd_success";
		}else {
			model.addAttribute("checkNum",checkNum);
			return"/adminProduct/proAdd_fail";
		}
		
		
			}
	
	//제품 목록 페이지로
	@GetMapping("/proList")
	public String proList(Model model,SearchVO search) {
		System.out.println("search:"+search.toString());
		AdminProdcutPageCreator pc = new AdminProdcutPageCreator();
		pc.setPaging(search);
		pc.setArticleTotalCount(proService.countProductAdmin(search));
		List<ProductVO> products = proService.selectProsAdmin(search);
		model.addAttribute("pc",pc);
		model.addAttribute("products",products);
		return"/adminProduct/proList";
	}
	
	//개별 제품 페이지로
	@GetMapping("/proDetail")
	public String proDetail(@RequestParam("proNo") int proNo,Model model) {
		
		ProductVO product =proService.selectOnePro(proNo);
		System.out.println("product:"+product.toString());
		model.addAttribute("product",product);
		System.out.println("제품 페이지 진입");
		return"/adminProduct/proDetail";
	}
	
	//제품 삭제
	@GetMapping("/proDeleteEx")
	public String proDelete(@RequestParam("proNo") int proNo) {
		System.out.println("proNo:"+proNo);
		proService.deletePro(proNo);
		System.out.println("삭제 성공");
		return"/adminProduct/proDelete_success";
	}
	
	//제품 수정 페이지로
	@GetMapping("/proEdit")
	public String proEdit(@RequestParam("proNo") int proNo,Model model) {
		System.out.println("proNo:"+proNo);
		ProductVO product =proService.selectOnePro(proNo);
		System.out.println("product:"+product.toString());
		model.addAttribute("product",product);
		return"/adminProduct/proEdit";
	}
	
	//제품 수정 기능 실행
	@PostMapping("/proEditEx")
	public String proEditEx(ProductVO product,
			@RequestParam("file") MultipartFile file,
			Model model) throws IllegalStateException, IOException {
		System.out.println("prodcut:"+product.toString());
		System.out.println("사진이름 : "+file.getOriginalFilename());
		
		int checkNum=0;
		String proPhoto;
		
		if(product.getProName().equals("")||product.getProMaker().equals("")) {//공백 체크
			checkNum=1;
		}else if(product.getProPrice()==-1||product.getProAmount()==-1) {
			checkNum=2;
		}
		else {
			File f =new File("E:\\it 강의\\spring\\eclipse\\springworkspace\\Magicmall\\src\\main\\webapp\\resources\\images",file.getOriginalFilename());
			proPhoto=file.getOriginalFilename();
			System.out.println(f.getAbsolutePath());
			if(!(proPhoto.isEmpty())) {//파일 공백 확인
				file.transferTo(f);
				product.setProPhoto(proPhoto);
			}
			
						
			System.out.println("product check2:"+product.toString());
			proService.editPro(product);
			System.out.println("제품 수정 완료");
			
		}
		
		if(checkNum==0) {
			return"/adminProduct/proEdit_success";
		}else {
			model.addAttribute("checkNum",checkNum);
			model.addAttribute("proNo",product.getProNo());
			return"/adminProduct/proEdit_fail";
		}
		
		
	}
	

}
