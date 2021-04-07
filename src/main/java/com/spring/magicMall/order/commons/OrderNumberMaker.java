package com.spring.magicMall.order.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

public class OrderNumberMaker {
	
	
	
	public String numberMaker(int proNo) {
		//지금 날짜 가져오기
		
		java.util.Date now = new java.util.Date();
		SimpleDateFormat vans = new SimpleDateFormat("yyms");
		System.out.println(vans);
		String wdate = vans.format(now);
		
		String orderNum = wdate+proNo;
		System.out.println("orderNum:"+orderNum);
		
		return orderNum;
	}
	
	

}
