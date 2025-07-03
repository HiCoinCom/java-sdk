package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class Web3Record implements Serializable {

    private static final long serialVersionUID = 5726347602452336880L;

    /**
     * Web3 transaction ID
     */
    private Integer id;

    /**
     * Unique identifier for the transaction
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * Wallet id
     */
    @JSONField(name = "sub_wallet_id")
    private Integer subWalletId;

    /**
     * Transaction hash
     */
    private String txid;

    /**
     * Transaction coin
     */
    private String symbol;

    /**
     * Main chain coin symbol (unique identifier), e.g.：ETH
     */
    @JSONField(name = "main_chain_symbol")
    private String mainChainSymbol;

    /**
     * Transaction amount. -1 indicates infinite
     */
    private String amount;

    /**
     * Fee currency, e.g.：ETH
     */
    @JSONField(name = "fee_symbol")
    private String feeSymbol;

    /**
     * Actual fee consumed, e.g.：0.00111
     */
    private String fee;

    /**
     * Actual fee consumed, e.g.：0.00111
     */
    @JSONField(name = "real_fee")
    private String realFee;

    /**
     * Creation time timestamp
     */
    @JSONField(name = "created_at")
    private Long createdAt;

    /**
     * Modification time timestamp
     */
    @JSONField(name = "updated_at")
    private Long updatedAt;

    /**
     * Transaction source address
     */
    @JSONField(name = "address_from")
    private String addressFrom;

    /**
     * Transaction destination address
     */
    @JSONField(name = "address_to")
    private String addressTo;

    /**
     * Interactive contract
     */
    @JSONField(name = "interactive_contract")
    private String interactiveContract;

    /**
     * Confirmations, e.g.：10
     */
    private Integer confirmations;

    /**
     * Block height at which the transaction is completed
     */
    @JSONField(name = "tx_height")
    private Long txHeight;

    /**
     * Hexadecimal data for contract transaction
     */
    @JSONField(name = "input_data")
    private String inputData;

    /**
     * Transaction status: 1100 Pending Signature, 1200 Payment Processing, 2000 Payment Complete,
     * 2100 Approval Rejected, 2200 Rejected, 2300 Transaction Discarded, 2400 Payment Failed
     */
    private Integer status;

    /**
     * Transaction type： 1app, 2openapi
     */
    @JSONField(name = "trans_source")
    private Integer transSource;

    @JSONField(name = "trans_type")
    private Integer transType;


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

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMainChainSymbol() {
        return mainChainSymbol;
    }

    public void setMainChainSymbol(String mainChainSymbol) {
        this.mainChainSymbol = mainChainSymbol;
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

    public String getInteractiveContract() {
        return interactiveContract;
    }

    public void setInteractiveContract(String interactiveContract) {
        this.interactiveContract = interactiveContract;
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

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTransSource() {
        return transSource;
    }

    public void setTransSource(Integer transSource) {
        this.transSource = transSource;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }
}
