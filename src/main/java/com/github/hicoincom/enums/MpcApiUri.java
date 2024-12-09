package com.github.hicoincom.enums;


import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;

/**
 * @author Chainup Custody
 */
public enum MpcApiUri {

    /**
     * Get Supported Main Chains
     * Get the supported MPC main chain coins and the MPC main chain coins opened in ChainUp Custody.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/wallet/open-coin
     */
    SUPPORT_MAIN_CHAIN("/api/mpc/wallet/open_coin", HttpGet.METHOD_NAME),

    /**
     * Get MPC Workspace Coin Details
     * Get the details of MPC workspace's main chain coins and tokens supported
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/wallet/coin-list
     */
    COIN_DETAILS("/api/mpc/coin_list", HttpGet.METHOD_NAME),

    /**
     * Get Latest Block Height
     * Get the latest block height of the specified main chain.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/wallet/chain-height
     */
    CHAIN_HEIGHT("/api/mpc/chain_height", HttpGet.METHOD_NAME),

    /**
     * Create wallet
     * Pass in the specified wallet name to create a new wallet for the main wallet
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-create
     */
    CREATE_WALLET("/api/mpc/sub_wallet/create", HttpPost.METHOD_NAME),

    /**
     * Create Wallet Address
     * Create an address for a specified wallet and coin; the same wallet can have multiple addresses, and Memo types may create multiple memos.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-create-address
     */
    CREATE_WALLET_ADDRESS("/api/mpc/sub_wallet/create/address", HttpPost.METHOD_NAME),

    /**
     * Query Wallet Address
     * List of wallet addresses
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-get-address
     */
    GET_ADDRESS_LIST("/api/mpc/sub_wallet/get/address/list", HttpPost.METHOD_NAME),

    /**
     * Get Wallet Assets
     * Get the account assets under the specified wallet and coin.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-assets
     */
    GET_WALLET_ASSETS("/api/mpc/sub_wallet/assets", HttpGet.METHOD_NAME),

    /**
     * Modify the Wallet Display Status
     * The display of the specified wallet in the App and web portal is essential for initiating transactions.
     * If it is not displayed, transactions cannot be initiated in the app.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-show-status
     */
    CHANGE_SHOW_STATUS("/api/mpc/sub_wallet/change_show_status", HttpPost.METHOD_NAME),

    /**
     * Verify Address Information
     * Input a specific address and get the response of the corresponding custody user and currency information
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-address-info
     */
    ADDRESS_INFO("/api/mpc/sub_wallet/address/info", HttpGet.METHOD_NAME),

    /**
     * Transfer (Withdrawal)
     * Initiate a Transfer
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/withdraw/withdraw
     */
    BILLING_WITHDRAW("/api/mpc/billing/withdraw", HttpPost.METHOD_NAME),

    /**
     * Get Transfer(withdraw) Records
     * Get all wallet transfer records under the workspace, and return up to 100 records
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/withdraw/withdraw-list
     */
    WITHDRAW_RECORDS("/api/mpc/billing/withdraw_list", HttpGet.METHOD_NAME),

    /**
     * Synchronize Transfer(withdraw) Records
     * Get all wallet transfer records under the workspace, and return up to 100 records
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/withdraw/withdraw-sync-list
     */
    SYNC_WITHDRAW_RECORDS("/api/mpc/billing/sync_withdraw_list", HttpGet.METHOD_NAME),

    /**
     * Get Transfer(deposit) Records
     * Get all wallet receiving records under the workspace, and return up to 100 records
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/deposit/deposit-list
     */
    DEPOSIT_RECORDS("/api/mpc/billing/deposit_list", HttpGet.METHOD_NAME),

    /**
     * Create Web3 Transaction
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-create
     */
    CREATE_WEB3_TRANSACTION("/api/mpc/web3/trans/create", HttpPost.METHOD_NAME),

    /**
     * Web3 Transaction Acceleration
     * When a transfer is signed but has not been confirmed on the blockchain for a long time due to insufficient fees,
     * it can be accelerated by specifying a higher fee.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-pending#response-data-parameters
     */
    WEB3_TRANS_ACCELERATION("/api/mpc/web3/pending", HttpPost.METHOD_NAME),

    /**
     * Get Web3 Transaction Records
     * Get all Web3 transaction records under a wallet, maximum of 100 records.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-record-list
     */
    WEB3_TRANS_RECORDS("/api/mpc/web3/trans_list", HttpGet.METHOD_NAME),

    /**
     * Sync Web3 Transaction Records
     * Get all Web3 transaction records under a wallet, maximum of 100 records.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-record-sync-list
     */
    SYNC_WEB3_RECORDS("/api/mpc/web3/sync_trans_list", HttpGet.METHOD_NAME),

    /**
     * Get Auto-Sweep Wallets
     * Retrieve the auto-sweep wallet and auto fueling wallet for a specific coin.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/consolidation/consolidation-subwallet
     */
    AUTO_COLLECT_WALLETS("/api/mpc/auto_collect/sub_wallets", HttpGet.METHOD_NAME),

    /**
     * Configure Auto-Sweep for Coin
     * Set the minimum auto-sweep amount and the maximum miner fee for refueling.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/consolidation/consolidation-symbol-set
     */
    SET_AUTO_COLLECT_SYMBOL("/api/mpc/billing/auto_collect/symbol/set", HttpPost.METHOD_NAME),

    /**
     * Sync Auto Sweeping Records
     * Retrieve up to 100 sweeping records for all wallets under a workspace.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/consolidation/consolidation-sync-list
     */
    SYNC_AUTO_SWEEP_RECORDS("/api/mpc/billing/sync_auto_collect_list", HttpGet.METHOD_NAME),

    ;

    private String value;
    private String method;

    private MpcApiUri(String value, String method) {
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
