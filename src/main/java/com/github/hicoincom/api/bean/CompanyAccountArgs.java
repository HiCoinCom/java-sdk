package com.github.hicoincom.api.bean;


import java.io.Serializable;

/**
 *  Merchant account balance
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/account_getCompanyBySymbol.html
 */
public class CompanyAccountArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
