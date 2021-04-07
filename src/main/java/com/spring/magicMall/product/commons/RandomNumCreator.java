package com.spring.magicMall.product.commons;

public class RandomNumCreator {
	

	public int[] randNum(int[] nums) {
		int[] ran = new int[3];
		
		// 번호 생성
	for(int i=0; i<3; i++) {
		ran[i] = (int)(Math.random() * (nums.length-0)) + 0;
		        
		// 중복 번호 제거
		for(int j=0; j<i; j++) {
			if(ran[i] == ran[j]) {
				i--;
				break;
				}
			}
		}


			// 번호 출력
		for(int i=0; i<3; i++) {
			System.out.print(ran[i] + " ");
		}
		return ran;

	}

}
