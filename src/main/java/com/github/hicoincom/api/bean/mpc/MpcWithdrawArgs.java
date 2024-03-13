package com.github.hicoincom.api.bean.mpc;

import com.github.hicoincom.api.bean.BaseCustodyArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * @description Transfer (Withdrawal) args, https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/withdraw/withdraw
 */
public class MpcWithdrawArgs extends BaseCustodyArgs implements Serializable {

    private static final long serialVersionUID = -3689408157147771205L;

    /**
     * Wallet ID
     *
     * required : true
     */
    private Integer subWalletId;

    /**
     * Unique identifier for the coin, e.g., USDTERC20
     * required: true
     */
    private String symbol;

    /**
     * Specify the transfer coin address
     * required: false
     */
    private String from;

    /**
     * Transfer address
     * required : true
     */
    private String addressTo;

    /**
     * transfer address memo, Memo type can be filled in if available, example: 123321
     * required : false
     */
    private String memo;

    /**
     * Transfer amount
     * required : true
     */
    private String amount;

    /**
     * The unique identifier for transferring coins
     * required : true
     */
    private String requestId;

    /**
     * transfer remarks
     * required : false
     */
    private String remark;

    /**
     * RSA private key signature. Parameters involved in the signature: “request_id”, “sub_wallet_id”, “symbol”, “address_to”, “amount”, “memo”.
     * For signature rules
     * signature rules: https://custodydocs-en.chainup.com/api-references/mpc-apis/co-signer/sign-verify
     *
     * required : false
     */
    private String sign;

    public Integer getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(Integer subWalletId) {
        this.subWalletId = subWalletId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public static final class MpcWithdrawArgsBuilder {
        private Integer subWalletId;
        private String symbol;
        private String from;
        private String addressTo;
        private String memo;
        private String amount;
        private String requestId;
        private String remark;
        private String sign;

        private MpcWithdrawArgsBuilder() {
        }

        public static MpcWithdrawArgsBuilder aMpcWithdrawArgs() {
            return new MpcWithdrawArgsBuilder();
        }

        public MpcWithdrawArgsBuilder subWalletId(Integer subWalletId) {
            this.subWalletId = subWalletId;
            return this;
        }

        public MpcWithdrawArgsBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public MpcWithdrawArgsBuilder from(String from) {
            this.from = from;
            return this;
        }

        public MpcWithdrawArgsBuilder addressTo(String addressTo) {
            this.addressTo = addressTo;
            return this;
        }

        public MpcWithdrawArgsBuilder memo(String memo) {
            this.memo = memo;
            return this;
        }

        public MpcWithdrawArgsBuilder amount(String amount) {
            this.amount = amount;
            return this;
        }

        public MpcWithdrawArgsBuilder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public MpcWithdrawArgsBuilder remark(String remark) {
            this.remark = remark;
            return this;
        }

        public MpcWithdrawArgsBuilder sign(String sign) {
            this.sign = sign;
            return this;
        }

        public MpcWithdrawArgs build() {
            MpcWithdrawArgs mpcWithdrawArgs = new MpcWithdrawArgs();
            mpcWithdrawArgs.amount = this.amount;
            mpcWithdrawArgs.addressTo = this.addressTo;
            mpcWithdrawArgs.sign = this.sign;
            mpcWithdrawArgs.from = this.from;
            mpcWithdrawArgs.memo = this.memo;
            mpcWithdrawArgs.requestId = this.requestId;
            mpcWithdrawArgs.remark = this.remark;
            mpcWithdrawArgs.subWalletId = this.subWalletId;
            mpcWithdrawArgs.symbol = this.symbol;
            return mpcWithdrawArgs;
        }
    }
}
