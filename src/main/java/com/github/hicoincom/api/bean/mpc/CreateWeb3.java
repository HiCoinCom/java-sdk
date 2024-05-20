package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class CreateWeb3 implements Serializable {

    private static final long serialVersionUID = 514959945473043099L;

    /**
     * Web3 transaction ID
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
