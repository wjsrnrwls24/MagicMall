package com.spring.magicMall.board.commons;

public class BoardSearchVO extends PageVO {
	
	private String keyword;
	private String condition;
	
	public BoardSearchVO() {
		this.keyword="";
		this.condition="";
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

}
