package com.spring.magicMall.board.model;

import java.util.Date;

public class BoardVO {
	private Integer postNo;
	private Integer userNo;
	private String title;
	private String content;
	private String picName;
	private Date postDate;
	public Integer getPostNo() {
		return postNo;
	}
	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	@Override
	public String toString() {
		return "BoardVO [postNo=" + postNo + ", userNo=" + userNo + ", title=" + title + ", content=" + content
				+ ", picName=" + picName + ", postDate=" + postDate + "]";
	}
	
	
	

}
