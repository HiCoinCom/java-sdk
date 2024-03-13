package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author Chainup Custody
 */
public class GetMpcCoinDetailsArgs extends BaseCustodyArgs implements Serializable {
    private static final long serialVersionUID = 8835435777668227645L;

    /**
     * Unique identifier for the coin, used for transfers, e.g.：USDTERC20
     * required : false
     */
    private String symbol;

    /**
     * Main chain coins, Unique identifier for the coin, used for transfers, e.g.：ETH
     * required : false
     */
    private String baseSymbol;

    /**
     * Main chain coin, default to getting all, true to get opened coins, false to get unopened coins
     * required : false
     */
    private Boolean openChain;

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

    public Boolean getOpenChain() {
        return openChain;
    }

    public void setOpenChain(Boolean openChain) {
        this.openChain = openChain;
    }


    public static final class GetMpcCoinDetailsArgsBuilder {
        private String symbol;
        private String baseSymbol;
        private Boolean openChain;

        private GetMpcCoinDetailsArgsBuilder() {
        }

        public static GetMpcCoinDetailsArgsBuilder aGetMpcCoinDetailsArgs() {
            return new GetMpcCoinDetailsArgsBuilder();
        }

        public GetMpcCoinDetailsArgsBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public GetMpcCoinDetailsArgsBuilder baseSymbol(String baseSymbol) {
            this.baseSymbol = baseSymbol;
            return this;
        }

        public GetMpcCoinDetailsArgsBuilder openChain(Boolean openChain) {
            this.openChain = openChain;
            return this;
        }

        public GetMpcCoinDetailsArgs build() {
            GetMpcCoinDetailsArgs getMpcCoinDetailsArgs = new GetMpcCoinDetailsArgs();
            getMpcCoinDetailsArgs.setSymbol(symbol);
            getMpcCoinDetailsArgs.setBaseSymbol(baseSymbol);
            getMpcCoinDetailsArgs.setOpenChain(openChain);
            return getMpcCoinDetailsArgs;
        }
    }
}
