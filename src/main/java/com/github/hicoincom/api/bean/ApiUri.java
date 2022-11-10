package com.github.hicoincom.api.bean;

/**
 * @author chainup waass
 */
public enum  ApiUri {

    /**
     * User's mobile phone registration address
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
     * 	Obtain the currency list of the merchant
     */
     COIN_LIST ( "/user/getCoinList", "POST"),

    /**
     * Obtain the user's specified currency account
     */
     USER_SYMBOL_ACCOUNT (  "/account/getByUidAndSymbol", "POST"),

    /**
     * Obtain the balance of merchant collection account
     */
     COMPANY_SYMBOL_ACCOUNT ( "/account/getCompanyBySymbol", "POST"),

    /**
     * Obtain the account address in the currency specified by the user
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
     * Batch access to withdrawal records
     */
     WITHDRAW_LIST (  "/billing/withdrawList", "POST"),

    /**
     * Sync recharge record
     */
     SYNC_DEPOSIT (  "/billing/syncDepositList", "POST"),

    /**
     * Obtain recharge records in batches
     */
     DEPOSIT_LIST (  "/billing/depositList", "POST"),

    /**
     * Sync miner fee records
     */
    SYNC_MINER_FEE(  "/billing/syncMinerFeeList", "POST"),

    /**
     * Get miner fee records in batches
     */
    MINER_FEE_LIST (  "/billing/minerFeeList", "POST"),

    /**
     * WaaS internal merchants transfer money to each other
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
