package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * Create wallet : https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-create
 */
public class MpcWallet implements Serializable {

    private static final long serialVersionUID = 4910110162836998092L;

    /**
     * wallet id
     */
    private Integer subWalletId;

    public Integer getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(Integer subWalletId) {
        this.subWalletId = subWalletId;
    }
}
