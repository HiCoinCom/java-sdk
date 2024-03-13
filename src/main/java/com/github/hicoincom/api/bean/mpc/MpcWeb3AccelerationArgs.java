package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * @description Web3 Transaction Acceleration, https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-pending
 */
public class MpcWeb3AccelerationArgs extends BaseCustodyArgs implements Serializable {

    private static final long serialVersionUID = -3803914412032960597L;
    /**
     * Web3 transaction ID
     * required : true
     */
    private Integer transId;

    /**
     * Gas fee，unit：Gwei
     * required : true
     */
    private String gasPrice;

    /**
     * Gas limit fee
     * required : true
     */
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


    public static final class MpcWeb3AccelerationArgsBuilder {
        private Integer transId;
        private String gasPrice;
        private String gasLimit;

        private MpcWeb3AccelerationArgsBuilder() {
        }

        public static MpcWeb3AccelerationArgsBuilder aMpcWeb3AccelerationArgs() {
            return new MpcWeb3AccelerationArgsBuilder();
        }

        public MpcWeb3AccelerationArgsBuilder transId(Integer transId) {
            this.transId = transId;
            return this;
        }

        public MpcWeb3AccelerationArgsBuilder gasPrice(String gasPrice) {
            this.gasPrice = gasPrice;
            return this;
        }

        public MpcWeb3AccelerationArgsBuilder gasLimit(String gasLimit) {
            this.gasLimit = gasLimit;
            return this;
        }

        public MpcWeb3AccelerationArgs build() {
            MpcWeb3AccelerationArgs mpcWeb3AccelerationArgs = new MpcWeb3AccelerationArgs();
            mpcWeb3AccelerationArgs.setTransId(transId);
            mpcWeb3AccelerationArgs.setGasPrice(gasPrice);
            mpcWeb3AccelerationArgs.setGasLimit(gasLimit);
            return mpcWeb3AccelerationArgs;
        }
    }
}
