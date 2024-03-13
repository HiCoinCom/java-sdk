package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class GetMpcWalletAssetsArgs extends BaseCustodyArgs implements Serializable  {
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


    public static final class GetWalletAssetsArgsBuilder {
        private Integer subWalletId;
        private String symbol;

        private GetWalletAssetsArgsBuilder() {
        }

        public static GetWalletAssetsArgsBuilder aGetWalletAssetsArgs() {
            return new GetWalletAssetsArgsBuilder();
        }

        public GetWalletAssetsArgsBuilder subWalletId(Integer subWalletId) {
            this.subWalletId = subWalletId;
            return this;
        }

        public GetWalletAssetsArgsBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public GetMpcWalletAssetsArgs build() {
            GetMpcWalletAssetsArgs getWalletAssetsArgs = new GetMpcWalletAssetsArgs();
            getWalletAssetsArgs.setSubWalletId(subWalletId);
            getWalletAssetsArgs.setSymbol(symbol);
            return getWalletAssetsArgs;
        }
    }
}
