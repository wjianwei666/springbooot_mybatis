package com.sean;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sean.api.user.model.User;
import com.sean.api.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class Test {
	
	@Autowired
	private UserService userService;
	
	@org.junit.Test
	public void test(){
		User user = new User();
		user.setUserName("admin");
		user.setUserPwd("1234567");
		user.setNickName("admin");
		System.out.println(userService.save(user));
	}
}

