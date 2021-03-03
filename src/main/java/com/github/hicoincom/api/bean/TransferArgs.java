package com.github.hicoincom.api.bean;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 短信邮箱注册参数
 */
public class TransferArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    private String symbol;
    private String request_id;
    private String to;
    private String remark;
    private BigDecimal amount;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
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
