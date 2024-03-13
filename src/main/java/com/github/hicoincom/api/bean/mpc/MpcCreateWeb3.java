package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class MpcCreateWeb3 implements Serializable {

    private static final long serialVersionUID = 514959945473043099L;

    /**
     * Web3 transaction ID
     */
    private Integer transId;

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }
}
