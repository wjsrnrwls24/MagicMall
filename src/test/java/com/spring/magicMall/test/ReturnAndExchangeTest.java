package com.spring.magicMall.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.magicMall.myPage.model.ReExInfoVO;
import com.spring.magicMall.myPage.model.ReturnExchangeVO;
import com.spring.magicMall.myPage.repository.IExchangeAndUserDropMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class ReturnAndExchangeTest {

	
	@Autowired
	private IExchangeAndUserDropMapper exMap;
	
	
	@Test//반품 및 교환 신청 테스트
	public void reExAddTest() {
		ReturnExchangeVO reEx = new ReturnExchangeVO();
		reEx.setOrderNo(21251716);
		reEx.setProNo(13);
		reEx.setUserNo(7);
		reEx.setReExAmount(1);
		reEx.setReExChoose("반품");
		reEx.setReExEmail("wjsrnrwls@2522");
		reEx.setReExOrderer("민식이");
		reEx.setReExPhoto("사진");
		reEx.setReExReason("없어");
		exMap.returnAndExchangeAdd(reEx);
		
	}
	@Test//반품 및 교환 목록 가져오기
	public void reExlistsTest() {
		List<ReExInfoVO> reExLists = exMap.reExInfo();
		for(ReExInfoVO reExList : reExLists) {
			System.out.println("product:"+reExList.getProduct().toString());
			System.out.println();
			System.out.println("orderInfo:"+reExList.getOrderInfo().toString());
			System.out.println();
			System.out.println("reEx:"+reExList.getReturnExchange().toString());
			System.out.println();
			System.out.println();
		}
	}
}
