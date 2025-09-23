package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author Chainup Custody
 */
public class CoinDetails implements Serializable {

    private static final long serialVersionUID = 3004088185231976665L;

    /**
     * Coin id
     */
    @JSONField(name = "id")
    private Integer id;

    /**
     * Unique identifier of the base coin of the main chain, e.g.：MATIC1
     */
    @JSONField(name = "base_symbol")
    private String baseSymbol;

    /**
     * Coin network
     */
    @JSONField(name = "coin_net")
    private String coinNet;

    /**
     * Unique identifier for the coin, e.g.：MATIC1
     */
    private String symbol;

    /**
     * Real name of the coin
     */
    @JSONField(name = "symbol_alias")
    private String symbolAlias;

    /**
     * Address regex pattern, e.g.：.*
     */
    @JSONField(name = "address_regex")
    private String addressRegex;

    /**
     * Address tag regex pattern
     */
    @JSONField(name = "address_tag_regex")
    private String addressTagRegex;

    /**
     * Contract address supported by MPC main chain
     */
    @JSONField(name = "contract_address")
    private String contractAddress;

    /**
     * Coin precision
     */
    private Integer decimals;

    /**
     * Number of confirmations for deposits
     */
    @JSONField(name = "deposit_confirmation")
    private Integer depositConfirmation;

    /**
     * Prefix for the block explorer address query link.
     */
    @JSONField(name = "address_link")
    private String addressLink;

    /**
     * Prefix for the block explorer address query link.
     */
    @JSONField(name = "txid_link")
    private String txidLink;

    /**
     * Coin icon
     */
    private String icon;

    /**
     * Indicates if the main chain is open (false/true)
     */
    @JSONField(name = "if_open_chain")
    private Boolean ifOpenChain;

    /**
     * Name of the coin on the blockchain
     */
    @JSONField(name = "real_symbol")
    private String realSymbol;

    /**
     * Indicates if memo is supported (0:not supported, 1:supported)
     */
    @JSONField(name = "support_memo")
    private String supportMemo;

    /**
     * Indicates if token coins are supported (0:not supported, 1:supported for main chain coins, empty for tokens)
     */
    @JSONField(name = "support_token")
    private String supportToken;

    /**
     * Indicates if acceleration is supported (false/true)
     */
    @JSONField(name = "support_acceleration")
    private Boolean supportAcceleration;

    /**
     * Support for multiple addresses, true: supported, false: not supported
     */
    @JSONField(name = "support_multi_addr")
    private Boolean supportMultiAddr;

    /**
     * Merged address main chain coin, Unique identifier for the coin
     */
    @JSONField(name = "merge_address_symbol")
    private String mergeAddressSymbol;

    /**
     * Belongs to the main chain coin type, 0 for account type, 1 for utxo-type main chain, 2 for Memo type
     */
    @JSONField(name = "coin_type")
    private Integer coinType;

    /**
     * Minimum withdrawal amount
     */
    @JSONField(name = "min_withdraw")
    private String minWithdraw;

    /**
     * Withdrawal unlock confirmation number
     */
    @JSONField(name = "withdraw_confirmation")
    private Integer withdrawConfirmation;

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public String getCoinNet() {
        return coinNet;
    }

    public void setCoinNet(String coinNet) {
        this.coinNet = coinNet;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbolAlias() {
        return symbolAlias;
    }

    public void setSymbolAlias(String symbolAlias) {
        this.symbolAlias = symbolAlias;
    }

    public String getAddressRegex() {
        return addressRegex;
    }

    public void setAddressRegex(String addressRegex) {
        this.addressRegex = addressRegex;
    }

    public String getAddressTagRegex() {
        return addressTagRegex;
    }

    public void setAddressTagRegex(String addressTagRegex) {
        this.addressTagRegex = addressTagRegex;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    public Integer getDepositConfirmation() {
        return depositConfirmation;
    }

    public void setDepositConfirmation(Integer depositConfirmation) {
        this.depositConfirmation = depositConfirmation;
    }

    public String getAddressLink() {
        return addressLink;
    }

    public void setAddressLink(String addressLink) {
        this.addressLink = addressLink;
    }

    public String getTxidLink() {
        return txidLink;
    }

    public void setTxidLink(String txidLink) {
        this.txidLink = txidLink;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getIfOpenChain() {
        return ifOpenChain;
    }

    public void setIfOpenChain(Boolean ifOpenChain) {
        this.ifOpenChain = ifOpenChain;
    }

    public String getRealSymbol() {
        return realSymbol;
    }

    public void setRealSymbol(String realSymbol) {
        this.realSymbol = realSymbol;
    }

    public String getSupportMemo() {
        return supportMemo;
    }

    public void setSupportMemo(String supportMemo) {
        this.supportMemo = supportMemo;
    }

    public String getSupportToken() {
        return supportToken;
    }

    public void setSupportToken(String supportToken) {
        this.supportToken = supportToken;
    }

    public Boolean getSupportAcceleration() {
        return supportAcceleration;
    }

    public void setSupportAcceleration(Boolean supportAcceleration) {
        this.supportAcceleration = supportAcceleration;
    }

    public Boolean getSupportMultiAddr() {
        return supportMultiAddr;
    }

    public void setSupportMultiAddr(Boolean supportMultiAddr) {
        this.supportMultiAddr = supportMultiAddr;
    }

    public String getMergeAddressSymbol() {
        return mergeAddressSymbol;
    }

    public void setMergeAddressSymbol(String mergeAddressSymbol) {
        this.mergeAddressSymbol = mergeAddressSymbol;
    }

    public Integer getCoinType() {
        return coinType;
    }

    public void setCoinType(Integer coinType) {
        this.coinType = coinType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMinWithdraw() {
        return minWithdraw;
    }

    public void setMinWithdraw(String minWithdraw) {
        this.minWithdraw = minWithdraw;
    }

    public Integer getWithdrawConfirmation() {
        return withdrawConfirmation;
    }

    public void setWithdrawConfirmation(Integer withdrawConfirmation) {
        this.withdrawConfirmation = withdrawConfirmation;
    }
}
