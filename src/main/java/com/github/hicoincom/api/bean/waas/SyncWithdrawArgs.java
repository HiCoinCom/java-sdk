package com.github.hicoincom.api.bean.waas;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * Sync user withdrawal record
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncWithdrawList.html
 */
public class SyncWithdrawArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = -290914647094753506L;

    @JSONField(name ="max_id")
    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
