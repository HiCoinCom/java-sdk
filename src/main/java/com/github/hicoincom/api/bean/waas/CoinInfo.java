package com.github.hicoincom.api.bean.waas;

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

    private String realSymbol;

    private String baseSymbol;

    private Integer decimals;

    private String contractAddress;

    private Integer depositConfirmation;

    private Byte supportMemo;

    private Byte supportToken;

    private String addressRegex;

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
