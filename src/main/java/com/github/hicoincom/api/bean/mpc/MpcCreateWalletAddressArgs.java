package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class MpcCreateWalletAddressArgs extends BaseCustodyArgs implements Serializable {

    private static final long serialVersionUID = 7416475943051317744L;

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


    public static final class MpcCreateWalletAddressArgsBuilder {
        private Integer subWalletId;
        private String symbol;

        private MpcCreateWalletAddressArgsBuilder() {
        }

        public static MpcCreateWalletAddressArgsBuilder aMpcCreateWalletAddressArgs() {
            return new MpcCreateWalletAddressArgsBuilder();
        }

        public MpcCreateWalletAddressArgsBuilder subWalletId(Integer subWalletId) {
            this.subWalletId = subWalletId;
            return this;
        }

        public MpcCreateWalletAddressArgsBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public MpcCreateWalletAddressArgs build() {
            MpcCreateWalletAddressArgs mpcCreateWalletAddressArgs = new MpcCreateWalletAddressArgs();
            mpcCreateWalletAddressArgs.setSubWalletId(subWalletId);
            mpcCreateWalletAddressArgs.setSymbol(symbol);
            return mpcCreateWalletAddressArgs;
        }
    }
}
