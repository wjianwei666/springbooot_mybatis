/**  
 * 基础Service 服务类 接口
 * @Title: BaseService.java
 * @Package com.sean.commons.service
 * @Description: 基础Service 服务类 接口
 * @author Wang Jianwei
 * @date 2016-1-22
 */
package com.sean.commons.service;

import java.io.Serializable;
import java.util.List;

/**
 * 基础Service 服务类 接口
 * 
 * ClassName: BaseService
 * @Description: 基础Service 服务类 接口
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
public interface BaseService <T extends Serializable, E> {
		
	    T add(T entity);

		List<T> add(List<T> enetities);

		T update(T entity);

		List<T> update(List<T> entities);

		T save(T entity);

		List<T> save(List<T> entities);

		T findOne(String id);

		boolean exists(String id);

		long count();

		void delete(String id);

		void delete(T entity);

		void delete(List<T> entities);

		void deleteAll();

		List<T> findAll();
		
		List<T> search(E criteria);
}
