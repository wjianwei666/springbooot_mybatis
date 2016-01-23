/**  
 * @Title: AbstractCriteria.java
 * @Package com.sean.commons.entity
 * @Description: 抽象排序工具类
 * @author Wang Jianwei
 * @date 2016-1-22
 */
package com.sean.commons.entity;

import java.io.Serializable;

/**
 * 抽象排序工具类
 * 
 * ClassName: AbstractCriteria
 * @Description: 抽象排序工具类
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
public abstract class AbstractCriteria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String orderByClause;

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

}
