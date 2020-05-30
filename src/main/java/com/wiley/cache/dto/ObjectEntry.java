package com.wiley.cache.dto;

import java.util.Date;

public class ObjectEntry {
	private Object object;
	private Date lastAccessedDate;
	private Integer accessCount;

	public ObjectEntry(Object object) {

		this.object = object;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Date getLastAccessedDate() {
		return lastAccessedDate;
	}

	public void setLastAccessedDate(Date lastAccessedDate) {
		this.lastAccessedDate = lastAccessedDate;
	}

	public Integer getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(Integer accessCount) {
		this.accessCount = accessCount;
	}

}
