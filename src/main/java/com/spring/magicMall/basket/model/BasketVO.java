package com.spring.magicMall.basket.model;

import org.springframework.stereotype.Component;

@Component
public class BasketVO {
	private Integer proNo;
	private Integer userNo;
	private Integer shopOrAmount;
	
	public Integer getProNo() {
		return proNo;
	}
	public void setProNo(Integer proNo) {
		this.proNo = proNo;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public Integer getShopOrAmount() {
		return shopOrAmount;
	}
	public void setShopOrAmount(Integer shopOrAmount) {
		this.shopOrAmount = shopOrAmount;
	}
	@Override
	public String toString() {
		return "BasketVO [proNo=" + proNo + ", userNo=" + userNo + ", shopOrAmount=" + shopOrAmount + "]";
	}
	
	

}
