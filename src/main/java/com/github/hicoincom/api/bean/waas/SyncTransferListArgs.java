package com.github.hicoincom.api.bean.waas;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * Sync transfer record list parameters
 */
public class SyncTransferListArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 2001795963308584747L;

    @JSONField(name ="max_id")
    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
