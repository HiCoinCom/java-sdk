package com.github.hicoincom.api.bean.waas;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 5353191359060537483L;

    @JSONField(name ="uid")
    protected Integer uid;

    @JSONField(name ="nickname")
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
