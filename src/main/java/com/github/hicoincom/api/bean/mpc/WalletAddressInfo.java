package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class WalletAddressInfo implements Serializable {

    private static final long serialVersionUID = 7615919625046960924L;

    /**
     * Wallet ID
     */
    private Integer subWalletId;

    /**
     * Address type, 1: User address, 2: System address (including collection address, change address).
     * System address cannot be assigned to users, change from UTXO transactions will all go to the change address
     */
    private Integer addrType;

    /**
     * Unique coin identifier
     */
    private String mergeAddressSymbol;

    public Integer getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(Integer subWalletId) {
        this.subWalletId = subWalletId;
    }

    public Integer getAddrType() {
        return addrType;
    }

    public void setAddrType(Integer addrType) {
        this.addrType = addrType;
    }

    public String getMergeAddressSymbol() {
        return mergeAddressSymbol;
    }

    public void setMergeAddressSymbol(String mergeAddressSymbol) {
        this.mergeAddressSymbol = mergeAddressSymbol;
    }
}
