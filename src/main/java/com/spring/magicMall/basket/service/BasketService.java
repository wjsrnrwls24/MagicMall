package com.spring.magicMall.basket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magicMall.basket.model.BasketVO;
import com.spring.magicMall.basket.model.ProBasVO;
import com.spring.magicMall.basket.repository.IBasketMapper;

@Service
public class BasketService implements IBasketService {

	@Autowired
	private IBasketMapper mapper;
	
	//장바구니 물품 조회
	public List<ProBasVO> allBasketPro(int userNo) {
		
		return mapper.allBasketPro(userNo) ;
	}
	
	//개별 장바구니 물품 가져오기
	@Override
	public ProBasVO basketPro(BasketVO basket) {
		
		return mapper.basketPro(basket);
	}
	
	//장바구니 물품 넣기
	@Override
	public void insertBasket(BasketVO basket) {
		mapper.insertBasket(basket);
		
	}
	
	@Override//장바구니 수량 조정
	public void changetAmount(BasketVO basket) {
		mapper.changetAmount(basket);
		
	}
	
	@Override//장바구니 물품 삭제
	public void deleteBasket(BasketVO basket) {
		mapper.deleteBasket(basket);
		
	}

}
