package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;

/**
 * @author Chainup Custody
 */
public class SupportCoin implements Serializable {

    private static final long serialVersionUID = -2359947149713191632L;

    /**
     * Unique identifier for the coin, e.g.：ETH
     */
    private String symbol;

    /**
     * Coin network, e.g.：ETH
     */
    private String coinNet;

    /**
     * Real name of the coin, e.g.：ETH
     */
    private String symbolAlias;


    /**
     * Indicates if acceleration is supported (true/false)
     */
    private Boolean supportAcceleration;

    /**
     * Indicates if the main chain is opened (false/true)
     */
    private Boolean ifOpenChain;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCoinNet() {
        return coinNet;
    }

    public void setCoinNet(String coinNet) {
        this.coinNet = coinNet;
    }

    public String getSymbolAlias() {
        return symbolAlias;
    }

    public void setSymbolAlias(String symbolAlias) {
        this.symbolAlias = symbolAlias;
    }

    public Boolean getSupportAcceleration() {
        return supportAcceleration;
    }

    public void setSupportAcceleration(Boolean supportAcceleration) {
        this.supportAcceleration = supportAcceleration;
    }

    public Boolean getIfOpenChain() {
        return ifOpenChain;
    }

    public void setIfOpenChain(Boolean ifOpenChain) {
        this.ifOpenChain = ifOpenChain;
    }
}
