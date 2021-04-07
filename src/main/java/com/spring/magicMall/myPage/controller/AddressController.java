package com.spring.magicMall.myPage.controller;

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

import com.spring.magicMall.user.model.ExtraAddressVO;
import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.service.IExtraAddressService;
import com.spring.magicMall.user.service.IUserService;

@Controller
@RequestMapping("/mypage")
public class AddressController {
	
	@Autowired
	private IExtraAddressService addService;
	@Autowired
	private IUserService userService;
	
	
	
	//마이페이지로 이동
	@GetMapping("")
	public String mypage(HttpServletRequest request,Model model) {
		
		HttpSession session = request.getSession();
		Integer userNO=(Integer) session.getAttribute("login");
		System.out.println("userNO:"+userNO);
		
		UserVO user=userService.oneUser(userNO);
		System.out.println("user:"+user.toString());
		
		model.addAttribute("user",user);
		
		return "mypage/mypage";
	}
	
	//배송 주소록 관리 페이지로 이동
	@GetMapping("/address")
	public String address(Model model,@RequestParam("userNo") int userNo) {
		
		List<ExtraAddressVO> addresses = addService.addresses(userNo);
		model.addAttribute("addresses",addresses);
		model.addAttribute("userNo",userNo);
		return "/mypage/address";
	}
	
	//배송 주소록 등록 페이지로 이동
	@GetMapping("/addressAdd")
	public String addressAdd(Model model,@RequestParam("userNo") int userNo) {
		model.addAttribute("userNo",userNo);
		return "/mypage/addressAdd";
	}
	
	//배송 주소록 등록 실행
	@PostMapping("/addressAddEx")
	public String addressAddEx(ExtraAddressVO Useraddress,
					@RequestParam("add1") String add1,
					@RequestParam("add2") String add2,
					@RequestParam("add3") String add3,
					Model model) {
		System.out.println("address value:"+Useraddress.toString());
		System.out.println("add1:"+add1);
		System.out.println("add2:"+add2);
		System.out.println("add3:"+add3);
		
		if(Useraddress.getAddName().equals("")||add1.equals("")||
				add2.equals("")||add3.equals("")) {//공백 체크
			System.out.println("저장 실패");
			model.addAttribute("userNo",Useraddress.getUserNo());
			return"/mypage/addressAdd_fail";
		}else if(Useraddress.getAddName().length()>50||add1.length()>20||add2.length()>30||add3.length()>30) {
			System.out.println("저장 실패");
			model.addAttribute("userNo",Useraddress.getUserNo());
			return"/mypage/addressAdd_fail";
		}else{//주소지 등록 실행
			addService.addAddress(Useraddress, add1, add2, add3);
			System.out.println("저장 성공");
			model.addAttribute("userNo",Useraddress.getUserNo());
			return"/mypage/addressAdd_success";
		}
		
	}
	
	//배송 주소지 삭제 실행
	@PostMapping("/addressDeleteEx")
	public String addressDeleteEx(@RequestParam("addNo")int addNo,
								  @RequestParam("userNo")int userNo,
								  RedirectAttributes redirect) {
		System.out.println("addNO:"+addNo);
		System.out.println("userNo:"+userNo);
		
		addService.addressDelete(addNo);
		System.out.println("삭제 성공");
		redirect.addAttribute("userNo",userNo);
		return "redirect:/mypage/address";
	}

	//배송지 수정 페이지로
	@GetMapping("/addressEdit")
	public String addressEdit(Model model,
							@RequestParam("addNo") int addNo) {
		
		ExtraAddressVO address = addService.oneAddress(addNo);
		System.out.println("address: "+address.toString());
		model.addAttribute("address",address);
		System.out.println("배송지 페이지로 ");
	return "/mypage/addressEdit";
	}
	
	//배송지 수정 실행
	@PostMapping("/addressEditEx")
	public String addressEditEx(ExtraAddressVO Useraddress,
					@RequestParam("add1") String add1,
					@RequestParam("add2") String add2,
					@RequestParam("add3") String add3,
					Model model) {
		System.out.println("address value:"+Useraddress.toString());
		System.out.println("add1:"+add1);
		System.out.println("add2:"+add2);
		System.out.println("add3:"+add3);
		
		if(Useraddress.getAddName().equals("")||add1.equals("")||
				add2.equals("")||add3.equals("")) {//공백 체크
			System.out.println("수정 실패");
			model.addAttribute("addNo",Useraddress.getAddNo());
			return"/mypage/addressEdit_fail";
		}else if(Useraddress.getAddName().length()>50||add1.length()>20||add2.length()>30||add3.length()>30) {
			System.out.println("저장 실패");
			model.addAttribute("addNo",Useraddress.getAddNo());
			return"/mypage/addressEdit_fail";
		}else{//주소지 수정 실행
			addService.addAddress(Useraddress, add1, add2, add3);
			System.out.println("수정 성공");
			model.addAttribute("userNo",Useraddress.getUserNo());
			return"/mypage/addressEdit_success";
		}
		
	}
}
