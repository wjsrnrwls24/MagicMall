package com.spring.magicMall.product.model;

import org.springframework.stereotype.Component;

@Component
public class ReviewVO {
	
	private int reviewNo;
	private int proNo;
	private String reviewWriter;
	private String reviewContent;
	private int reviewCompen;
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getReviewCompen() {
		return reviewCompen;
	}
	public void setReviewCompen(int reviewCompen) {
		this.reviewCompen = reviewCompen;
	}
	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", proNo=" + proNo + ", reviewWriter=" + reviewWriter
				+ ", reviewContent=" + reviewContent + ", reviewCompen=" + reviewCompen + "]";
	}
	
	

}
