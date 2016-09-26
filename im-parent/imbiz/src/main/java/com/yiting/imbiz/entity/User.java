package com.yiting.imbiz.entity;

/**
 * Created by hzyiting on 2016/9/17.
 */
public class User extends BaseEntity {
	private long uin;
	private String account;
	private String password;
	private String nickName;
	private String avatarUrl;
	private byte gender;
	private byte clientType;
	private String cServerIp;

	private long userDetailId;

	public long getUin() {
		return uin;
	}

	public void setUin(long uin) {
		this.uin = uin;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public byte getClientType() {
		return clientType;
	}

	public void setClientType(byte clientType) {
		this.clientType = clientType;
	}

	public String getcServerIp() {
		return cServerIp;
	}

	public void setcServerIp(String cServerIp) {
		this.cServerIp = cServerIp;
	}

	public long getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(long userDetailId) {
		this.userDetailId = userDetailId;
	}

	@Override
	public String toString() {
		return "User{" +
				"uin=" + uin +
				", id='" + id + '\'' +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", nickName='" + nickName + '\'' +
				", avatarUrl='" + avatarUrl + '\'' +
				", gender=" + gender +
				", clientType=" + clientType +
				", cServerIp='" + cServerIp + '\'' +
				", userDetailId=" + userDetailId +
				'}';
	}
}
