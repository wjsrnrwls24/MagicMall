package com.spring.magicMall.basket.service;

import java.util.List;

import com.spring.magicMall.basket.model.BasketVO;
import com.spring.magicMall.basket.model.ProBasVO;

public interface IBasketService {

	
	//장바구니 물품 조회
	List<ProBasVO> allBasketPro(int userNo);
	
	//장바구니 물품 삽입
	void insertBasket(BasketVO basket);
	
	//장바구니 수량 조정
	void changetAmount(BasketVO basket);
	
	//장바구니 물품 삭제
	void deleteBasket(BasketVO basket);
}
