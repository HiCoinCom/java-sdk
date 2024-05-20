package com.github.hicoincom.api.bean.waas;

import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * Sync user asset consolidation records
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncDepositList.html
 */
public class SyncMinerFeeArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 7361169948137553688L;

    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
