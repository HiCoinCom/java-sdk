package com.github.hicoincom.api.bean.waas;

import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ChainUp Custody
 * transaction parameters
 */
public class TransferArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = -2445926090500894466L;

    private String symbol;

    private String requestId;

    private String to;

    private String remark;

    private BigDecimal amount;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
