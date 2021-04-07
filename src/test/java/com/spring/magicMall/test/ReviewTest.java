package com.spring.magicMall.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.magicMall.product.model.ReviewVO;
import com.spring.magicMall.product.repository.IReviewMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class ReviewTest {
	
	@Autowired
	private IReviewMapper reviewMapper;
	
	
	@Test//리뷰 등록 테스트
	public void reviewTest() {
		ReviewVO review =new ReviewVO();
		
		review.setProNo(3);
		review.setReviewWriter("민식");
		review.setReviewContent("아무것도 모른다");
		review.setReviewCompen(5);
		System.out.println("완료");
		
		reviewMapper.addReview(review);
		
	}
	
	@Test//리뷰 불러오기
	public void reviewSel() {
		List<ReviewVO> reviews = reviewMapper.reviews(3);
		int num=0;
		for(ReviewVO review: reviews) {
			System.out.println("review"+num+":"+review.toString());
			System.out.println();
			System.out.println();
			num++;
			
		}
	}

}
