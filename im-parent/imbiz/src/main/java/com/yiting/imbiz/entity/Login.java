package com.yiting.imbiz.entity;

/**
 * Created by hzyiting on 2016/9/17.
 */
public class Login extends BaseEntity {
	private long uin;
	private String authToken;
	private long activeTime;

	public long getUin() {
		return uin;
	}

	public void setUin(long uin) {
		this.uin = uin;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public long getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(long activeTime) {
		this.activeTime = activeTime;
	}

	@Override
	public String toString() {
		return "Login{" +
				"uin=" + uin +
				", id='" + id + '\'' +
				", authToken='" + authToken + '\'' +
				", activeTime=" + activeTime +
				'}';
	}
}
