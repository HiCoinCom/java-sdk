package com.github.hicoincom.api.bean.mpc;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class CreateWalletAddressArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 7416475943051317744L;

    @JSONField(name = "sub_wallet_id")
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
