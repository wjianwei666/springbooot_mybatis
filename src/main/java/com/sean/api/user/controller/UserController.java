/**  
 * @Title: UserController.java
 * @Package com.sean.api.user.controller
 * @Description: TODO
 * @author Wang Jianwei
 * @date 2016-1-22
 */
package com.sean.api.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sean.api.user.model.User;
import com.sean.api.user.service.UserService;


/**
 * 用户  Controller
 * 
 * ClassName: UserController
 * @Description: TODO
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

     /** 加载所有用户
      * @Description: 加载所有用户
      * @param @return   
      * @return ResponseEntity<List<User>>  
      * @throws
      * @author Wang Jianwei
      * @date 2016-1-22
      */
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAll() {
		log.debug("REST request to get all Users");
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

    /**
     * 根据用户名查询用户信息对象
     * 
	 * @Description: 根据用户名查询用户信息对象
	 * @param @param username
	 * @param @param response
	 * @param @return   
	 * @return User  
	 * @throws
	 * @author Wang Jianwei
	 * @date 2016-1-22
	 */
	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable String username,
			HttpServletResponse response) {
		log.debug("REST request to get User : {}", username);
		User user = userService.findByUsername(username);
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return user;
	}
	
	
	 /**
     * 根据用户名查询用户信息对象
     * 
	 * @Description: 根据用户名查询用户信息对象
	 * @param @param username
	 * @param @param response
	 * @param @return   
	 * @return User  
	 * @throws
	 * @author Wang Jianwei
	 * @date 2016-1-22
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String putCache(@PathVariable String username,
			HttpServletResponse response) {
		log.debug("REST request to get User : {}", username);
		User user = userService.findCacheByUsername(username);
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
	        return "ok";  
	}

    /**
     * 添加用户信息
     * 
	 * @Description: 添加用户信息
	 * @param @param userDto
	 * @param @param request
	 * @param @return   
	 * @return ResponseEntity<?>  
	 * @throws
	 * @author Wang Jianwei
	 * @date 2016-1-22
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> add(@Valid @RequestBody User userDto,
			HttpServletRequest request) {
		User user = userService.findByUsername(userDto.getUserName());
		if (user != null) {
			return ResponseEntity.badRequest()
					.contentType(MediaType.TEXT_PLAIN)
					.body("username already in use");
		}
		userService.add(userDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	
    /**
     * 修改密码
     * 
	 * @Description: TODO
	 * @param @param password
	 * @param @return   
	 * @return ResponseEntity<String>  
	 * @throws
	 * @author Wang Jianwei
	 * @date 2016-1-22
	 */
	@RequestMapping(value = "/users/change_password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> changePassword(@RequestBody String password) {
		if (password.isEmpty() || password.length() < 5
				|| password.length() > 50) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		userService.changePassword(password);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}