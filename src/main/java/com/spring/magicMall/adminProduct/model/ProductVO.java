package com.spring.magicMall.adminProduct.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.spring.magicMall.basket.model.BasketVO;

@Component
public class ProductVO {
	
	private int proNo;
	private String proPhoto;
	private String proName;
	private int proSavedMoney;
	private int proAmount;
	private int proPrice;
	private String proMaker;
	private int proBuyNum;
	private String proDetail;
	private String youtubeAdd;
	private int proAmountRequest;
	private Date proRegDate;
	private String category;
		
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getProPhoto() {
		return proPhoto;
	}
	public void setProPhoto(String proPhoto) {
		this.proPhoto = proPhoto;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProSavedMoney() {
		return proSavedMoney;
	}
	public void setProSavedMoney(int proSavedMoney) {
		this.proSavedMoney = proSavedMoney;
	}
	public int getProAmount() {
		return proAmount;
	}
	public void setProAmount(int proAmount) {
		this.proAmount = proAmount;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public String getProMaker() {
		return proMaker;
	}
	public void setProMaker(String proMaker) {
		this.proMaker = proMaker;
	}
	public int getProBuyNum() {
		return proBuyNum;
	}
	public void setProBuyNum(int proBuyNum) {
		this.proBuyNum = proBuyNum;
	}
	public String getProDetail() {
		return proDetail;
	}
	public void setProDetail(String proDetail) {
		this.proDetail = proDetail;
	}
	public String getYoutubeAdd() {
		return youtubeAdd;
	}
	public void setYoutubeAdd(String youtubeAdd) {
		this.youtubeAdd = youtubeAdd;
	}
	public int getProAmountRequest() {
		return proAmountRequest;
	}
	public void setProAmountRequest(int proAmountRequest) {
		this.proAmountRequest = proAmountRequest;
	}
	public Date getProRegDate() {
		return proRegDate;
	}
	public void setProRegDate(Date proRegDate) {
		this.proRegDate = proRegDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "ProductVO [proNo=" + proNo + ", proPhoto=" + proPhoto + ", proName=" + proName + ", proSavedMoney="
				+ proSavedMoney + ", proAmount=" + proAmount + ", proPrice=" + proPrice + ", proMaker=" + proMaker
				+ ", proBuyNum=" + proBuyNum + ", proDetail=" + proDetail + ", youtubeAdd=" + youtubeAdd
				+ ", proAmountRequest=" + proAmountRequest + ", proRegDate=" + proRegDate + ", category=" + category
				+ "]";
	}
	

}
