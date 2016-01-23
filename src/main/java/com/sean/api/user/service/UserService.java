/**  
 * @Title: UserService.java
 * @Package com.sean.api.user.service
 * @Description: TODO
 * @author Wang Jianwei
 * @date 2016-1-22
 */
package com.sean.api.user.service;

import com.sean.api.user.model.User;
import com.sean.api.user.model.UserExample;
import com.sean.commons.service.BaseService;



/**
 * 用户服务接口类
 * 
 * ClassName: UserService
 * @Description: TODO
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
public interface UserService extends BaseService<User, UserExample> {
	
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
	User findByUsername(String username);
	
	/**
	 * 修改用户密码
	 * 
	 * @Description: TODO
	 * @param @param newPassword   
	 * @return void  
	 * @throws
	 * @author Wang Jianwei
	 * @date 2016-1-22
	 */
	void changePassword(String newPassword);
	
	
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
	User findCacheByUsername(String username);

}
