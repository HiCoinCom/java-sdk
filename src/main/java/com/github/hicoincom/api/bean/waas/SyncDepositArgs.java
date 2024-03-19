package com.github.hicoincom.api.bean.waas;

import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * Sync user deposit record
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncDepositList.html
 */
public class SyncDepositArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 9084750848353802771L;

    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
