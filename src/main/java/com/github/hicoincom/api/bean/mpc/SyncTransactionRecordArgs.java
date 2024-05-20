package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;
import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class SyncTransactionRecordArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 1013291748580371783L;

    /**
     * Custody withdraw record id
     */
    @JSONField(name = "max_id")
    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
