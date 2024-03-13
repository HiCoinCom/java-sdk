package com.github.hicoincom.api.bean.custody;


import com.github.hicoincom.api.bean.BaseWaasArgs;

import java.io.Serializable;

/**
 *  user account args
 */
public class UserAccountArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uid;
    private String symbol;

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
}
