package com.github.hicoincom.api.bean.waas;


import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ChainUp Custody
 * withdraw args
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_withdraw.html
 */
public class WithdrawArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 3598957308406371406L;

    private String requestId;

    private Integer fromUid;

    private String toAddress;

    private BigDecimal amount;

    private String symbol;

    private String checkSum;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }
}
