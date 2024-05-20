package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class WalletAssets implements Serializable {

    private static final long serialVersionUID = 6345914198305776126L;

    /**
     * Available balance
     */
    private String normalBalance;

    /**
     * Freeze balance
     */
    private String lockBalance;

    /**
     * Balance for awaiting consolidation assets
     */
    private String collectingBalance;

    public String getNormalBalance() {
        return normalBalance;
    }

    public void setNormalBalance(String normalBalance) {
        this.normalBalance = normalBalance;
    }

    public String getLockBalance() {
        return lockBalance;
    }

    public void setLockBalance(String lockBalance) {
        this.lockBalance = lockBalance;
    }

    public String getCollectingBalance() {
        return collectingBalance;
    }

    public void setCollectingBalance(String collectingBalance) {
        this.collectingBalance = collectingBalance;
    }
}
