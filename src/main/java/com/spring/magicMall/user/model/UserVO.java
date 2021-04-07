package com.spring.magicMall.user.model;

import java.util.Date;

public class UserVO {
	private int userNO;
	private String id;
	private String password;
	private String name;
	private String email;
	private String pNumber;
	private String passCheckQuestion;
	private String passCheckAnswer;
	private Date regDate;
	private int savedMoney;
	
	
	public int getUserNO() {
		return userNO;
	}
	
	public void setUserNO(int userNO) {
		this.userNO = userNO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getpNumber() {
		return pNumber;
	}
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	public String getPassCheckQuestion() {
		return passCheckQuestion;
	}
	public void setPassCheckQuestion(String passCheckQuestion) {
		this.passCheckQuestion = passCheckQuestion;
	}
	public String getPassCheckAnswer() {
		return passCheckAnswer;
	}
	public void setPassCheckAnswer(String passCheckAnswer) {
		this.passCheckAnswer = passCheckAnswer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getSavedMoney() {
		return savedMoney;
	}
	public void setSavedMoney(int savedMoney) {
		this.savedMoney = savedMoney;
	}
	
	@Override
	public String toString() {
		return "UserVO [userNO=" + userNO + ", id=" + id + ", password=" + password + ", name=" + name + ", email="
				+ email + ", pNumber=" + pNumber + ", passCheckQuestion=" + passCheckQuestion + ", passCheckAnswer="
				+ passCheckAnswer + ", regDate=" + regDate + ", savedMoney=" + savedMoney + "]";
	}
	
}
