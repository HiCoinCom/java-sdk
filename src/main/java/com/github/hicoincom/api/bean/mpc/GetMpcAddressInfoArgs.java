package com.github.hicoincom.api.bean.mpc;


import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class GetMpcAddressInfoArgs extends BaseCustodyArgs implements Serializable  {

    private static final long serialVersionUID = 2018358055861584592L;

    private String address;

    private String memo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }


    public static final class GetMpcAddressInfoArgsBuilder {
        private String address;
        private String memo;

        private GetMpcAddressInfoArgsBuilder() {
        }

        public static GetMpcAddressInfoArgsBuilder aGetMpcAddressInfoArgs() {
            return new GetMpcAddressInfoArgsBuilder();
        }

        public GetMpcAddressInfoArgsBuilder address(String address) {
            this.address = address;
            return this;
        }

        public GetMpcAddressInfoArgsBuilder memo(String memo) {
            this.memo = memo;
            return this;
        }

        public GetMpcAddressInfoArgs build() {
            GetMpcAddressInfoArgs getMpcAddressInfoArgs = new GetMpcAddressInfoArgs();
            getMpcAddressInfoArgs.setAddress(address);
            getMpcAddressInfoArgs.setMemo(memo);
            return getMpcAddressInfoArgs;
        }
    }
}
