package com.github.hicoincom.api.bean.mpc;

import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class MpcQueryAddressArgs extends BaseCustodyArgs implements Serializable {
    private static final long serialVersionUID = -6852551858005120407L;

    private Integer subWalletId;

    private String symbol;

    private Integer maxId;

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

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }


    public static final class QueryMpcAddressArgsBuilder {
        private Integer subWalletId;
        private String symbol;
        private Integer maxId;

        private QueryMpcAddressArgsBuilder() {
        }

        public static QueryMpcAddressArgsBuilder aQueryMpcAddressArgs() {
            return new QueryMpcAddressArgsBuilder();
        }

        public QueryMpcAddressArgsBuilder subWalletId(Integer subWalletId) {
            this.subWalletId = subWalletId;
            return this;
        }

        public QueryMpcAddressArgsBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public QueryMpcAddressArgsBuilder maxId(Integer maxId) {
            this.maxId = maxId;
            return this;
        }

        public MpcQueryAddressArgs build() {
            MpcQueryAddressArgs queryMpcAddressArgs = new MpcQueryAddressArgs();
            queryMpcAddressArgs.setSubWalletId(subWalletId);
            queryMpcAddressArgs.setSymbol(symbol);
            queryMpcAddressArgs.setMaxId(maxId);
            return queryMpcAddressArgs;
        }
    }
}
