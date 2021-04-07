package com.spring.magicMall.order.model;

import org.springframework.stereotype.Component;

@Component
public class OrderListVO {
	
	private Integer proNo;
	private Integer orderNo;
	private Integer orAmount;
	private String orMessage;
	private String shippingStat;
	private Integer orderStat;
	
	public Integer getProNo() {
		return proNo;
	}
	public void setProNo(Integer proNo) {
		this.proNo = proNo;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getOrAmount() {
		return orAmount;
	}
	public void setOrAmount(Integer orAmount) {
		this.orAmount = orAmount;
	}
	public String getOrMessage() {
		return orMessage;
	}
	public void setOrMessage(String orMessage) {
		this.orMessage = orMessage;
	}
	public String getShippingStat() {
		return shippingStat;
	}
	public void setShippingStat(String shippingStat) {
		this.shippingStat = shippingStat;
	}
	public Integer getOrderStat() {
		return orderStat;
	}
	public void setOrderStat(Integer orderStat) {
		this.orderStat = orderStat;
	}
	@Override
	public String toString() {
		return "OrderListVO [proNo=" + proNo + ", orderNo=" + orderNo + ", orAmount=" + orAmount + ", orMessage="
				+ orMessage + ", shippingStat=" + shippingStat + ", orderStat=" + orderStat + "]";
	}
	
	

}
