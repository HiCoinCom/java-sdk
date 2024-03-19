package com.github.hicoincom.api.bean.waas;


import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 5353191359060537483L;

    protected Integer uid;

    protected String nickname;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
