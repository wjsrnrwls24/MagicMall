package com.spring.magicMall.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magicMall.board.commons.BoardSearchVO;
import com.spring.magicMall.board.model.BoardVO;
import com.spring.magicMall.board.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardMapper mapper;
	
	@Override//게시글 등록
	public void insertContent(BoardVO board) {
		mapper.insertContent(board);
		
	}
	
	@Override//게시글 가져오기
	public List<BoardVO> getArticleList(BoardSearchVO search) {
		
		return mapper.getArticleList(search);
	}
	
	@Override//게시글 수 세기
	public int countArticles(BoardSearchVO search) {
		
		return mapper.countArticles(search);
	}
	
	@Override//개별 게시물 가져오기
	public BoardVO getOneArticle(int postNo) {
		
		return mapper.getOneArticle(postNo);
	}
	
	@Override//게시글 수정
	public void editArticle(BoardVO board) {
		mapper.editArticle(board);
		
	}
	
	@Override//게시글 삭제
	public void delArticle(BoardVO board) {
		mapper.delArticle(board);
		
	}

}
