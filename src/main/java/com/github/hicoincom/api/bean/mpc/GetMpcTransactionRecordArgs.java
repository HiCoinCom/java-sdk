package com.github.hicoincom.api.bean.mpc;



import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class GetMpcTransactionRecordArgs extends BaseCustodyArgs implements Serializable {

    private static final long serialVersionUID = 4874475032767801784L;

    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }


    public static final class GetMpcTransactionRecordArgsBuilder {
        private String ids;

        private GetMpcTransactionRecordArgsBuilder() {
        }

        public static GetMpcTransactionRecordArgsBuilder aGetMpcTransactionRecordArgs() {
            return new GetMpcTransactionRecordArgsBuilder();
        }

        public GetMpcTransactionRecordArgsBuilder ids(String ids) {
            this.ids = ids;
            return this;
        }

        public GetMpcTransactionRecordArgs build() {
            GetMpcTransactionRecordArgs getMpcTransactionRecordArgs = new GetMpcTransactionRecordArgs();
            getMpcTransactionRecordArgs.setIds(ids);
            return getMpcTransactionRecordArgs;
        }
    }
}
