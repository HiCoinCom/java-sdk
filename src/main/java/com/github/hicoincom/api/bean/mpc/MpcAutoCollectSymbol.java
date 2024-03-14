package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class MpcAutoCollectSymbol implements Serializable {

    private static final long serialVersionUID = -3744725537574507234L;

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
