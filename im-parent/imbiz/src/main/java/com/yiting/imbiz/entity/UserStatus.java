package com.yiting.imbiz.entity;



/**
 * Created by hzyitng on 2015/11/12 0012.
 */

public class UserStatus extends BaseEntity {

    private String account;
    private byte onlineStatus;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public byte getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(byte onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                ", id='" + id + '\'' +
                "account='" + account + '\'' +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
