package com.chainup.waas.api.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *  短信邮箱注册参数
 */
public class UserAccount  implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name ="normal_balance")
    private BigDecimal normalBalance;
    @JSONField(name ="lock_balance")
    private BigDecimal lockBalance;
    @JSONField(name ="deposit_address")
    private String depositAddress;

    public BigDecimal getNormalBalance() {
        return normalBalance;
    }

    public void setNormalBalance(BigDecimal normalBalance) {
        this.normalBalance = normalBalance;
    }

    public BigDecimal getLockBalance() {
        return lockBalance;
    }

    public void setLockBalance(BigDecimal lockBalance) {
        this.lockBalance = lockBalance;
    }

    public String getDepositAddress() {
        return depositAddress;
    }

    public void setDepositAddress(String depositAddress) {
        this.depositAddress = depositAddress;
    }
}
