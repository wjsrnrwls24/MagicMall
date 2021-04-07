package com.spring.magicMall.myPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magicMall.myPage.model.ReExInfoVO;
import com.spring.magicMall.myPage.model.ReturnExchangeVO;
import com.spring.magicMall.myPage.repository.IExchangeAndUserDropMapper;

@Service
public class ExchangeAndUserDropService implements IExchangeAndUserDropService {

	@Autowired
	private IExchangeAndUserDropMapper mapper;
	
	//반품 및 교환 등록
	@Override
	public void returnAndExchangeAdd(ReturnExchangeVO returnExchange) {
		mapper.returnAndExchangeAdd(returnExchange);
		
	}
	
	@Override//반품 내역 가져오기
	public List<ReExInfoVO> reExInfo() {
		
		return mapper.reExInfo();
	}
	
	@Override//반품 및 교환 내역 삭제
	public void returnAndExchangeDel(ReturnExchangeVO returnExchange) {
		mapper.returnAndExchangeDel(returnExchange);
		
	}
}
