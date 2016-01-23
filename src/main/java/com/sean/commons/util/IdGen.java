/**  
 * @Title: IdGen.java
 * @Package com.sean.commons.util
 * @Description: ID 公共工具类 生成公共类
 * @author Wang Jianwei
 * @date 2016-1-22
 */
package com.sean.commons.util;

import java.util.UUID;

import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.stereotype.Service;

/**
 * ID 公共工具类
 * ClassName: IdGen
 * @Description: ID 公共工具类 生成公共类
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
@Service
@Lazy
public abstract class IdGen {

	private IdGen(){}
	
	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
