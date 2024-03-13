package com.github.hicoincom.api.bean.custody;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseWaasArgs;

import java.io.Serializable;

/**
 * Sync transfer record list parameters
 */
public class SyncTransferListArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "max_id")
    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
