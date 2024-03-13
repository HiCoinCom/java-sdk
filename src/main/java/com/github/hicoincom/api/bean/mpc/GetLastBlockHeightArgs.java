package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class GetLastBlockHeightArgs extends BaseCustodyArgs implements Serializable {

    private static final long serialVersionUID = 5725608221014531468L;

    private String baseSymbol;

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }


    public static final class GetLastBlockHeightArgsBuilder {
        private String baseSymbol;

        private GetLastBlockHeightArgsBuilder() {
        }

        public static GetLastBlockHeightArgsBuilder aGetLastBlockHeightArgs() {
            return new GetLastBlockHeightArgsBuilder();
        }

        public GetLastBlockHeightArgsBuilder baseSymbol(String baseSymbol) {
            this.baseSymbol = baseSymbol;
            return this;
        }

        public GetLastBlockHeightArgs build() {
            GetLastBlockHeightArgs getLastBlockHeightArgs = new GetLastBlockHeightArgs();
            getLastBlockHeightArgs.setBaseSymbol(baseSymbol);
            return getLastBlockHeightArgs;
        }
    }
}
