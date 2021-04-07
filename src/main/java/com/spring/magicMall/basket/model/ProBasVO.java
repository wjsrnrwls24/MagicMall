package com.spring.magicMall.basket.model;

import com.spring.magicMall.adminProduct.model.ProductVO;

public class ProBasVO {
	private ProductVO product;
	private BasketVO basket;
	
	public ProductVO getProduct() {
		return product;
	}
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	public BasketVO getBasket() {
		return basket;
	}
	public void setBasket(BasketVO basket) {
		this.basket = basket;
	}
	

}
