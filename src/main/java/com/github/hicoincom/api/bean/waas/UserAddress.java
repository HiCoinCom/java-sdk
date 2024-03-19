package com.github.hicoincom.api.bean.waas;


import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class UserAddress implements Serializable {

    private static final long serialVersionUID = -8412092540025155623L;

    private Integer uid;

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
