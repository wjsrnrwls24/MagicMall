package com.spring.magicMall.adminProduct.service;

import java.util.List;

import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.product.commons.ProductSearchVO;


public interface IProductService {
	
	//제품 등록
	void insertPro(ProductVO product);
	
	//관리자 제품 조회
	List<ProductVO> selectAllPro(SearchVO search);
	
	//많이 팔린 제품순(나중에 이걸로 통합)
	List<ProductVO> selectMostSaleReal (SearchVO search);
	
	//개별 제품 조회
	ProductVO selectOnePro(int proNo);
	
	//제품 번호만 가져오기
	int[] proNoGet();
	
	//제품 수 세기(관리자용)
	int countProductAdmin(SearchVO search);
	
	//제품 목록 조회(관리자용)
	List<ProductVO> selectProsAdmin(SearchVO search);
	
	//제품 삭제
	void deletePro(int proNo);
	
	//제품 수정
	void editPro(ProductVO product);
	
	//제품 재고 요청 기능
	void proAmountRe(int proNo);
	
	//제품 재고 해결 기능
	void proAmountReFin(int proNo);
	
	//제품 재고 및 구매 수량 변경
	void proAmountAndBuyNum(OrderListVO orderList);
	
	//유저 제품 조회
	List<ProductVO> userProList(ProductSearchVO search);
	
	//유저 제품 조회 수 세기
	int userProListCount(ProductSearchVO search);

	
	


}
