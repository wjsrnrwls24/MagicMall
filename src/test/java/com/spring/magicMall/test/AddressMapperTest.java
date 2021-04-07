package com.spring.magicMall.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.magicMall.user.model.ExtraAddressVO;
import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.repository.IExtraAddressMapper;
import com.spring.magicMall.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class AddressMapperTest {
	
	@Autowired
	private IUserMapper mapper;
	@Autowired
	private IExtraAddressMapper adMapper;
	
	
	@Test//유저 번호 뽑아오고 주소록 저장 
	public void addadd() {
		int userNo = mapper.findUserNO("자바 테스트");
		System.out.println(userNo);
		ExtraAddressVO add = new ExtraAddressVO();
		add.setUserNo(userNo);
		add.setAddress("자바 주소");
		add.setAddName("기본 주소지");
		adMapper.defaultAdd(add);
		System.out.println("성공");
	}
	
	@Test//배송지 가지고오기 테스트
	public void addresses() {
		List<ExtraAddressVO> addresses =adMapper.addresses(4);
		for(ExtraAddressVO address : addresses) {
			System.out.println("주소: "+address.toString());
		}
		
	}
	@Test//배송지 삭제 테스트
	public void addressDelTest() {
		adMapper.addressDelete(22);
		System.out.println("삭제 성공");
		
	}
	
	@Test//개별 배송지 조회
	public void addressOneTest() {
		ExtraAddressVO address = adMapper.oneAddress(2);
		System.out.println("address:"+address.toString());
	}
	
	@Test//배송지 수정
	public void addressEditTest() {
		ExtraAddressVO add = new ExtraAddressVO();
		add.setAddName("테스트");
		add.setAddNo(2);
		add.setAddress("경기 광주");
		adMapper.addressEdit(add);
		System.out.println("address:"+add.toString());
	}
}