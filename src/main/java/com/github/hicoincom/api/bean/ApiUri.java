package com.github.hicoincom.api.bean;

/**
 * @author chainup waass
 */
public enum  ApiUri {

    /**
     * 用户手机注册地址
     */
     CREATE_USER_MOBILE ( "/user/createUser", "POST"),

    /**
     * 用户邮箱（虚拟账号）注册
     */
     CREATE_USER_EMAIL ( "/user/registerEmail", "POST"),


    /**
     * 查询用户信息
     */
     GET_USER_INFO ( "/user/info", "POST"),

    /**
     * 	获取商户的币种列表
     */
     COIN_LIST ( "/user/getCoinList", "POST"),

    /**
     * 获取用户指定币账户
     */
     USER_SYMBOL_ACCOUNT (  "/account/getByUidAndSymbol", "POST"),

    /**
     * 获取商户归集账户余额
     */
     COMPANY_SYMBOL_ACCOUNT ( "/account/getCompanyBySymbol", "POST"),

    /**
     * 获取用户指定币账户地址
     */
     USER_DEPOSIT_ADDRESS (  "/account/getDepositAddress", "POST"),

    /**
     * 提现操作
     */
     BILLING_WITHDRAW (  "/billing/withdraw", "POST"),

    /**
     * 同步提现记录
     */
     SYNC_WITHDRAW (  "/billing/syncWithdrawList", "POST"),


    /**
     * 批量获取提现记录
     */
     WITHDRAW_LIST (  "/billing/withdrawList", "POST"),

    /**
     * 同步充值记录
     */
     SYNC_DEPOSIT (  "/billing/syncDepositList", "POST"),

    /**
     * 批量获取充值记录
     */
     DEPOSIT_LIST (  "/billing/depositList", "POST"),

    /**
     * 同步矿工费记录
     */
    SYNC_MINER_FEE(  "/billing/syncMinerFeeList", "POST"),

    /**
     * 批量获取矿工费记录
     */
    MINER_FEE_LIST (  "/billing/minerFeeList", "POST"),

    ;

     private String value;
     private String method;

     private ApiUri(String value, String method){
         this.value = value;
         this.method = method;
     }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
