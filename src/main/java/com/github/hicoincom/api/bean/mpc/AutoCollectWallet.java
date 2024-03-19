package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class AutoCollectWallet implements Serializable {

    private static final long serialVersionUID = 1456161233537070814L;


    /**
     * Auto-consolidation wallet, obtained after configuring the coin
     */
    @JSONField(name = "collect_sub_wallet_id")
    private Integer collectSubWalletId;

    /**
     * Refueling wallet, obtained after configuring the coin
     */
    @JSONField(name = "fueling_sub_wallet_id")
    private Integer fuelingSubWalletId;

    public Integer getCollectSubWalletId() {
        return collectSubWalletId;
    }

    public void setCollectSubWalletId(Integer collectSubWalletId) {
        this.collectSubWalletId = collectSubWalletId;
    }

    public Integer getFuelingSubWalletId() {
        return fuelingSubWalletId;
    }

    public void setFuelingSubWalletId(Integer fuelingSubWalletId) {
        this.fuelingSubWalletId = fuelingSubWalletId;
    }
}
