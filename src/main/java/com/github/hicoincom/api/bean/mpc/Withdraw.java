package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class Withdraw implements Serializable {

    private static final long serialVersionUID = 4368280347740524798L;

    /**
     * transfer id
     */
    @JSONField(name = "withdraw_id")
    private Integer withdrawId;

    public Integer getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(Integer withdrawId) {
        this.withdrawId = withdrawId;
    }
}
