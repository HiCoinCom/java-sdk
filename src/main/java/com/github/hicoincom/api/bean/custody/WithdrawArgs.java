package com.github.hicoincom.api.bean.custody;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseWaasArgs;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *  withdraw args
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_withdraw.html
 */
public class WithdrawArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name ="request_id")
    private String requestId;
    @JSONField(name ="from_uid")
    private Integer fromUid;
    @JSONField(name ="to_address")
    private String toAddress;
    private BigDecimal amount;
    private String symbol;
    @JSONField(name ="check_sum")
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
