package com.spring.magicMall.adminOrAndUser.commons;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.magicMall.board.commons.PageVO;
import com.spring.magicMall.order.commons.OrderSearchVO;

public class AdminOrderListPageCreator {
	
	//페이지 번호화 한 페이지당 들어갈 게시물 수를 갖고 있는 객체
			private PageVO paging;
			private Integer articleTotalCount;//게시판의 총 게시물
			private Integer beginPage;//시작 페이지 번호
			private Integer endPage;// 끝 페이지 번호
			private boolean prev;// 이전 버튼 활성화 여부
			private boolean next;// 다음 버튼 활성화 여부
			
			//한 화면에 보여질 페이지 수
			private final Integer displayPageNum = 10;
			
			//URI 파라미터를 쉽게 만들어주는 유틸메서드 선언
			public String makeURI(Integer page) {
				UriComponents ucp = UriComponentsBuilder.newInstance()
									.queryParam("page",page)
									.queryParam("countPerPage", paging.getCountPerPage())
									.queryParam("keyword", ((OrderSearchVO)paging).getKeyword())
									.queryParam("condition", ((OrderSearchVO)paging).getCondition())
									.build();
				return ucp.toUriString();
			}
				
			//페이지 알고리즘을 수행할 메서드 선언.
			private void calcDataOfPage() {
			//보정 전 끝 페이지 구하기
			endPage=(int)Math.ceil(paging.getPage()/(double)displayPageNum)*displayPageNum;
				
			//시작 페이지 번호 구하기
			beginPage = (endPage - displayPageNum)+1;
			//현재 시작페이지가 1이라면 이전 버튼 비활성화
			prev = (beginPage == 1) ? false : true;
				
			//마지막 페이지 여부 확인후 다음 버튼 비활성
			next = (endPage*paging.getCountPerPage()>=articleTotalCount)? false : true;
				
			//재보정 여부 판단
			//끝 페이지 재보정
			if(!isNext()) {
				endPage = (int)Math.ceil(articleTotalCount/(double)paging.getCountPerPage());
				}
			
			}
			
			public PageVO getPaging() {
				return paging;
			}

			public void setPaging(PageVO paging) {
				this.paging = paging;
			}

			public Integer getArticleTotalCount() {
				return articleTotalCount;
			}

			public void setArticleTotalCount(Integer articleTotalCount) {
				this.articleTotalCount = articleTotalCount;
				calcDataOfPage();
			}

			public Integer getBeginPage() {
				return beginPage;
			}

			public void setBeginPage(Integer beginPage) {
				this.beginPage = beginPage;
			}

			public Integer getEndPage() {
				return endPage;
			}

			public void setEndPage(Integer endPage) {
				this.endPage = endPage;
			}

			public boolean isPrev() {
				return prev;
			}

			public void setPrev(boolean prev) {
				this.prev = prev;
			}

			public boolean isNext() {
				return next;
			}

			public void setNext(boolean next) {
				this.next = next;
			}

			public Integer getDisplayPageNum() {
				return displayPageNum;
			}

			@Override
			public String toString() {
				return "PageCreator [paging=" + paging + ", articleTotalCount=" + articleTotalCount + ", beginPage=" + beginPage
						+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum
						+ "]";
			}

}
