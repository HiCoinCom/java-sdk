package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class AutoCollectRecord implements Serializable {

    private static final long serialVersionUID = 3360597996677097909L;

    /**
     * Consolidation ID
     */
    private Integer id;

    /**
     * wallet id
     */
    @JSONField(name ="sub_wallet_id")
    private Integer subWalletId;

    /**
     * Unique identifier for the coin, used for transfers, e.g.：USDTERC20
     */
    private String symbol;

    /**
     * Consolidation amount
     */
    private String amount;

    /**
     * Fee currency, e.g.：ETH
     */
    @JSONField(name ="fee_symbol")
    private String feeSymbol;

    /**
     * Fee amount, e.g.：0.00123
     */
    private String fee;

    /**
     * Actual consumed fee, e.g.：0.00111
     */
    @JSONField(name ="real_fee")
    private String realFee;

    /**
     * Creation time timestamp
     */
    @JSONField(name ="created_at")
    private Long createdAt;

    /**
     * Modification time timestamp
     */
    @JSONField(name ="updated_at")
    private Long updatedAt;

    /**
     * Sender’s address
     */
    @JSONField(name ="address_from")
    private String addressFrom;

    /**
     * Consolidation address
     */
    @JSONField(name ="address_to")
    private String addressTo;

    /**
     * Transaction hash
     */
    private String txid;

    /**
     * Number of block confirmations, e.g.：10
     */
    private Integer confirmations;

    /**
     * Consolidation status: 1000 Unapproved, 1100 Approved, Pending Signature, 1200 In Progress, 2000 Completed,
     * 2100 Rejected, 2200 Rejected, 2201 System Rejected, 2202 Auto Cancelled, 2300 Transaction Discarded, 2400 Payment Failed
     */
    private Integer status;

    /**
     * Consolidation type: 10. Consolidation Transaction, 11. Consolidation Gas Transaction
     */
    @JSONField(name ="trans_type")
    private Integer transType;

    /**
     * Base currency unique identifier on the main chain, e.g.：ETH
     */
    @JSONField(name ="base_symbol")
    private String baseSymbol;

    /**
     * Contract address for the consolidation currency
     */
    @JSONField(name ="contract_address")
    private String contractAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(Integer subWalletId) {
        this.subWalletId = subWalletId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFeeSymbol() {
        return feeSymbol;
    }

    public void setFeeSymbol(String feeSymbol) {
        this.feeSymbol = feeSymbol;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRealFee() {
        return realFee;
    }

    public void setRealFee(String realFee) {
        this.realFee = realFee;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
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

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }
}
