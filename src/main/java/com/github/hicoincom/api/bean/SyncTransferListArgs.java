package com.github.hicoincom.api.bean;


import java.io.Serializable;

/**
 * 同步转账记录列表参数
 */
public class SyncTransferListArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer max_id;

    public Integer getMax_id() {
        return max_id;
    }

    public void setMax_id(Integer max_id) {
        this.max_id = max_id;
    }
}
