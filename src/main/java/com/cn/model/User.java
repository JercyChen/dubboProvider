package com.cn.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class User implements Serializable{
    private Integer id;

    private Integer userId;

    private String userName;

    private String userPhone;

    private String userPassword;

    private Date lastLoginTime;

    private Integer userStatus;

    private Integer userTypeCode;
    
    private List<Mobile> mobiles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(Integer userTypeCode) {
        this.userTypeCode = userTypeCode;
    }
    
    
	public List<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(List<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", userPhone=" + userPhone + ", userPassword="
				+ userPassword + ", lastLoginTime=" + lastLoginTime
				+ ", userStatus=" + userStatus + ", userTypeCode="
				+ userTypeCode + "]";
	}
    
}