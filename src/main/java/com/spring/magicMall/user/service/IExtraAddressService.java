package com.spring.magicMall.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magicMall.user.model.ExtraAddressVO;
import com.spring.magicMall.user.repository.IExtraAddressMapper;


public interface IExtraAddressService {
	
	//가입시 기본 주소지 저장
	void defaultAdd(int userNo,String add1,String add2,String add3);
	
	//배송지 조회
	List<ExtraAddressVO> addresses(int userNo);
	
	//개별 배송지 조회
	ExtraAddressVO oneAddress(int addNo);
	
	//새로운 주소지 저장
	void addAddress(ExtraAddressVO Useraddress,String add1,String add2,String add3);
	
	//배송지 삭제
	void addressDelete(int addNo);
	
	//배송지 수정
	void addressEdit(ExtraAddressVO extraAdd,String add1,String add2,String add3);
	
	

}
