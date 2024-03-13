package com.github.hicoincom.api.bean.custody;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name ="uid")
    private Integer uid;
    @JSONField(name ="address")
    private String address;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
