/**  
 * @Title: AbstractAuditingEntity.java
 * @Package com.sean.commons.entity
 * @Description: 抽象审核管理操作工具类
 * @author Wang Jianwei
 * @date 2016-1-22
 */
package com.sean.commons.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


/**
 * 抽象审核管理操作工具类
 * 
 * ClassName: AbstractAuditingEntity
 * @Description: 抽象审核管理操作工具类
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
public abstract class AbstractAuditingEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@CreatedBy
	@NotNull
	private String createBy;

	@CreatedDate
	@NotNull
	private Date createDate = new Date();

	@LastModifiedBy
	private String lastModifiedBy;

	@LastModifiedDate
	private Date lastModifiedDate = new Date();

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
