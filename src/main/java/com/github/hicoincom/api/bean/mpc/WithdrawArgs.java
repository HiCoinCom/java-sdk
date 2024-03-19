package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * @description Transfer (Withdrawal) args, https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/withdraw/withdraw
 */
public class WithdrawArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = -3689408157147771205L;

    /**
     * Wallet ID
     * required : true
     */
    @JSONField(name = "sub_wallet_id")
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
    @JSONField(name = "address_to")
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
    @JSONField(name = "request_id")
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
}
