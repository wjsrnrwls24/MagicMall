package com.spring.magicMall.order.service;

import java.util.List;

import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.order.commons.OrderSearchVO;
import com.spring.magicMall.order.model.OrderCombineVO;
import com.spring.magicMall.order.model.OrderDetailVO;
import com.spring.magicMall.order.model.OrderInfoVO;
import com.spring.magicMall.order.model.OrderListVO;

public interface IBuyService {
	
	//기본 주소 및 회원 정보 호출
	OrderCombineVO userInfo(int userNo);
	
	//orderInfo 저장
	void orderInfoSave(OrderInfoVO orderInfo);
	
	//orderList 저장
	void orderListSave(OrderListVO orderList);

	//주문내역 및 배송조회 하기
	List<OrderDetailVO> orderListAndInfo(OrderSearchVO orderSearch);
	
	//관리자 주문 내역 조회
	List<OrderDetailVO> orderListAndInfoAdmin(OrderSearchVO orderSearch);
	
	//관리자 주문 목록 수 세기
	int countOrderListAndInfoAdmin(OrderSearchVO orderSearch);
	
	//주문상태 변경
	void ordStatChange(OrderListVO orderList);
	
	//배송상태 변경
	void shippingStatChange(OrderListVO orderList);
	
	//주문 상태 체크해서 목록 가져오기
	List<OrderDetailVO> orderStatCheck(SearchVO Search);
	
	//주문 목록 지우기
	void orderInfoDel(OrderListVO orderList);

}
