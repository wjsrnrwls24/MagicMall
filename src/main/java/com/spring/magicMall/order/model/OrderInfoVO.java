package com.spring.magicMall.order.model;

import java.util.Date;

public class OrderInfoVO {
	
	private Integer orderNo;
	private Integer userNo;
	private String orderer;
	private String orPhone;
	private String orAddress;
	private String orEmail;
	private String receiver;
	private Date ordate;
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public String getOrderer() {
		return orderer;
	}
	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}
	public String getOrPhone() {
		return orPhone;
	}
	public void setOrPhone(String orPhone) {
		this.orPhone = orPhone;
	}
	public String getOrAddress() {
		return orAddress;
	}
	public void setOrAddress(String orAddress) {
		this.orAddress = orAddress;
	}
	public String getOrEmail() {
		return orEmail;
	}
	public void setOrEmail(String orEmail) {
		this.orEmail = orEmail;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Date getOrdate() {
		return ordate;
	}
	public void setOrdate(Date ordate) {
		this.ordate = ordate;
	}
	@Override
	public String toString() {
		return "OrderInfoVO [orderNo=" + orderNo + ", userNo=" + userNo + ", orderer=" + orderer + ", orPhone="
				+ orPhone + ", orAddress=" + orAddress + ", orEmail=" + orEmail + ", receiver=" + receiver + ", ordate="
				+ ordate + "]";
	}
	
	

}
