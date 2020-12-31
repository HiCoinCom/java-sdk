package com.github.hicoincom.api.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  用户提现记录同步
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncWithdrawList.html
 */
public class Withdraw implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name ="request_id")
    private String requestId;
    private String id;
    private String uid;
    private String symbol;
    private BigDecimal amount;
    @JSONField(name ="withdraw_fee_symbol")
    private String withdrawFeeSymbol;
    @JSONField(name ="withdraw_fee")
    private BigDecimal withdrawFee;
    @JSONField(name ="fee_symbol")
    private String feeSymbol;
    @JSONField(name ="real_fee")
    private BigDecimal realFee;
    @JSONField(name ="address_to")
    private String addressTo;
    @JSONField(name ="created_at")
    private Date createdAt;
    @JSONField(name ="updated_at")
    private Date updatedAt;
    private String txid;
    private Integer confirmations;
    private Integer status;

    @JSONField(name ="address_from")
    private String addressFrom;
    @JSONField(name ="saas_status")
    private Integer saasStatus;
    @JSONField(name ="companyStatus")
    private Integer company_status;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

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

    public String getWithdrawFeeSymbol() {
        return withdrawFeeSymbol;
    }

    public void setWithdrawFeeSymbol(String withdrawFeeSymbol) {
        this.withdrawFeeSymbol = withdrawFeeSymbol;
    }

    public BigDecimal getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(BigDecimal withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public String getFeeSymbol() {
        return feeSymbol;
    }

    public void setFeeSymbol(String feeSymbol) {
        this.feeSymbol = feeSymbol;
    }

    public BigDecimal getRealFee() {
        return realFee;
    }

    public void setRealFee(BigDecimal realFee) {
        this.realFee = realFee;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public Integer getSaasStatus() {
        return saasStatus;
    }

    public void setSaasStatus(Integer saasStatus) {
        this.saasStatus = saasStatus;
    }

    public Integer getCompany_status() {
        return company_status;
    }

    public void setCompany_status(Integer company_status) {
        this.company_status = company_status;
    }
}
