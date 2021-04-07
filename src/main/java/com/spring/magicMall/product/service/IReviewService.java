package com.spring.magicMall.product.service;

import java.util.List;

import com.spring.magicMall.product.model.ReviewVO;

public interface IReviewService {
	
	//후기 등록
	void addReview(ReviewVO review);
	
	//모든 리뷰 가져오기
	List<ReviewVO>reviews(int proNo);

}
