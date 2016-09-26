package com.yiting.imbiz.entity;

import java.io.Serializable;

/**
 * Created by hzyiting on 2016/9/17.
 */
public abstract class BaseEntity implements Serializable {
	protected String id;

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
		if (this == obj) {
			return true;
		} else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		} else if (obj instanceof BaseEntity) {
			BaseEntity entity = (BaseEntity) obj;
			if (this.id != null ? !id.equals(entity.getId()) : entity.id != null) {
				return false;
			}
			return true;
		}
		return false;

	}
}
