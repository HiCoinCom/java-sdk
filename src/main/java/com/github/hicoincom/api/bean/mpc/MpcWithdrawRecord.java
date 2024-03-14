package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class MpcWithdrawRecord implements Serializable {

    private static final long serialVersionUID = -6971282259528258002L;

    /**
     * withdraw id
     */
    private Integer id;

    /**
     * The unique identifier for transferring coins
     */
    private String requestId;

    /**
     * wallet id
     */
    private Integer subWalletId;

    /**
     * Unique identifier for the coin, used for transfers, e.g.：USDTERC20
     */
    private String symbol;

    /**
     * transfer coin’s contract address
     */
    private String contractAddress;

    /**
     * The unique identifier of the main chain of the coin to be transferred, e.g.：ETH
     */
    private String baseSymbol;

    /**
     * from account address
     */
    private String addressFrom;

    /**
     * to account address
     */
    private String addressTo;

    /**
     * to account address memo
     */
    private String memo;

    /**
     * transfer amount
     */
    private String amount;

    /**
     * Transaction hash
     */
    private String txid;

    /**
     * gas fee coins, e.g.：ETH
     */
    private String feeSymbol;

    /**
     * gas fee, e.g.：0.00123
     */
    private String fee;

    /**
     * The actual gas fee consumed, e.g.：0.00111
     */
    private String realFee;

    /**
     * transfer status: 1000 awaiting approval, 1100 Approved while awaiting signature, 1200 Payment in progress,
     * 2000Payment completed, 2100 Not Approved, 2200 Rejected, 2300 Transaction discarded, 2400Payment failed
     */
    private Integer status;

    /**
     * Number of block confirmations, e.g.：10
     */
    private Integer confirmations;

    /**
     * Block height at which the transaction is completed
     */
    private Long txHeight;

    /**
     * transfer Type： 1app, 2openapi, 3web
     */
    private Integer withdrawSource;

    /**
     * Creation time timestamp
     */
    private Long createdAt;

    /**
     * Modification time timestamp
     */
    private Long updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Long getTxHeight() {
        return txHeight;
    }

    public void setTxHeight(Long txHeight) {
        this.txHeight = txHeight;
    }

    public Integer getWithdrawSource() {
        return withdrawSource;
    }

    public void setWithdrawSource(Integer withdrawSource) {
        this.withdrawSource = withdrawSource;
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
}
