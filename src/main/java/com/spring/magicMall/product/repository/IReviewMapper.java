package com.spring.magicMall.product.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.magicMall.product.model.ReviewVO;

@Repository
public interface IReviewMapper {
	
	//후기 등록
	void addReview(ReviewVO review);
	
	//모든 리뷰 가져오기
	List<ReviewVO>reviews(int proNo);

}
