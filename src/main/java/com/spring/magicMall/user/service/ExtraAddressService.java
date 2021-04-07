package com.spring.magicMall.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magicMall.user.model.ExtraAddressVO;
import com.spring.magicMall.user.repository.IExtraAddressMapper;

@Service
public class ExtraAddressService implements IExtraAddressService {
	
	
	@Autowired
	private IExtraAddressMapper mapper;
	@Autowired
	private ExtraAddressVO extraAdd;
	
	
	@Override//기본 주소지 저장
	public void defaultAdd(int userNo, String add1, String add2, String add3) {
		
		String address = add1+"-"+add2+"-"+add3;//주소 이어 붙이기
		
		extraAdd.setUserNo(userNo);
		extraAdd.setAddress(address);
		extraAdd.setAddName("기본 주소지");
		System.out.println(extraAdd.toString());
		mapper.defaultAdd(extraAdd);
		
	}
	
	@Override//새로운 주소지 저장
	public void addAddress(ExtraAddressVO Useraddress, String add1, String add2, String add3) {
		String address = add1+"-"+add2+"-"+add3;
		
		Useraddress.setAddress(address);
		
		mapper.defaultAdd(Useraddress);
		
	}
	
	@Override//회원 배송지 조회
	public List<ExtraAddressVO> addresses(int userNo) {
		
		return mapper.addresses(userNo);
	}
	
	@Override//개별 배송지 조회
	public ExtraAddressVO oneAddress(int addNo) {
		
		return mapper.oneAddress(addNo);
	}
	
	@Override//배송지 삭제
	public void addressDelete(int addNo) {
		mapper.addressDelete(addNo);
		
	}
	
	@Override//배송지 수정
	public void addressEdit(ExtraAddressVO extraAdd,String add1,String add2,String add3) {
		
		String address = add1+"-"+add2+"-"+add3;//주소 이어 붙이기
		extraAdd.setAddress(address);
		System.out.println("조합된 address:"+address.toString());
		mapper.addressEdit(extraAdd);
		
	}

}
