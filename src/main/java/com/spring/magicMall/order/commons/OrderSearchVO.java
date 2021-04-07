package com.spring.magicMall.order.commons;

import org.springframework.context.annotation.Configuration;

import com.spring.magicMall.board.commons.PageVO;

@Configuration("orderSearchVO")
public class OrderSearchVO extends PageVO {
	
	private String userId;
	private Integer userNo;
	private Integer orderNo;
	private String condition;
	private String keyword;
	private String dateLength;
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDateLength() {
		return dateLength;
	}
	public void setDateLength(String dateLength) {
		this.dateLength = dateLength;
	}
	@Override
	public String toString() {
		return "OrderSearchVO [userId=" + userId + ", userNo=" + userNo + ", orderNo=" + orderNo + ", condition="
				+ condition + ", keyword=" + keyword + ", dateLength=" + dateLength + "]";
	}

	

	
	
	

	

}
