package com.chainup.waas.api.bean;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 *  归集商户 账户余额
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/account_getCompanyBySymbol.html
 */
public class CompanyAccountResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String symbol;
    private BigDecimal amount;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
