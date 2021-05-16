package com.instantmessagetool.qqserver.common;

import java.io.Serializable;

/**
 * @author pi
 * @date 2021/05/16 18:01:30
 * //表示一个用户/客户信息
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String passWord;

    public User(String userId, String passWord) {
        this.userId = userId;
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
