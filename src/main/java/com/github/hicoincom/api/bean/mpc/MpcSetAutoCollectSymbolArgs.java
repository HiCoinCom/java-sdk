package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author Chainup Custody
 */
public class MpcSetAutoCollectSymbolArgs extends BaseCustodyArgs implements Serializable {


    private static final long serialVersionUID = -3092941119219100586L;

    /**
     * Unique identifier for the coin, e.g.：USDTERC20
     */
    private String symbol;

    /**
     * Minimum amount for auto-sweep; up to 6 decimal places, not exceeding 9999999999999999
     */
    private String collectMin;

    /**
     * Maximum miner fee amount for auto-sweep; up to 6 decimal places, not exceeding 9999999999999999
     */
    private String fuelingLimit;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCollectMin() {
        return collectMin;
    }

    public void setCollectMin(String collectMin) {
        this.collectMin = collectMin;
    }

    public String getFuelingLimit() {
        return fuelingLimit;
    }

    public void setFuelingLimit(String fuelingLimit) {
        this.fuelingLimit = fuelingLimit;
    }


    public static final class MpcSetAutoCollectSymbolArgsBuilder {
        private String symbol;
        private String collectMin;
        private String fuelingLimit;

        private MpcSetAutoCollectSymbolArgsBuilder() {
        }

        public static MpcSetAutoCollectSymbolArgsBuilder aMpcSetAutoCollectSymbolArgs() {
            return new MpcSetAutoCollectSymbolArgsBuilder();
        }

        public MpcSetAutoCollectSymbolArgsBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public MpcSetAutoCollectSymbolArgsBuilder collectMin(String collectMin) {
            this.collectMin = collectMin;
            return this;
        }

        public MpcSetAutoCollectSymbolArgsBuilder fuelingLimit(String fuelingLimit) {
            this.fuelingLimit = fuelingLimit;
            return this;
        }

        public MpcSetAutoCollectSymbolArgs build() {
            MpcSetAutoCollectSymbolArgs mpcSetAutoCollectSymbolArgs = new MpcSetAutoCollectSymbolArgs();
            mpcSetAutoCollectSymbolArgs.setSymbol(symbol);
            mpcSetAutoCollectSymbolArgs.setCollectMin(collectMin);
            mpcSetAutoCollectSymbolArgs.setFuelingLimit(fuelingLimit);
            return mpcSetAutoCollectSymbolArgs;
        }
    }
}
