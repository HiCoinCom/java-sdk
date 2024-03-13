package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class MpcChangeShowStatusArgs extends BaseCustodyArgs implements Serializable {
    private static final long serialVersionUID = 8399249266660042010L;

    private String subWalletIds;

    private String appShowStatus;

    public String getSubWalletIds() {
        return subWalletIds;
    }

    public void setSubWalletIds(String subWalletIds) {
        this.subWalletIds = subWalletIds;
    }

    public String getAppShowStatus() {
        return appShowStatus;
    }

    public void setAppShowStatus(String appShowStatus) {
        this.appShowStatus = appShowStatus;
    }


    public static final class MpcChangeShowStatusArgsBuilder {
        private String subWalletIds;
        private String appShowStatus;

        private MpcChangeShowStatusArgsBuilder() {
        }

        public static MpcChangeShowStatusArgsBuilder aMpcChangeShowStatusArgs() {
            return new MpcChangeShowStatusArgsBuilder();
        }

        public MpcChangeShowStatusArgsBuilder subWalletIds(String subWalletIds) {
            this.subWalletIds = subWalletIds;
            return this;
        }

        public MpcChangeShowStatusArgsBuilder appShowStatus(String appShowStatus) {
            this.appShowStatus = appShowStatus;
            return this;
        }

        public MpcChangeShowStatusArgs build() {
            MpcChangeShowStatusArgs mpcChangeShowStatusArgs = new MpcChangeShowStatusArgs();
            mpcChangeShowStatusArgs.setSubWalletIds(subWalletIds);
            mpcChangeShowStatusArgs.setAppShowStatus(appShowStatus);
            return mpcChangeShowStatusArgs;
        }
    }
}
