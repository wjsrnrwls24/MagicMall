package com.spring.magicMall.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.order.commons.OrderNumberMaker;
import com.spring.magicMall.order.commons.OrderSearchVO;
import com.spring.magicMall.order.model.OrderDetailVO;
import com.spring.magicMall.order.model.OrderInfoVO;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.order.repository.IBuyMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class OrderTest {
	
	@Autowired
	private IBuyMapper buyMap;
	
	//orderInfo 저장 테스트
	@Test
	public void orderNumTest() {
		OrderNumberMaker numMaker= new OrderNumberMaker();
		Integer order = Integer.parseInt(numMaker.numberMaker(3));
		OrderInfoVO orderInfo = new OrderInfoVO();
		orderInfo.setOrderNo(order);
		orderInfo.setOrAddress("dd");
		orderInfo.setOrEmail("dddd@dddd");
		orderInfo.setOrPhone("00125");
		orderInfo.setReceiver("누가");
		orderInfo.setOrderer("나는");
		System.out.println(orderInfo.toString());
		buyMap.orderInfoSave(orderInfo);
	}
	
	//orderList 저장 테스트
	@Test
	public void orderListTest() {
		OrderListVO orderList =new OrderListVO();
		orderList.setOrderNo(21753);
		orderList.setOrAmount(2);
		orderList.setShippingStat("배송중");
		orderList.setProNo(3);
		orderList.setOrMessage("뭔데 이거");
		buyMap.orderListSave(orderList);
		
	}
	
	@Test//주문 내역들 가져오기
	public void orderDetailsTest() {
		OrderSearchVO orderSearch = new OrderSearchVO();
		//orderSearch.setOrderNo(21261316);
		//orderSearch.setUserNo(7);
		orderSearch.setCondition("buy");
		//orderSearch.setKeyword("sss");
		//orderSearch.setDateLength("1week");
		System.out.println("orderSearch:"+orderSearch.toString());
		List<OrderDetailVO> orderDetails =buyMap.orderListAndInfo(orderSearch);
		for(OrderDetailVO orderDetail:orderDetails) {
			System.out.println("orderList:"+orderDetail.getOrderList().toString());
			System.out.println();
			System.out.println("orderInfo:"+orderDetail.getOrderInfo().toString());
			System.out.println();
			System.out.println("product:"+orderDetail.getProduct().toString());
		}
	}
	
	@Test//관리자 주문 내역들 가져오기
	public void orderDetailsAdminTest() {
		OrderSearchVO orderSearch = new OrderSearchVO();
		//orderSearch.setOrderNo(21261316);
		//orderSearch.setUserNo(7);
		//orderSearch.setCondition("orderer");
		//orderSearch.setKeyword("aa");
		//orderSearch.setDateLength("1week");
		System.out.println("orderSearch:"+orderSearch.toString());
		List<OrderDetailVO> orderDetails =buyMap.orderListAndInfoAdmin(orderSearch);
		for(OrderDetailVO orderDetail:orderDetails) {
			System.out.println("orderList:"+orderDetail.getOrderList().toString());
			System.out.println();
			System.out.println("orderInfo:"+orderDetail.getOrderInfo().toString());
			System.out.println();
			System.out.println("product:"+orderDetail.getProduct().toString());
		}
	}
	
	@Test//관리자 현재 주문내역 수 세기
	public void countAdminOrderDetailsTest() {
		OrderSearchVO orderSearch = new OrderSearchVO();
		orderSearch.setCondition("orderer");
		orderSearch.setKeyword("aa");
		System.out.println("orderSearch:"+orderSearch.toString());
		int count = buyMap.countOrderListAndInfoAdmin(orderSearch);
		System.out.println("count:"+count);
		System.out.println();
	}
	
	@Test//orderStat change Test
	public void orderStatCh() {
		OrderListVO orderList = new OrderListVO();
		orderList.setProNo(3);
		orderList.setOrderNo(21753);
		orderList.setOrderStat(4);
		buyMap.ordStatChange(orderList);
		
	}
	
	@Test//주문 상태에 따른 값 가져오기
	public void orderStatVal() {
		SearchVO search = new SearchVO();
		search.setCondition("buy");
		List<OrderDetailVO> orderDetails = buyMap.orderStatCheck(search);
		for(OrderDetailVO orderDetail:orderDetails) {
			System.out.println("orderList:"+orderDetail.getOrderList().toString());
			System.out.println();
			System.out.println("orderInfo:"+orderDetail.getOrderInfo().toString());
			System.out.println();
			System.out.println("product:"+orderDetail.getProduct().toString());
		}
	
	}
	
	@Test//배송 상태 변경
	public void shippingTest() {
		OrderListVO orderList = new OrderListVO();
		orderList.setOrderNo(2143015);
		orderList.setProNo(15);
		buyMap.shippingStatChange(orderList);
	}
	
}
