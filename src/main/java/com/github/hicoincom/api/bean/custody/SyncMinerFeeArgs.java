package com.github.hicoincom.api.bean.custody;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseWaasArgs;

import java.io.Serializable;

/**
 *  Sync user asset consolidation records
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncDepositList.html
 */
public class SyncMinerFeeArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name ="max_id")
    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
