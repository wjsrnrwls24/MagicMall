package com.spring.magicMall.adminProduct.commons;

import org.springframework.stereotype.Component;

import com.spring.magicMall.board.commons.PageVO;

@Component
public class SearchVO extends PageVO {
	
	private String keyword;
	private String condition;
	private String mostSale;
	
	
	
	public String getMostSale() {
		return mostSale;
	}
	public void setMostSale(String mostSale) {
		this.mostSale = mostSale;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "SearchVO [keyword=" + keyword + ", condition=" + condition + ", mostSale=" + mostSale + "]";
	}

	
	
	}
