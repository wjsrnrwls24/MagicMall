package com.spring.magicMall.myPage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.magicMall.myPage.model.ReExInfoVO;
import com.spring.magicMall.myPage.model.ReturnExchangeVO;

@Service
public interface IExchangeAndUserDropService {
	
	//반품 및 교환 등록
	void returnAndExchangeAdd(ReturnExchangeVO returnExchange);
	
	//반품 및 교환 내역 가져오기
	List<ReExInfoVO> reExInfo();
	
	//반품 및 교환 내역 삭제
	void returnAndExchangeDel(ReturnExchangeVO returnExchange);
	


}
