package com.github.hicoincom.api.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  Batch query withdrawal and recharge records
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_depositList.html
 */
public class Deposit implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String uid;
    private String symbol;
    private BigDecimal amount;
    @JSONField(name ="address_from")
    private String addressFrom;
    @JSONField(name ="address_to")
    private String addressTo;
    @JSONField(name ="created_at")
    private Date createdAt;
    @JSONField(name ="updated_at")
    private Date updatedAt;
    private String txid;
    private Integer confirmations;
    private Integer status;
    @JSONField(name ="is_mining")
    private Byte mining;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
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

    public Byte getMining() {
        return mining;
    }

    public void setMining(Byte mining) {
        this.mining = mining;
    }
}
