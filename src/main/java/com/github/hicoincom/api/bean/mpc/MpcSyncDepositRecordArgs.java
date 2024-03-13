package com.github.hicoincom.api.bean.mpc;

import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class MpcSyncDepositRecordArgs extends BaseCustodyArgs implements Serializable  {


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


    public static final class MpcSyncDepositRecordArgsBuilder {
        private Integer maxId;

        private MpcSyncDepositRecordArgsBuilder() {
        }

        public static MpcSyncDepositRecordArgsBuilder aMpcSyncDepositRecordArgs() {
            return new MpcSyncDepositRecordArgsBuilder();
        }

        public MpcSyncDepositRecordArgsBuilder maxId(Integer maxId) {
            this.maxId = maxId;
            return this;
        }

        public MpcSyncDepositRecordArgs build() {
            MpcSyncDepositRecordArgs mpcSyncDepositRecordArgs = new MpcSyncDepositRecordArgs();
            mpcSyncDepositRecordArgs.setMaxId(maxId);
            return mpcSyncDepositRecordArgs;
        }
    }
}
