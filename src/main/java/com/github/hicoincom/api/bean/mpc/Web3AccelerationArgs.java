package com.github.hicoincom.api.bean.mpc;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * Web3 Transaction Acceleration, https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-pending
 */
public class Web3AccelerationArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = -3803914412032960597L;

    /**
     * Web3 transaction ID
     * required : true
     */
    @JSONField(name = "trans_id")
    private Integer transId;

    /**
     * Gas fee，unit：Gwei
     * required : true
     */
    @JSONField(name = "gas_price")
    private String gasPrice;

    /**
     * Gas limit fee
     * required : true
     */
    @JSONField(name = "gas_limit")
    private String gasLimit;

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }
}
