package com.github.hicoincom.api.bean.mpc;

import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class MpcSyncTransactionRecordArgs extends BaseCustodyArgs implements Serializable  {


    private static final long serialVersionUID = 1013291748580371783L;

    /**
     * Custody withdraw record id
     */
    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }


    public static final class MpcSyncTransactionRecordArgsBuilder {
        private Integer maxId;

        private MpcSyncTransactionRecordArgsBuilder() {
        }

        public static MpcSyncTransactionRecordArgsBuilder aMpcSyncTransactionRecordArgs() {
            return new MpcSyncTransactionRecordArgsBuilder();
        }

        public MpcSyncTransactionRecordArgsBuilder maxId(Integer maxId) {
            this.maxId = maxId;
            return this;
        }

        public MpcSyncTransactionRecordArgs build() {
            MpcSyncTransactionRecordArgs mpcSyncTransactionRecordArgs = new MpcSyncTransactionRecordArgs();
            mpcSyncTransactionRecordArgs.setMaxId(maxId);
            return mpcSyncTransactionRecordArgs;
        }
    }
}
