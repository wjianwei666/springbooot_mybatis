package com.sean.commons.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.sean.commons.entity.AbstractCriteria;
import com.sean.commons.entity.AbstractEntity;
import com.sean.commons.mapper.BaseMapper;
import com.sean.commons.util.IdGen;

/**
 *  公共服务方法接口实现类
 *  
 * ClassName: BaseServiceImpl
 * @Description: 公共服务方法接口实现类
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
@Transactional
public abstract class BaseServiceImpl<T extends AbstractEntity, E extends AbstractCriteria> implements BaseService<T, E> {

	protected abstract BaseMapper<T, E, String> getMapper();

	protected Class<T> entityClazz;

	protected Class<E> criteriaClazz;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClazz = (Class<T>) params[0];
		criteriaClazz = (Class<E>) params[1];
	}

	public T add(T entity) {
		Assert.notNull(entity);
		String id = entity.getId() == null ? IdGen.uuid() : entity.getId()
				.trim();
		entity.setId(id);
		getMapper().insertSelective(entity);
		return entity;
	}

	public List<T> add(List<T> entities) {
		Assert.notEmpty(entities);
		List<T> list = new ArrayList<T>();
		for (T t : entities) {
			list.add(add(t));
		}
		return list;
	}

	public T update(T entity) {
		Assert.notNull(entity);
		T existing = getMapper().selectByPrimaryKey(entity.getId());
		BeanUtils.copyProperties(entity, existing);
		getMapper().updateByPrimaryKeySelective(existing);
		return findOne(entity.getId());
	}

	public List<T> update(List<T> entities) {
		Assert.notEmpty(entities);
		List<T> list = new ArrayList<T>();
		for (T t : entities) {
			list.add(update(t));
		}
		return list;
	}

	public T save(T entity) {
		Assert.notNull(entity);
		if (entity.getId() == null) {
			add(entity);
		} else {
			update(entity);
		}
		return findOne(entity.getId());
	}

	
	public List<T> save(List<T> entities) {
		Assert.notEmpty(entities);
		List<T> list = new ArrayList<T>();
		for (T t : entities) {
			list.add(save(t));
		}
		return list;
	}

	
	@Transactional(readOnly = true)
	public T findOne(String id) {
		Assert.notNull(id);
		return getMapper().selectByPrimaryKey(id);
	}

	
	public boolean exists(String id) {
		Assert.notNull(id);
		return findOne(id) != null;
	}

	
	public long count() {
		return getMapper().countByExample(null);
	}

	
	public void delete(String id) {
		Assert.notNull(id);
		getMapper().deleteByPrimaryKey(id);
	}

	
	public void delete(T entity) {
		Assert.notNull(entity);
		getMapper().deleteByPrimaryKey(entity.getId());
	}

	
	public void delete(List<T> entities) {
		Assert.notEmpty(entities);
		for (T t : entities) {
			delete(t);
		}
	}

	
	public void deleteAll() {
		delete(findAll());
	}

	
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return getMapper().selectByExample(null);
	}

	
	@Transactional(readOnly =true)
	public List<T> search(E criteria){
		Assert.notNull(criteria);
		return getMapper().selectByExample(criteria);
	}
}
