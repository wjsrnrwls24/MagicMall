package com.spring.magicMall.basket.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.magicMall.basket.model.BasketVO;
import com.spring.magicMall.basket.model.ProBasVO;


@Repository
public interface IBasketMapper {
	
	
	//장바구니 물품 조회
	List<ProBasVO> allBasketPro(int userNo);
	
	//개별 장바구니 물품 가져오기
	ProBasVO basketPro(BasketVO basket);
	
	//장바구니 물품 삽입
	void insertBasket(BasketVO basket);
	
	//장바구니 수량 조정
	void changetAmount(BasketVO basket);
	
	//장바구니 물품 삭제
	void deleteBasket(BasketVO basket);

}
