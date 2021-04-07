package com.spring.magicMall.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magicMall.product.model.ReviewVO;
import com.spring.magicMall.product.repository.IReviewMapper;

@Service
public class ReviewService implements IReviewService {

	@Autowired
	private IReviewMapper mapper;
	
	
	@Override//후기 등록
	public void addReview(ReviewVO review) {
		mapper.addReview(review);
		
	}
	
	@Override//모든 리뷰 가져오기
	public List<ReviewVO> reviews(int proNo) {
		
		return mapper.reviews(proNo);
	}
}
