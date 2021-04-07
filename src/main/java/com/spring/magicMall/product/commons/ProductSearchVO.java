package com.spring.magicMall.product.commons;

import org.springframework.stereotype.Component;

import com.spring.magicMall.board.commons.PageVO;

@Component
public class ProductSearchVO extends PageVO {
	
	private String condition;
	private String keyword;
	private String category;
	private String priceSet;
	private Integer lowPrice;
	private Integer highPrice;
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getPriceSet() {
		return priceSet;
	}
	public void setPriceSet(String priceSet) {
		this.priceSet = priceSet;
	}
	
	public Integer getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(Integer lowPrice) {
		this.lowPrice = lowPrice;
	}
	public Integer getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(Integer highPrice) {
		this.highPrice = highPrice;
	}
	@Override
	public String toString() {
		return "ProductSearchVO [condition=" + condition + ", keyword=" + keyword + ", category=" + category
				+ ", priceSet=" + priceSet + ", lowPrice=" + lowPrice + ", highPrice=" + highPrice + "]";
	}
	
	
	
}


