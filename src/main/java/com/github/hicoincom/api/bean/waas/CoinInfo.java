package com.github.hicoincom.api.bean.waas;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * obtain coins list
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
 */

public class CoinInfo implements Serializable {

    private static final long serialVersionUID = 721780497244831928L;

    private String symbol;

    private String icon;

    @JSONField(name ="real_symbol")
    private String realSymbol;

    @JSONField(name ="base_symbol")
    private String baseSymbol;

    private String decimals;

    @JSONField(name ="contract_address")
    private String contractAddress;

    @JSONField(name ="deposit_confirmation")
    private Integer depositConfirmation;

    @JSONField(name ="support_memo")
    private Byte supportMemo;

    @JSONField(name ="support_token")
    private Byte supportToken;

    @JSONField(name ="address_regex")
    private String addressRegex;

    @JSONField(name ="address_tag_regex")
    private String addressTagRegex;

    @JSONField(name ="min_deposit")
    private String minDeposit;

    @JSONField(name ="symbol_alias")
    private String symbolAlias;

    @JSONField(name ="coin_net")
    private String coinNet;

    @JSONField(name ="withdraw_confirmation")
    private Integer withdrawConfirmation;

    @JSONField(name ="address_link")
    private String addressLink;

    @JSONField(name ="txid_link")
    private String txidLink;

    @JSONField(name ="merge_address_symbol")
    private String mergeAddressSymbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRealSymbol() {
        return realSymbol;
    }

    public void setRealSymbol(String realSymbol) {
        this.realSymbol = realSymbol;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public String getDecimals() {
        return decimals;
    }

    public void setDecimals(String decimals) {
        this.decimals = decimals;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public Integer getDepositConfirmation() {
        return depositConfirmation;
    }

    public void setDepositConfirmation(Integer depositConfirmation) {
        this.depositConfirmation = depositConfirmation;
    }

    public Byte getSupportMemo() {
        return supportMemo;
    }

    public void setSupportMemo(Byte supportMemo) {
        this.supportMemo = supportMemo;
    }

    public Byte getSupportToken() {
        return supportToken;
    }

    public void setSupportToken(Byte supportToken) {
        this.supportToken = supportToken;
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

    public String getMinDeposit() {
        return minDeposit;
    }

    public void setMinDeposit(String minDeposit) {
        this.minDeposit = minDeposit;
    }

    public String getSymbolAlias() {
        return symbolAlias;
    }

    public void setSymbolAlias(String symbolAlias) {
        this.symbolAlias = symbolAlias;
    }

    public String getCoinNet() {
        return coinNet;
    }

    public void setCoinNet(String coinNet) {
        this.coinNet = coinNet;
    }

    public Integer getWithdrawConfirmation() {
        return withdrawConfirmation;
    }

    public void setWithdrawConfirmation(Integer withdrawConfirmation) {
        this.withdrawConfirmation = withdrawConfirmation;
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

    public String getMergeAddressSymbol() {
        return mergeAddressSymbol;
    }

    public void setMergeAddressSymbol(String mergeAddressSymbol) {
        this.mergeAddressSymbol = mergeAddressSymbol;
    }
}
