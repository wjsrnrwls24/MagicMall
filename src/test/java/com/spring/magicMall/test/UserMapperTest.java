package com.spring.magicMall.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.magicMall.user.model.UserVO;
import com.spring.magicMall.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class UserMapperTest {
	
	@Autowired
	private IUserMapper mapper;
	
	
	@Test//회원 가입
	public void registerUser() {
		UserVO user= new UserVO();
		user.setId("자바 테스트2");
		user.setPassword("1111");
		user.setName("나는 몰라");
		user.setpNumber("11236");
		user.setEmail("wjsrnrwls24@naver.com");
		user.setPassCheckQuestion("민식이는?");
		user.setPassCheckAnswer("말랭이");
		
		System.out.println(user.toString());
		mapper.register(user);
		System.out.println("저장 완료");
	}
	
	@Test//유저들 가져오기 테스트
	public void loginUser() {
		List<UserVO> users =mapper.login();
		for(UserVO user:users) {
			System.out.println(user.toString());
		}
	}
	
	@Test//아이디 찾기
	public void findID() {
		List<UserVO> users = mapper.findIdAndPass("wjsrnrwls24@naver.com");
		
		for(UserVO user : users) {
			System.out.println(user.toString());
		}
		
	}
	
	@Test//비밀번호 변경
	public void changePassTest() {
		UserVO user = new UserVO();
		user.setPassword("7878");
		user.setUserNO(3);
		mapper.changePassword(user);
		System.out.println("성공");
	}
	
	@Test//회원 정보 변경
	public void editUserTest() {
		UserVO user = new UserVO();
		user.setEmail("변경 테스트");
		user.setpNumber("123465");
		user.setPassword("변경 완료");
		user.setUserNO(3);
		mapper.editUser(user);
		System.out.println("변경완료");
	}
	
	@Test//유저 번호 뽑아오기
	public void userNotest() {
		int userNo = mapper.findUserNO("자바 테스트");
		System.out.println(userNo);
	}
	
	@Test//아이디 체크
	public void idCheck() {
		String id="테스트맨2";
		int check = mapper.checkId(id);
		System.out.println(check);
	}
	
	@Test
	public void passwordCondi() {
		UserVO user = new UserVO();
		user.setPassword("123wdswefds");
		System.out.println(user.getPassword());
		boolean flag= user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$");
		System.out.println(flag);
	}
	
	@Test//유저 한명 가져오기(메인페이지용)
	public void userOneTest() {
		UserVO user= new UserVO();
		user=mapper.oneUser(7);
		System.out.println("user:"+user.toString());
	}
	
	@Test//유저 탈퇴
	public void userDrop() {
		mapper.dropUser(6);
	}
	@Test//유저 검색
	public void userFind() {
		List<UserVO> user = mapper.findUser("wjsrnrwls95");
		System.out.println("user:"+user.toString());
	}
}
