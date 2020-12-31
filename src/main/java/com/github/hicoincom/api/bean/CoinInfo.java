package com.github.hicoincom.api.bean;


import java.io.Serializable;

/**
 *  获取币种列表
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
 */
public class CoinInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String symbol;
    private String icon;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
