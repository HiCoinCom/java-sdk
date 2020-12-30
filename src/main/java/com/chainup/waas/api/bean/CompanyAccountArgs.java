package com.chainup.waas.api.bean;


import java.io.Serializable;

/**
 *  归集商户 账户余额
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
