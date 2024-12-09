package com.github.hicoincom.api.bean.waas;


import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * query user's coin deposit address
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/account_getDepositAddress.html
 */
public class UserAddressArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = -8980230513134984102L;

    private Integer uid;

    private String symbol;

    private String address;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
