package com.spring.magicMall.adminProduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.repository.IProductMapper;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.product.commons.ProductSearchVO;
@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductMapper mapper;
	
	
	@Override//제품 등록
	public void insertPro(ProductVO product) {
		mapper.insertPro(product);
		
	}
	
	@Override//제품 전체 가지고 오기
	public List<ProductVO> selectAllPro(SearchVO search) {
		
		return mapper.selectAllPro(search);
		}
	
	@Override//많이 팔린 제품 순 조회 관리자 페이지 용
	public List<ProductVO> selectMostSaleReal(SearchVO search) {
		
		return mapper.selectMostSaleReal(search);
	}
	
	@Override//개별 제품 조회
	public ProductVO selectOnePro(int proNo) {
		
		return mapper.selectOnePro(proNo);
	}
	
	@Override//제품 번호만 가져오기
	public int[] proNoGet() {
		
		return mapper.proNoGet();
	}
	
	@Override//제품 목록 조회(관리자용)
	public List<ProductVO> selectProsAdmin(SearchVO search) {
		
		return mapper.selectProsAdmin(search);
	}
	
	@Override	//제품 수 세기(관리자용)
	public int countProductAdmin(SearchVO search) {
		
		return mapper.countProductAdmin(search);
	}
	
	@Override	//유저 제품 조회(이게 진짜)
	public List<ProductVO> userProList(ProductSearchVO search) {
		
		return mapper.userProList(search);
	}
	
	
	@Override//제품 삭제
	public void deletePro(int proNo) {
		mapper.deletePro(proNo);
		
	}
	
	@Override//제품 수정
	public void editPro(ProductVO product) {
		mapper.editPro(product);
		
	}
	
	@Override//재고 요청
	public void proAmountRe(int proNo) {
		mapper.proAmountRe(proNo);
		
	}
	
	@Override//재고 해결 기능
	public void proAmountReFin(int proNo) {
		mapper.proAmountReFin(proNo);
		
	}
	
	
	@Override//구매시 제품 수량 및 재고 변경
	public void proAmountAndBuyNum(OrderListVO orderList) {
		mapper.proAmountAndBuyNum(orderList);
	
	}
	
	@Override	//유저 제품 조회 수 세기
	public int userProListCount(ProductSearchVO search) {
		
		return mapper.userProListCount(search);
	}
}
