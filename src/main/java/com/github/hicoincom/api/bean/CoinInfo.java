package com.github.hicoincom.api.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 *  获取币种列表
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
 */
public class CoinInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String symbol;
    private String icon;
    @JSONField(name ="real_symbol")
    private String realSymbol;
    @JSONField(name ="base_symbol")
    private String baseSymbol;
    private Integer decimals;
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

    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
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
}
