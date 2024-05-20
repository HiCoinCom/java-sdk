package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class GetLastBlockHeightArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 5725608221014531468L;

    private String baseSymbol;

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }
}
