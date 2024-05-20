package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class ChangeShowStatusArgs extends BaseArgs implements Serializable {

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

}
