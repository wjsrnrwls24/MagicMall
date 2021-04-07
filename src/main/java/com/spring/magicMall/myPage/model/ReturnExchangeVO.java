package com.spring.magicMall.myPage.model;

import org.springframework.stereotype.Component;

@Component
public class ReturnExchangeVO {
	
	private Integer orderNo;
	private Integer proNo;
	private Integer userNo;
	private String reExChoose;
	private Integer reExAmount;
	private String reExReason;
	private String reExOrderer;
	private String reExEmail;
	private String reExPhoto;
	
	
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getProNo() {
		return proNo;
	}
	public void setProNo(Integer proNo) {
		this.proNo = proNo;
	}
	public String getReExChoose() {
		return reExChoose;
	}
	public void setReExChoose(String reExChoose) {
		this.reExChoose = reExChoose;
	}
	public Integer getReExAmount() {
		return reExAmount;
	}
	public void setReExAmount(Integer reExAmount) {
		this.reExAmount = reExAmount;
	}
	public String getReExReason() {
		return reExReason;
	}
	public void setReExReason(String reExReason) {
		this.reExReason = reExReason;
	}
	public String getReExOrderer() {
		return reExOrderer;
	}
	public void setReExOrderer(String reExOrderer) {
		this.reExOrderer = reExOrderer;
	}
	public String getReExEmail() {
		return reExEmail;
	}
	public void setReExEmail(String reExEmail) {
		this.reExEmail = reExEmail;
	}
	public String getReExPhoto() {
		return reExPhoto;
	}
	public void setReExPhoto(String reExPhoto) {
		this.reExPhoto = reExPhoto;
	}
	@Override
	public String toString() {
		return "ReturnExchangeVO [orderNo=" + orderNo + ", proNo=" + proNo + ", userNo=" + userNo + ", reExChoose="
				+ reExChoose + ", reExAmount=" + reExAmount + ", reExReason=" + reExReason + ", reExOrderer="
				+ reExOrderer + ", reExEmail=" + reExEmail + ", reExPhoto=" + reExPhoto + "]";
	}
	
	
	

}
