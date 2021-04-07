package com.spring.magicMall.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.basket.model.BasketVO;
import com.spring.magicMall.basket.model.ProBasVO;
import com.spring.magicMall.basket.repository.IBasketMapper;
import com.spring.magicMall.order.model.OrderCombineVO;
import com.spring.magicMall.order.repository.IBuyMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class BasketTest {
	
	@Autowired
	private IBasketMapper basketMap;
	@Autowired
	private IBuyMapper orMap;
	
	
	
	
	@Test//장바구니 물품 조회
	public void basketPro() {
		List<ProBasVO> basketPros = basketMap.allBasketPro(4);
		for(ProBasVO basketPro : basketPros) {
			ProductVO product = basketPro.getProduct();
			BasketVO basket = basketPro.getBasket();
			System.out.println("product:"+product.toString());
			System.out.println();
			System.out.println("basket:"+basket.toString());
		}
		
		
	}
	
	@Test//장바구니 물품 넣기
	public void basketIn() {
		BasketVO bas = new BasketVO();
		bas.setProNo(10);
		bas.setUserNo(7);
		bas.setShopOrAmount(7);
		basketMap.insertBasket(bas);
	}
	
	@Test//장바구니 수량 조정
	public void amountChange() {
		BasketVO bas = new BasketVO();
		bas.setProNo(10);
		bas.setUserNo(7);
		bas.setShopOrAmount(20);
		basketMap.changetAmount(bas);
	}
	
	@Test//장바구니 물건 삭제
	public void delTest() {
		BasketVO bas = new BasketVO();
		bas.setUserNo(4);
		bas.setShopOrAmount(20);
		basketMap.deleteBasket(bas);
		System.out.println("완료");
	}
	
	@Test//장바구니 물품 구매
	public void buytest(){
		OrderCombineVO orderCom = orMap.userInfo(19);
		System.out.println("user:"+orderCom.getUsers().toString());
		System.out.println("add:"+orderCom.getExtraAdds().toString());
	}
	
	

}
