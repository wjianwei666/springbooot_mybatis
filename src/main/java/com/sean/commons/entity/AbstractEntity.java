/**  
 * @Title: AbstractEntity.java
 * @Package com.sean.commons.entity
 * @Description: 抽象公共实体类
 * @author Wang Jianwei
 * @date 2016-1-22
 */
package com.sean.commons.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.hateoas.Identifiable;


/**
 * 
 * 抽象公共实体类
 * 
 * ClassName: AbstractEntity
 * @Description: 抽象公共实体类
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
public abstract class AbstractEntity implements Identifiable<String>, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
