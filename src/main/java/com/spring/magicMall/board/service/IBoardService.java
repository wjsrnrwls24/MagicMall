package com.spring.magicMall.board.service;

import java.util.List;

import com.spring.magicMall.board.commons.BoardSearchVO;
import com.spring.magicMall.board.model.BoardVO;

public interface IBoardService {
	
	//게시물 등록하기
	void insertContent(BoardVO board);
	
	//게시글 가져오기
	List<BoardVO> getArticleList(BoardSearchVO search);
	
	//게시글 수 새기
	int countArticles(BoardSearchVO search);
	
	//개별 게시물 가져오기
	BoardVO getOneArticle(int postNo);
	
	//게시물 수정하기
	void editArticle(BoardVO board);
	
	//게시물 삭제하기
	void delArticle(BoardVO board);

}
