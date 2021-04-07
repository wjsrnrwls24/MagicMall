package com.spring.magicMall.myPage.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.magicMall.myPage.model.ReExInfoVO;
import com.spring.magicMall.myPage.model.ReturnExchangeVO;


@Repository
public interface IExchangeAndUserDropMapper {
	
	//반품 및 교환 등록
	void returnAndExchangeAdd(ReturnExchangeVO returnExchange);
	
	//반품 및 교환 내역 가져오기
	List<ReExInfoVO> reExInfo();
	
	//반품 및 교환 내역 삭제
	void returnAndExchangeDel(ReturnExchangeVO returnExchange);
	
	
	
	

}
