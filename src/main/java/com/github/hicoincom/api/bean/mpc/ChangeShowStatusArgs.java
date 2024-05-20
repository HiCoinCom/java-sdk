package com.github.hicoincom.api.bean.mpc;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class ChangeShowStatusArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 8399249266660042010L;

    @JSONField(name = "sub_wallet_ids")
    private String subWalletIds;

    @JSONField(name = "app_show_status")
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
