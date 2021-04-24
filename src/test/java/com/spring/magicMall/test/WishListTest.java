package com.spring.magicMall.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class WishListTest {
	
	@Test
	public void wishListdelTest() {
		String text = "5-21-7-8";
		text=text.replace("-21", "");
		System.out.println("변경된 text:"+text);
	}

}
