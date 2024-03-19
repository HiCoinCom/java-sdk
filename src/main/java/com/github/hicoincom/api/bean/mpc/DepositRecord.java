package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * deposit record : https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/deposit/deposit-list
 */
public class DepositRecord implements Serializable {

    private static final long serialVersionUID = 5054578546218570991L;

    /**
     * Receiving id
     */
    private Integer id;

    /**
     * wallet id
     */
    @JSONField(name = "sub_wallet_id")
    private Integer subWalletId;

    /**
     * Unique identifier for the coin, used for transfers, e.g.：USDTERC20
     */
    private String symbol;

    /**
     * The unique identifier of the main chain of the coin to be received, e.g.：ETH
     */
    @JSONField(name = "base_symbol")
    private String baseSymbol;

    /**
     * received coin’s contract address
     */
    @JSONField(name = "contract_address")
    private String contractAddress;

    /**
     * receiving amount
     */
    private String amount;

    /**
     * transfer from address
     */
    @JSONField(name = "address_from")
    private String addressFrom;

    /**
     * receiving address
     */
    @JSONField(name = "address_to")
    private String addressTo;

    /**
     * receiving address memo
     */
    private String memo;

    /**
     * Transaction hash
     */
    private String txid;

    /**
     * Number of block confirmations, e.g.：10
     */
    private Integer confirmations;

    /**
     * Block height at which the transaction is completed
     */
    @JSONField(name = "tx_height")
    private Long txHeight;

    /**
     * receiving status: 1000 unconfirmed, 1100 confirmed (transaction block confirmed),
     * 2000 completed (shown at account), 3000 abnormal
     */
    private Integer status;

    /**
     * Deposit Type, 1: Regular coin deposit, 2: NFT deposit
     */
    @JSONField(name = "deposit_type")
    private Integer depositType;

    /**
     * TokenId for NFT deposit, this value is not empty when: deposit_type=2
     */
    @JSONField(name = "token_id")
    private String tokenId;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public Long getTxHeight() {
        return txHeight;
    }

    public void setTxHeight(Long txHeight) {
        this.txHeight = txHeight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDepositType() {
        return depositType;
    }

    public void setDepositType(Integer depositType) {
        this.depositType = depositType;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
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
