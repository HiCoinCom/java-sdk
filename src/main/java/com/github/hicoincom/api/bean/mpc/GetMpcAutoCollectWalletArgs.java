package com.github.hicoincom.api.bean.mpc;

import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class GetMpcAutoCollectWalletArgs extends BaseCustodyArgs implements Serializable {

    private static final long serialVersionUID = 8978228705962627779L;

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public static final class GetMpcAutoCollectWalletArgsBuilder {
        private String symbol;

        private GetMpcAutoCollectWalletArgsBuilder() {
        }

        public static GetMpcAutoCollectWalletArgsBuilder aGetMpcAutoCollectWalletArgs() {
            return new GetMpcAutoCollectWalletArgsBuilder();
        }

        public GetMpcAutoCollectWalletArgsBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public GetMpcAutoCollectWalletArgs build() {
            GetMpcAutoCollectWalletArgs getMpcAutoCollectWalletArgs = new GetMpcAutoCollectWalletArgs();
            getMpcAutoCollectWalletArgs.setSymbol(symbol);
            return getMpcAutoCollectWalletArgs;
        }
    }
}
