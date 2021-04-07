package com.spring.magicMall.order.model;

import com.spring.magicMall.adminProduct.model.ProductVO;

public class OrderDetailVO {
	
	private OrderInfoVO orderInfo;
	private OrderListVO orderList;
	private ProductVO product;
	public OrderInfoVO getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfoVO orderInfo) {
		this.orderInfo = orderInfo;
	}
	public OrderListVO getOrderList() {
		return orderList;
	}
	public void setOrderList(OrderListVO orderList) {
		this.orderList = orderList;
	}
	public ProductVO getProduct() {
		return product;
	}
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	

}
