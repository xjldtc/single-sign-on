package com.newland.framework.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
/**
 * 逻辑删除实体继承基础类（包含主键 是否删除 创建修改人和时间）
 * @author xjldtc
 *
 */
@MappedSuperclass // 类不是一个完整的实体类，他将不会映射到数据库表，但是他的属性都将映射到其子类的数据库字段中。
// Hibernate中的Entity类之间的继承关系，实体继承的三种策略分别是：SINGLE_TABLE(所有继承的实体都保存在同一张数据库表中),
// JOINED(每个实体子类都将保存在一个单独的表中),TABLE_PER_CLASS(有继承关系的所有实体类都将保存在单独的表中)。
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BasePO {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private long id;

	@Column(name = "IsDeleted", columnDefinition = "Bit default '0'")
	protected boolean isDeleted = false;

	@Column(name = "CREATED_BY", nullable = false)
	private String createdBy;

	@Column(name = "CREATED_TIME", nullable = false)
	private Date createdTime;

	@Column(name = "LAST_MODIFIED_BY")
	private String lastModifiedBy;

	@Column(name = "LAST_MODIFIED_TIME")
	private Date lastModifiedTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	@PrePersist
	protected void prePersist() {
		if (this.createdTime == null)
			createdTime = new Date();
		if (this.lastModifiedTime == null)
			lastModifiedTime = new Date();
	}

	@PreUpdate
	protected void preUpdate() {
		this.lastModifiedTime = new Date();
	}

	@PreRemove
	protected void preRemove() {
		this.lastModifiedTime = new Date();
	}

	protected ToStringHelper toStringHelper() {
		return MoreObjects.toStringHelper(this).omitNullValues().add("id", id)
				.add("createdBy", createdBy).add("createdTime", createdTime)
				.add("lastModifiedBy", lastModifiedBy)
				.add("lastModifiedTime", lastModifiedTime);
	}

	public String toString() {
		return toStringHelper().toString();
	}
}
