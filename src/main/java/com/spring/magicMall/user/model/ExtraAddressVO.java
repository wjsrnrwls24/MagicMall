package com.spring.magicMall.user.model;

import org.springframework.stereotype.Component;

@Component
public class ExtraAddressVO {
	
	private int addNo;
	private int userNo;
	private String addName;
	private String address;
	
	
	
	public int getAddNo() {
		return addNo;
	}
	public void setAddNo(int addNo) {
		this.addNo = addNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getAddName() {
		return addName;
	}
	public void setAddName(String addName) {
		this.addName = addName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "ExtraAddressVO [addNo=" + addNo + ", userNo=" + userNo + ", addName=" + addName + ", address=" + address
				+ "]";
	}

}
