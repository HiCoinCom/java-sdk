package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;

/**
 * @author Chainup Custody
 */
public class CoinDetails implements Serializable {

    private static final long serialVersionUID = 3004088185231976665L;

    /**
     * Unique identifier of the base coin of the main chain, e.g.：MATIC1
     */
    private String baseSymbol;

    /**
     * Coin network
     */
    private String coinNet;

    /**
     * Unique identifier for the coin, e.g.：MATIC1
     */
    private String symbol;

    /**
     * Real name of the coin
     */
    private String symbolAlias;

    /**
     * Address regex pattern, e.g.：.*
     */
    private String addressRegex;

    /**
     * Address tag regex pattern
     */
    private String addressTagRegex;

    /**
     * Contract address supported by MPC main chain
     */
    private String contractAddress;

    /**
     * Coin precision
     */
    private Integer decimals;

    /**
     * Number of confirmations for deposits
     */
    private Integer depositConfirmation;

    /**
     * Prefix for the block explorer address query link.
     */
    private String addressLink;

    /**
     * Prefix for the block explorer address query link.
     */
    private String txidLink;

    /**
     * Coin icon
     */
    private String icon;

    /**
     * Indicates if the main chain is open (false/true)
     */
    private Boolean ifOpenChain;

    /**
     * Name of the coin on the blockchain
     */
    private String realSymbol;

    /**
     * Indicates if memo is supported (0:not supported, 1:supported)
     */
    private String supportMemo;

    /**
     * Indicates if token coins are supported (0:not supported, 1:supported for main chain coins, empty for tokens)
     */
    private String supportToken;

    /**
     * Indicates if acceleration is supported (false/true)
     */
    private Boolean supportAcceleration;

    /**
     * Support for multiple addresses, true: supported, false: not supported
     */
    private Boolean supportMultiAddr;

    /**
     * Merged address main chain coin, Unique identifier for the coin
     */
    private String mergeAddressSymbol;

    /**
     * Belongs to the main chain coin type, 0 for account type, 1 for utxo-type main chain, 2 for Memo type
     */
    private Integer coinType;

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
}
