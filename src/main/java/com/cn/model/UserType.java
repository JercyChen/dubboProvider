package com.cn.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserType implements Serializable{
    private Integer id;

    private Integer userTypeCode;

    private String userTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(Integer userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}