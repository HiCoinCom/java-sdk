package com.github.hicoincom.enums;


import org.apache.hc.client5.http.classic.methods.HttpPost;

/**
 * @author chainup waas
 */
public enum ApiUri {

    /**
     * User mobile phone registration address
     */
    CREATE_USER_MOBILE("/user/createUser", HttpPost.METHOD_NAME),

    /**
     * User email (virtual account) registration
     */
    CREATE_USER_EMAIL("/user/registerEmail", HttpPost.METHOD_NAME),


    /**
     * Query user information
     */
    GET_USER_INFO("/user/info", HttpPost.METHOD_NAME),

    /**
     * Query user list
     */
    GET_USER_LIST("/user/syncList", HttpPost.METHOD_NAME),

    /**
     * obtain merchant's coin list
     */
    COIN_LIST("/user/getCoinList", HttpPost.METHOD_NAME),

    /**
     * Obtain the user-specified coin account
     */
    USER_SYMBOL_ACCOUNT("/account/getByUidAndSymbol", HttpPost.METHOD_NAME),

    /**
     * Obtain the balance of the merchant account
     */
    COMPANY_SYMBOL_ACCOUNT("/account/getCompanyBySymbol", HttpPost.METHOD_NAME),

    /**
     * Obtain the address of the user-specified coin account
     */
    USER_DEPOSIT_ADDRESS("/account/getDepositAddress", HttpPost.METHOD_NAME),

    /**
     * Deposit address list
     */
    USER_DEPOSIT_ADDRESS_LIST("/address/syncList", HttpPost.METHOD_NAME),

    /**
     * Input a specific address and get the response of the corresponding custody user and currency information
     */
    USER_DEPOSIT_ADDRESS_INFO("/account/getDepositAddressInfo", HttpPost.METHOD_NAME),

    /**
     * Withdrawal operation
     */
    BILLING_WITHDRAW("/billing/withdraw", HttpPost.METHOD_NAME),

    /**
     * Sync withdrawal record
     */
    SYNC_WITHDRAW("/billing/syncWithdrawList", HttpPost.METHOD_NAME),


    /**
     * Batch query withdrawal records
     */
    WITHDRAW_LIST("/billing/withdrawList", HttpPost.METHOD_NAME),

    /**
     * Sync deposit record
     */
    SYNC_DEPOSIT("/billing/syncDepositList", HttpPost.METHOD_NAME),

    /**
     * Batch query deposit records
     */
    DEPOSIT_LIST("/billing/depositList", HttpPost.METHOD_NAME),

    /**
     * Sync gas fee records
     */
    SYNC_MINER_FEE("/billing/syncMinerFeeList", HttpPost.METHOD_NAME),

    /**
     * Batch query gas fee records
     */
    MINER_FEE_LIST("/billing/minerFeeList", HttpPost.METHOD_NAME),

    /**
     * WaaS internal merchants transfers(Transfers funds between waas merchants)
     */
    ACCOUNT_TRANSFER("/account/transfer", HttpPost.METHOD_NAME),

    /**
     * Query transfer records
     */
    ACCOUNT_TRANSFER_LIST("/account/transferList", HttpPost.METHOD_NAME),

    /**
     * Sync transfer records
     */
    SYNC_ACCOUNT_TRANSFER_LIST("/account/syncTransferList", HttpPost.METHOD_NAME);

    private String value;
    private String method;

    private ApiUri(String value, String method) {
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
