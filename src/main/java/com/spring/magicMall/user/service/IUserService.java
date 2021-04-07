package com.spring.magicMall.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.magicMall.order.model.OrderInfoVO;
import com.spring.magicMall.user.model.UserVO;

public interface IUserService {
	
	//회원 가입 서비스
	public void insert(UserVO user);
	
	//유저 회원 탈퇴
	void dropUser(int userNO);
	
	//유저 정보 확인
	List<UserVO> login();
	
	 //유저 검색(관리자가 사용)
	List<UserVO> findUser(String id);
	
	//아이디 중복 체크 유저수 확인
	int checkId(String user);
	
	//유저 번호 뽑기(주소지 등록에 사용)
	int findUserNO(String id);
	
	//아이디 찾기,비밀번호 찾기
	List<UserVO> findIdAndPass(String email);
	
	//비밀번호 변경
	void changePassword(UserVO user);
	
	//회원 정보 수정
	void editUser(UserVO user);
	
	//회원 적립금 더하기
	void addSavedMoney(UserVO user);
		 
	//회원 적립금 빼기
	void minSavedMoney(UserVO user);
	
	 //마이페이지 에서 적립금 표시 하는 기능(마이페이지 표시기능도 포함)
	 UserVO oneUser(int userNO);

}
