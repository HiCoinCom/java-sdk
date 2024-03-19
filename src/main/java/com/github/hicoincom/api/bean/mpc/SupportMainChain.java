package com.github.hicoincom.api.bean.mpc;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chainup Custody
 */
public class SupportMainChain implements Serializable {

    private static final long serialVersionUID = 2941423101293826539L;

    /**
     * Opened main chains in the workspace
     */
    private List<SupportCoin> openMainChain;

    /**
     * Supported main chains in MPC
     */
    private List<SupportCoin> supportMainChain;

    public List<SupportCoin> getOpenMainChain() {
        return openMainChain;
    }

    public void setOpenMainChain(List<SupportCoin> openMainChain) {
        this.openMainChain = openMainChain;
    }

    public List<SupportCoin> getSupportMainChain() {
        return supportMainChain;
    }

    public void setSupportMainChain(List<SupportCoin> supportMainChain) {
        this.supportMainChain = supportMainChain;
    }
}
