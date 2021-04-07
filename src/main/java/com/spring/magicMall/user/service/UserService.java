package com.spring.magicMall.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magicMall.order.model.OrderInfoVO;
import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.repository.IUserMapper;
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Override//유저 가입
	public void insert(UserVO user) {
		mapper.register(user);

	}
	@Override//유저 탈퇴
	public void dropUser(int userNO) {
		mapper.dropUser(userNO);
		
	}
	
	@Override//유저 수정
	public void editUser(UserVO user) {
		mapper.editUser(user);
		
	}
	
	@Override//유저 정보 확인
	public List<UserVO> login() {
		List<UserVO> users =mapper.login();
		return users;
	}
	
	@Override//유저 검색
	public List<UserVO> findUser(String id) {
		
		return mapper.findUser(id);
	}
	
	@Override//아이디 체크
	public int checkId(String user) {
		
		return mapper.checkId(user);
	}
	
	@Override//유저 번호 반환
	public int findUserNO(String id) {
		
		return mapper.findUserNO(id);
	}
	
	@Override//유저 아이디,비번 찾기
	public List<UserVO> findIdAndPass(String email) {
		
		return mapper.findIdAndPass(email);
	}
	@Override//유저 패스 변경
	public void changePassword(UserVO user) {
		
		mapper.changePassword(user);
	}
	
	@Override//회원 적립금 더하기
	public void addSavedMoney(UserVO user) {
		mapper.addSavedMoney(user);
		
	}
	
	@Override//회원 적립금 빼기
	public void minSavedMoney(UserVO user) {
		mapper.minSavedMoney(user);
		
	}
	
	@Override//유저 한명 뽑기
	public UserVO oneUser(int userNO) {
		
		return mapper.oneUser(userNO);
	}
}
