package com.spring.magicMall.board.controller;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
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
import org.springframework.web.multipart.MultipartFile;

import com.spring.magicMall.board.commons.BoardSearchVO;
import com.spring.magicMall.board.model.BoardVO;
import com.spring.magicMall.board.service.IBoardService;
import com.spring.magicMall.board.commons.PageCreater;
import com.spring.magicMall.board.commons.BoardSearchVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService boardService;
	
	
	//게시글 조회 하기
	@GetMapping("/list")
	public String list(BoardSearchVO search, Model model, HttpServletRequest request) {
		
		String condition=search.getCondition();
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("login");
		
		System.out.println("url: /board/list GET->reslut:");
		System.out.println("page 번호"+search.getPage());
		System.out.println("검색 조건"+condition);
		System.out.println("검색어"+search.getKeyword());
		
		PageCreater pc = new PageCreater();
		pc.setPaging(search);
		
		List<BoardVO> list = boardService.getArticleList(search);
		pc.setArticleTotalCount(boardService.countArticles(search));
		model.addAttribute("articles",list);
		model.addAttribute("pc",pc);
		model.addAttribute("userNo",userNo);
		return"/board/list";
		
	}
	
	//개별 게시물 조회
	@GetMapping("/content")
	public String content(@RequestParam("postNo") int postNo,
							Model model,
							HttpServletRequest request){
		System.out.println("개별 게시물 조회 진입");
		System.out.println("postNo:"+postNo);
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("login");
		System.out.println("세션 받기 완료");
		BoardVO board = boardService.getOneArticle(postNo);
		System.out.println("board:"+board.toString());
		model.addAttribute("board",board);
		model.addAttribute("userNo",userNo);
		return"/board/content";
		
	}

	
	//게시글 등록 페이지로
	@GetMapping("/register")
	public String register(HttpServletRequest request,Model model) {
		
		System.out.println("게시물 등록 페이지 진입");
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("login");
		System.out.println("세션 받기 완료");
		model.addAttribute("userNo",userNo);
		return"/board/insertPage";
	}
	
	//게시글 등록 실행
	@PostMapping("/registerEx")
	public String registerEx(BoardVO board,
							@RequestParam("file") MultipartFile file,
							Model model) throws IllegalStateException, IOException {
		System.out.println("게시글 등록 진입");
		System.out.println("board:"+board.toString());
		
		int checkNum=0;
		String proPhoto;
		if(board.getTitle().equals("")||board.getContent().equals("")) {//공백 확인
			checkNum=1;
		}else if(board.getTitle().length()>20||board.getContent().length()>200) {//입력 길이 확인
			checkNum=2;
		}else {			
				File f =new File("E:\\it 강의\\spring\\eclipse\\springworkspace\\Magicmall\\src\\main\\webapp\\resources\\images\\board\\"+board.getUserNo(),file.getOriginalFilename());
				proPhoto=board.getUserNo()+"\\"+file.getOriginalFilename();
				System.out.println(f.getAbsolutePath());
				System.out.println(proPhoto);
				File folder = new File("E:\\it 강의\\spring\\eclipse\\springworkspace\\Magicmall\\src\\main\\webapp\\resources\\images\\board\\"+board.getUserNo());
				if(!folder.exists()) {//폴더 생성
					folder.mkdir();
					System.out.println("폴더 생성");
				}
				if(!(proPhoto.equals(board.getUserNo()+"\\"))) {//파일 공백 확인
					System.out.println("파일 공백 확인중");
					file.transferTo(f);
					board.setPicName(proPhoto);
				}
				System.out.println("board 2차:"+board.toString());
				boardService.insertContent(board);
				System.out.println("등록완료");
		}
		System.out.println("checkNum:"+checkNum);
		if(checkNum==0) {
			return"/board/registerEx_success";
		}else {
			model.addAttribute("checkNum",checkNum);
			return"/board/registerEx_fail";
		}
		
		
	}
	
	//게시물 수정 페이지로
	@GetMapping("/edit")
	public String edit(BoardVO board,Model model) {
		System.out.println("수정페이지 진입");
		System.out.println("board:"+board.toString());
		model.addAttribute("board",board);
		return"/board/edit";
		
	}
	
	//게시글 수정 실행
	@PostMapping("/editEx")
	public String editEx(BoardVO board,
						Model model,
						@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		System.out.println("게시글 수정 진입");
		System.out.println("board:"+board.toString());
		
		int checkNum=0;
		String proPhoto;
		if(board.getTitle().equals("")||board.getContent().equals("")) {//공백 확인
			checkNum=1;
		}else if(board.getTitle().length()>20||board.getContent().length()>200) {//입력 길이 확인
			checkNum=2;
		}else {			
			File f =new File("E:\\it 강의\\spring\\eclipse\\springworkspace\\Magicmall\\src\\main\\webapp\\resources\\images\\board\\"+board.getUserNo(),file.getOriginalFilename());
			proPhoto=board.getUserNo()+"\\"+file.getOriginalFilename();
			System.out.println(f.getAbsolutePath());
			System.out.println(proPhoto);
			File folder = new File("E:\\it 강의\\spring\\eclipse\\springworkspace\\Magicmall\\src\\main\\webapp\\resources\\images\\board\\"+board.getUserNo());
			if(!folder.exists()) {//폴더 생성
				folder.mkdir();
				System.out.println("폴더 생성");
			}
			if(!(proPhoto.equals(board.getUserNo()+"\\"))) {//파일 공백 확인
				System.out.println("파일 공백 확인중");
				file.transferTo(f);
				board.setPicName(proPhoto);
			}
				System.out.println("board 2차:"+board.toString());
				boardService.editArticle(board);
				System.out.println("수정완료");
		}
		System.out.println("checkNum:"+checkNum);
		if(checkNum==0) {
			return"/board/edit_Success";
		}else {
			model.addAttribute("checkNum",checkNum);
			model.addAttribute("board",board);
			return"/board/edit_Fail";
		}
		
	}
	
	//게시글 삭제
	@PostMapping("/deleteEx")
	public String deleteEx(BoardVO board) {
		System.out.println("게시글 삭제 진입");
		System.out.println("boardVO:"+board.toString());
		boardService.delArticle(board);
		System.out.println("삭제 성공");
		return"/board/deleteEx_success";
	}


}
