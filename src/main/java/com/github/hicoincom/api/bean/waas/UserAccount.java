package com.github.hicoincom.api.bean.waas;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ChainUp Custody
 * user account entity
 */
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 4511031192480379674L;

    private BigDecimal normalBalance;

    private BigDecimal lockBalance;

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
