package com.github.hicoincom.api.bean.mpc;

import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class GetMpcDepositRecordArgs extends BaseCustodyArgs implements Serializable {

    private static final long serialVersionUID = 4874475032767801784L;

    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }


    public static final class GetMpcDepositRecordArgsBuilder {
        private String ids;

        private GetMpcDepositRecordArgsBuilder() {
        }

        public static GetMpcDepositRecordArgsBuilder aGetMpcDepositRecordArgs() {
            return new GetMpcDepositRecordArgsBuilder();
        }

        public GetMpcDepositRecordArgsBuilder ids(String ids) {
            this.ids = ids;
            return this;
        }

        public GetMpcDepositRecordArgs build() {
            GetMpcDepositRecordArgs getMpcDepositRecordArgs = new GetMpcDepositRecordArgs();
            getMpcDepositRecordArgs.setIds(ids);
            return getMpcDepositRecordArgs;
        }
    }
}
