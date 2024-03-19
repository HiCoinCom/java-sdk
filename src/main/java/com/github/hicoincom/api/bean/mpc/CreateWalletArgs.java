package com.github.hicoincom.api.bean.mpc;

import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class CreateWalletArgs extends BaseArgs implements Serializable {

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

}
