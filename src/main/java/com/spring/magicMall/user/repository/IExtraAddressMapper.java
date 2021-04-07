package com.spring.magicMall.user.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.magicMall.user.model.ExtraAddressVO;


public interface IExtraAddressMapper {
	
	//가입시 기본 주소지 저장,새로운 주소지 저장
	void defaultAdd(ExtraAddressVO extraAdd);
	
	//배송지 조회
	List<ExtraAddressVO> addresses(int userNo);
	
	//개별 배송지 조회
	ExtraAddressVO oneAddress(int addNo);
	
	//배송지 삭제
	void addressDelete(int addNo);
	
	//배송지 수정
	void addressEdit(ExtraAddressVO extraAdd);
	
	

}
