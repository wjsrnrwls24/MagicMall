package com.spring.magicMall.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.magicMall.board.commons.BoardSearchVO;
import com.spring.magicMall.board.model.BoardVO;
import com.spring.magicMall.board.repository.IBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class BoardTest {
	
	@Autowired
	private IBoardMapper boardMap;
	
	
	
	@Test//게시물 입력 테스트
	public void insertTest() {
		BoardVO board = new BoardVO();

		for(int a =1 ; a<=500 ;a++) {
			board.setUserNo(8);
			board.setTitle("몰라"+a);
			board.setContent("나는 모른다");
			board.setPicName("사진이름");
			boardMap.insertContent(board);
		}
		
		
	}
	
	@Test//게시글 불러오기
	public void artiList() {
		BoardSearchVO search = new BoardSearchVO();
		search.setPage(0);
		search.setCountPerPage(10);
		List<BoardVO> boards = boardMap.getArticleList(search);
		
		for(BoardVO board: boards) {
			System.out.println("board:"+board.toString());
			System.out.println();
		}
	}
	@Test//게시글 수 불러오기
	public void artiNum() {
		BoardSearchVO search = new BoardSearchVO();
		int num= boardMap.countArticles(search);
		System.out.println("게시글 수:"+num);
	}
	
	@Test//개별 게시물 불러고익
	public void oneArticl() {
		BoardVO article = boardMap.getOneArticle(506);
		System.out.println("article:"+article.toString());
	}
	
	@Test//게시물 수정
	public void editTest() {
		BoardVO board = new BoardVO();
		board.setTitle("수정");
		board.setPostNo(505);
		board.setContent("수정됨");
		board.setPicName("사진은 없어");
		boardMap.editArticle(board);
	}
	
	@Test//게시물 삭제
	public void delTest() {
		BoardVO board = new BoardVO();
		board.setPostNo(505);
		
		boardMap.delArticle(board);
	}

}
