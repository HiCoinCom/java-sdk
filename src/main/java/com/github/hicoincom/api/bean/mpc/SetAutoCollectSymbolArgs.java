package com.github.hicoincom.api.bean.mpc;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Chainup Custody
 */
public class SetAutoCollectSymbolArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = -3092941119219100586L;

    /**
     * Unique identifier for the coin, e.g.：USDTERC20
     */
    private String symbol;

    /**
     * Minimum amount for auto-sweep; up to 6 decimal places, not exceeding 9999999999999999
     */
    @JSONField(name = "collect_min")
    private String collectMin;

    /**
     * Maximum miner fee amount for auto-sweep; up to 6 decimal places, not exceeding 9999999999999999
     */
    @JSONField(name = "fueling_limit")
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
}
