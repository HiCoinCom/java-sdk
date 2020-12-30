package com.chainup.waas.api.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JSONField(name ="uid")
    protected Integer uid;

    @JSONField(name ="nickname")
    protected Integer nickname;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNickname() {
        return nickname;
    }

    public void setNickname(Integer nickname) {
        this.nickname = nickname;
    }
}
