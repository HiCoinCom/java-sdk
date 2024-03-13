package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chainup Custody
 */
public class MpcSupportMainChain implements Serializable {
    private static final long serialVersionUID = 2941423101293826539L;


    /**
     * Opened main chains in the workspace
     */
    private List<MpcSupportCoin> openMainChain;

    /**
     * Supported main chains in MPC
     */
    private List<MpcSupportCoin> supportMainChain;

    public List<MpcSupportCoin> getOpenMainChain() {
        return openMainChain;
    }

    public void setOpenMainChain(List<MpcSupportCoin> openMainChain) {
        this.openMainChain = openMainChain;
    }

    public List<MpcSupportCoin> getSupportMainChain() {
        return supportMainChain;
    }

    public void setSupportMainChain(List<MpcSupportCoin> supportMainChain) {
        this.supportMainChain = supportMainChain;
    }
}
