package com.chainup.waas.constant;

/**
 * @author chainup waas
 */
public class WaasUrlConstant {

    /**
     * 用户手机注册地址
     */
    public static final String CREATE_USER_MOBILE = "/api/v2/user/createUser";

    /**
     * 用户邮箱（虚拟账号）注册
     */
    public static final String CREATE_USER_EMAIL = "/api/v2/user/registerEmail";


    /**
     * 查询用户信息
     */
    public static final String GET_USER_INFO = "/api/v2/user/info";

    /**
     * 	获取商户的币种列表
     */
    public static final String COIN_LIST = "/api/v2/user/getCoinList";

    /**
     * 获取用户指定币账户
     */
    public static final String USER_SYMBOL_ACCOUNT =  "/api/v2/account/getByUidAndSymbol";

    /**
     * 获取商户归集账户余额
     */
    public static final String COMPANY_SYMBOL_ACCOUNT = "/api/v2/account/getCompanyBySymbol";

    /**
     * 获取用户指定币账户地址
     */
    public static final String USER_DEPOSIT_ADDRESS =  "/api/v2/account/getDepositAddress";

    /**
     * 提现操作
     */
    public static final String BILLING_WITHDRAW =  "/api/v2/billing/withdraw";

    /**
     * 同步提现记录
     */
    public static final String SYNC_WITHDRAW =  "/api/v2/billing/syncWithdrawList";


    /**
     * 批量获取提现记录
     */
    public static final String WITHDRAW_LIST =  "/api/v2/billing/withdrawList";

    /**
     * 同步充值记录
     */
    public static final String SYNC_DEPOSIT =  "/api/v2/billing/syncDepositList";

    /**
     * 批量获取充值记录
     */
    public static final String DEPOSIT_LIST =  "/api/v2/billing/depositList";


}
