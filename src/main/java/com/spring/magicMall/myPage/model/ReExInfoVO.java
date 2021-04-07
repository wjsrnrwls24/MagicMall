package com.spring.magicMall.myPage.model;

import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.order.model.OrderInfoVO;

public class ReExInfoVO {
	
	private ProductVO product;
	private OrderInfoVO orderInfo;
	private ReturnExchangeVO returnExchange;
	
	public ProductVO getProduct() {
		return product;
	}
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	public OrderInfoVO getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfoVO orderInfo) {
		this.orderInfo = orderInfo;
	}
	public ReturnExchangeVO getReturnExchange() {
		return returnExchange;
	}
	public void setReturnExchange(ReturnExchangeVO returnExchange) {
		this.returnExchange = returnExchange;
	}
	
	

}
