package com.spring.magicMall.order.commons;

public class MoneyCheckVO {
	
	private int moneyUseCheck;
	private int selCheck;

	public int getMoneyUseCheck() {
		return moneyUseCheck;
	}

	public void setMoneyUseCheck(int moneyUseCheck) {
		this.moneyUseCheck = moneyUseCheck;
	}
	

	public int getSelCheck() {
		return selCheck;
	}

	public void setSelCheck(int selCheck) {
		this.selCheck = selCheck;
	}

	@Override
	public String toString() {
		return "MoneyCheckVO [moneyUseCheck=" + moneyUseCheck + ", selCheck=" + selCheck + "]";
	}


	
	
	

}
