package com.github.hicoincom.api.bean;

/**
 * @author chainup waass
 */
public enum  ApiUri {

    /**
     * User mobile phone registration address
     */
     CREATE_USER_MOBILE ( "/user/createUser", "POST"),

    /**
     * User email (virtual account) registration
     */
     CREATE_USER_EMAIL ( "/user/registerEmail", "POST"),


    /**
     * Query user information
     */
     GET_USER_INFO ( "/user/info", "POST"),

    /**
     * 	obtain merchant's coin list
     */
     COIN_LIST ( "/user/getCoinList", "POST"),

    /**
     * Obtain the user-specified coin account
     */
     USER_SYMBOL_ACCOUNT (  "/account/getByUidAndSymbol", "POST"),

    /**
     * Obtain the balance of the merchant account
     */
     COMPANY_SYMBOL_ACCOUNT ( "/account/getCompanyBySymbol", "POST"),

    /**
     * Obtain the address of the user-specified coin account
     */
     USER_DEPOSIT_ADDRESS (  "/account/getDepositAddress", "POST"),

    /**
     * Withdrawal operation
     */
     BILLING_WITHDRAW (  "/billing/withdraw", "POST"),

    /**
     * Sync withdrawal record
     */
     SYNC_WITHDRAW (  "/billing/syncWithdrawList", "POST"),


    /**
     * Batch query withdrawal records
     */
     WITHDRAW_LIST (  "/billing/withdrawList", "POST"),

    /**
     * Sync deposit record
     */
     SYNC_DEPOSIT (  "/billing/syncDepositList", "POST"),

    /**
     * Batch query deposit records
     */
     DEPOSIT_LIST (  "/billing/depositList", "POST"),

    /**
     * Sync gas fee records
     */
    SYNC_MINER_FEE(  "/billing/syncMinerFeeList", "POST"),

    /**
     * Batch query gas fee records
     */
    MINER_FEE_LIST (  "/billing/minerFeeList", "POST"),

    /**
     * WaaS internal merchants transfers(Transfers funds between waas merchants)
     */
    ACCOUNT_TRANSFER("/account/transfer","POST") ,

    /**
     * Query transfer records
     */
    ACCOUNT_TRANSFER_LIST("/account/transferList","POST"),

    /**
     * Sync transfer records
     */
    SYNC_ACCOUNT_TRANSFER_LIST("/account/syncTransferList","POST")
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
