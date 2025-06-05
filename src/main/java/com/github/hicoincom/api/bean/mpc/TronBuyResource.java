package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author jiamin.bai
 * @since 2025-04-29
 */
public class TronBuyResource implements Serializable {

    private static final long serialVersionUID = 4144179846818277045L;

    /**
     * transfer id
     */
    @JSONField(name = "trans_id")
    private Integer transId;

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }
}
