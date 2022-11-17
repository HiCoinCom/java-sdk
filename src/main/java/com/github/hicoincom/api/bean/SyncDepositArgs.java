package com.github.hicoincom.api.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 *  Sync user deposit record
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncDepositList.html
 */
public class SyncDepositArgs extends BaseWaasArgs implements Serializable {

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
