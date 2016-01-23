/**  
 * @Title: UserServiceImpl.java
 * @Package com.sean.api.user.service.impl
 * @Description: TODO
 * @author Wang Jianwei
 * @date 2016-1-22
 */
package com.sean.api.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.sean.api.user.controller.UserController;
import com.sean.api.user.mapper.UserMapper;
import com.sean.api.user.model.User;
import com.sean.api.user.model.UserExample;
import com.sean.api.user.service.UserService;
import com.sean.commons.mapper.BaseMapper;
import com.sean.commons.service.BaseServiceImpl;


/**
 * ClassName: UserServiceImpl
 * @Description: TODO
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, UserExample>implements UserService {

	private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByUsername(String username) {
		Assert.notNull(username);
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNameEqualTo(username);
		List<User> userList = userMapper.selectByExample(userExample);
		return userList.get(0);
	}
	
	  /**
     * 根据用户名查询用户对象
     * 
	 * @Description: TODO
	 * @param @param username
	 * @param @return   
	 * @return User  
	 * @throws
	 * @author Wang Jianwei
	 * @date 2016-1-22
	 */
   @Cacheable(value = "usercache",keyGenerator = "cacheKeyGenerator")  
   public	User findCacheByUsername(String username){
	   System.out.println("无缓存的时候调用这里");
		return findByUsername(username);
	}


	public void changePassword(String newPassword) {
		Assert.notNull(newPassword);
		
	}
	
	protected BaseMapper<User, UserExample, String> getMapper() {
		return userMapper;
	}

}

