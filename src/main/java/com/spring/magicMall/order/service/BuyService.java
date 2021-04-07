package com.spring.magicMall.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.order.commons.OrderSearchVO;
import com.spring.magicMall.order.model.OrderCombineVO;
import com.spring.magicMall.order.model.OrderDetailVO;
import com.spring.magicMall.order.model.OrderInfoVO;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.order.repository.IBuyMapper;

@Service
public class BuyService implements IBuyService {
	
	@Autowired
	private IBuyMapper mapper;
	
	
	@Override//기본 주소 및 회원 정보 호출
	public OrderCombineVO userInfo(int userNo) {
		
		return mapper.userInfo(userNo) ;
	}
	
	@Override//orderInfo 저장
	public void orderInfoSave(OrderInfoVO orderInfo) {
		
		mapper.orderInfoSave(orderInfo);
	}
	
	@Override//orderList 저장
	public void orderListSave(OrderListVO orderList) {
		mapper.orderListSave(orderList);
		
	}
	
	@Override//주문내역 및 배송 조회
	public List<OrderDetailVO> orderListAndInfo(OrderSearchVO orderSearch) {
		
		return mapper.orderListAndInfo(orderSearch);
	}
	
	@Override//배송상태 변경
	public void shippingStatChange(OrderListVO orderList) {
		mapper.shippingStatChange(orderList);
		
	}
	
	@Override//관리자 현재 주문 내역 조회
	public List<OrderDetailVO> orderListAndInfoAdmin(OrderSearchVO orderSearch) {
		
		return mapper.orderListAndInfoAdmin(orderSearch);
	}
	
	@Override//관리자 현재 주문 목록 수세기
	public int countOrderListAndInfoAdmin(OrderSearchVO orderSearch) {
		
		return mapper.countOrderListAndInfoAdmin(orderSearch);
	}
	
	@Override//주문 상태 변경
	public void ordStatChange(OrderListVO orderList) {
		mapper.ordStatChange(orderList);
		
	}
	
	@Override//주문 상태 체크해서 목록 가져오기
	public List<OrderDetailVO> orderStatCheck(SearchVO Search) {
		
		return mapper.orderStatCheck(Search);
	}
	
	@Override//주문 정보 지우기
	public void orderInfoDel(OrderListVO orderList) {
		mapper.orderInfoDel(orderList);
		
	}

}
