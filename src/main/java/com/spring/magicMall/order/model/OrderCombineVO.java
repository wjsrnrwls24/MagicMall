package com.spring.magicMall.order.model;

import org.springframework.stereotype.Component;

import com.spring.magicMall.user.model.ExtraAddressVO;
import com.spring.magicMall.user.model.UserVO;

@Component
public class OrderCombineVO {
	private UserVO users;
	private ExtraAddressVO extraAdds;
		
	public UserVO getUsers() {
		return users;
	}
	public void setUsers(UserVO users) {
		this.users = users;
	}
	public ExtraAddressVO getExtraAdds() {
		return extraAdds;
	}
	public void setExtraAdds(ExtraAddressVO extraAdds) {
		this.extraAdds = extraAdds;
	}
	

}
