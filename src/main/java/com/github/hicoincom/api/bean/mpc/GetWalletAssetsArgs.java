package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class GetWalletAssetsArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = -8831747607916221135L;

    private Integer subWalletId;

    private String symbol;

    public Integer getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(Integer subWalletId) {
        this.subWalletId = subWalletId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
