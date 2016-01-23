package com.sean.api.user.model;

import java.io.Serializable;

import com.sean.commons.entity.AbstractAuditingEntity;


public class User extends AbstractAuditingEntity implements Serializable {

    private String userName;

    private String userPwd;

    private String nickName;

   

    private static final long serialVersionUID = 1L;

  

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }
}