package com.github.hicoincom.api.bean.mpc;

import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class MpcCreateWalletArgs extends BaseCustodyArgs implements Serializable {

    private static final long serialVersionUID = 4874475032767801784L;

    private String subWalletName;

    private String appShowStatus;

    public String getSubWalletName() {
        return subWalletName;
    }

    public void setSubWalletName(String subWalletName) {
        this.subWalletName = subWalletName;
    }

    public String getAppShowStatus() {
        return appShowStatus;
    }

    public void setAppShowStatus(String appShowStatus) {
        this.appShowStatus = appShowStatus;
    }


    public static final class MpcCreateWalletArgsBuilder {
        private String subWalletName;
        private String appShowStatus;

        private MpcCreateWalletArgsBuilder() {
        }

        public static MpcCreateWalletArgsBuilder aMpcCreateWalletArgs() {
            return new MpcCreateWalletArgsBuilder();
        }

        public MpcCreateWalletArgsBuilder subWalletName(String subWalletName) {
            this.subWalletName = subWalletName;
            return this;
        }

        public MpcCreateWalletArgsBuilder appShowStatus(String appShowStatus) {
            this.appShowStatus = appShowStatus;
            return this;
        }

        public MpcCreateWalletArgs build() {
            MpcCreateWalletArgs mpcCreateWalletArgs = new MpcCreateWalletArgs();
            mpcCreateWalletArgs.setSubWalletName(subWalletName);
            mpcCreateWalletArgs.setAppShowStatus(appShowStatus);
            return mpcCreateWalletArgs;
        }
    }
}
