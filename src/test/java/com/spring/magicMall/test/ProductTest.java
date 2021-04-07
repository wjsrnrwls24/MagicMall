package com.spring.magicMall.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.magicMall.adminProduct.commons.SearchVO;
import com.spring.magicMall.adminProduct.model.ProductVO;
import com.spring.magicMall.adminProduct.repository.IProductMapper;
import com.spring.magicMall.order.model.OrderListVO;
import com.spring.magicMall.product.commons.ProductSearchVO;
import com.spring.magicMall.product.commons.RandomNumCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class ProductTest {
	
	@Autowired
	IProductMapper proMapper;
	
	@Test//제품 등록
	public void insertPro() {
		ProductVO product = new ProductVO();
		
		product.setProName("junit");
		product.setCategory("캐인");
		product.setProAmount(2);
		product.setProDetail("과연 좋은 물건일가?");
		product.setProMaker("min six");
		product.setProPhoto("minsix photo");
		product.setProPrice(2000);
		product.setProSavedMoney(20);
		product.setYoutubeAdd("http://");
		
		proMapper.insertPro(product);
		
	}
	
	@Test//전체 제품
	public void allPro() {
		SearchVO search = new SearchVO();
		System.out.println("search:"+search.toString());
		search.setCondition("lack");
		//search.setMostSale("yes");
		List<ProductVO> products =proMapper.selectAllPro(search);
		for(ProductVO product: products) {
			int count=1;
			System.out.println("product"+count+":"+product.toString());
			count++;
		}
	}
	@Test//제품 명으로 검색
	public void namePro() {
		SearchVO search = new SearchVO();
		search.setCondition("proName");
		search.setKeyword("카드");
		List<ProductVO> products =proMapper.selectProsAdmin(search);
		for(ProductVO product: products) {
			int count=1;
			System.out.println("product"+count+":"+product.toString());
			count++;
		}
	}
	@Test//많이 팔린 제품 순으로
	public void salePro() {
		SearchVO search = new SearchVO();
		search.setCondition("proName");
		search.setKeyword("카드");
		search.setMostSale("mostSale");
		List<ProductVO> products =proMapper.selectMostSaleReal(search);
		for(ProductVO product: products) {
			int count=1;
			System.out.println("product"+count+":"+product.toString());
			count++;
		}
	}
	@Test//개별 제품 테스트
	public void proDetail() {
		
		ProductVO product =proMapper.selectOnePro(10);
		System.out.println("product:"+product.toString());
	}
	
	@Test//제품 삭제 테스트
	public void proDel() {
		proMapper.deletePro(2);
	}
	
	@Test//제품 업데이트 테스트
	public void proEdit() {
		ProductVO product = new ProductVO();
		product.setProNo(9);
		product.setProName("junit");
		product.setCategory("캐인");
		product.setProAmount(2);
		product.setProDetail("과연 좋은 물건일가?");
		product.setProMaker("min six");
		product.setProPhoto("minsix photo");
		product.setProPrice(2000);
		product.setProSavedMoney(20);
		product.setYoutubeAdd("https://youtu.be/9HLq1Z3R9ho");
		proMapper.editPro(product);
	}
	
	@Test//카테고리별 테스트
	public void proCate() {
		ProductSearchVO search = new ProductSearchVO();
		search.setCategory("카드");
		List<ProductVO> products = proMapper.userProList(search);
		for(ProductVO product: products) {
		
			System.out.println("product"+":"+product.toString());
			
		}
	}
	
	@Test//카테고리별 테스트+가격
	public void proCateAndPrice() {
		ProductSearchVO search = new ProductSearchVO();
		search.setCategory("카드");
		search.setPriceSet("lowestPrice");
		List<ProductVO> products = proMapper.userProList(search);
		for(ProductVO product: products) {
			System.out.println("product"+":"+product.getProPrice());

		}
	}
	
	@Test//기본 검색 기능 사용
	public void profind() {
	ProductSearchVO search = new ProductSearchVO();
	search.setCondition("proMaker");
	search.setKeyword("min six");
	List<ProductVO> products = proMapper.userProList(search);
	for(ProductVO product: products) {
		System.out.println("product"+":"+product.toString());

		}
	}
	
	@Test//유저 파일 찾기
	public void userProList() {
	ProductSearchVO search = new ProductSearchVO();
	List<ProductVO> products = proMapper.userProList(search);
	for(ProductVO product: products) {
		System.out.println("product"+":"+product.toString());

		}
	}
	
	@Test//유저 제품 상세 조회 기능
	public void detailFindTest() {
		ProductSearchVO search = new ProductSearchVO();
		search.setCategory("카드");
		search.setCondition("proName");
		search.setKeyword("카드");
		search.setLowPrice(0);
		search.setHighPrice(20000);
		search.setPriceSet("lowestPrice");
		List<ProductVO> products = proMapper.userProList(search);
		for(ProductVO product: products) {
			System.out.println("product"+":"+product.toString());

			}
		}
	@Test//유저 제고 요청 기능
	public void amountRe() {
		proMapper.proAmountRe(8);
	}
	
	@Test//관리자 재고 처리 기능
	public void AmountFin() {
		proMapper.proAmountReFin(16);
	}
	
	@Test//재고 변경 및 구매 수량 변경
	public void amountBuyNum() {
		OrderListVO orderList = new OrderListVO();
		orderList.setProNo(11);
		orderList.setOrderStat(0);
		orderList.setOrAmount(3);
		proMapper.proAmountAndBuyNum(orderList);
	}
	
	@Test//매출 확인 프로그램
	public void saleTest() {
		SearchVO search = new SearchVO();
		List<ProductVO> products = proMapper.selectMostSaleReal(search);
		for(ProductVO product: products) {
			System.out.println("product"+":"+product.toString());

			}
		
	}
	
	@Test//제품 번호 가져오기 테스트
	public void NumRan() {
		int[] proNos = proMapper.proNoGet();
		for(int i= 0;i<proNos.length;i++) {
			System.out.println("pros"+i+":"+proNos[i]);
		}
		System.out.println();
	RandomNumCreator numCre = new RandomNumCreator();
		int[] nums = numCre.randNum(proNos);
		System.out.println(Arrays.toString(nums));
		
		List<ProductVO> products = new ArrayList<ProductVO>();
		for(int j = 0;j<3;j++) {
			products.add(proMapper.selectOnePro(proNos[nums[j]]));
		}
		System.out.println("완료");
		for(ProductVO product : products) {
			System.out.println("product:"+product.toString());
			System.out.println();
		}
	}
}
