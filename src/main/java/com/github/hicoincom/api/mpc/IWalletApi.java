package com.github.hicoincom.api.mpc;


import com.github.hicoincom.api.bean.mpc.*;
import com.github.hicoincom.enums.AppShowStatus;

import java.util.List;

/**
 * @author ChainUp Custody
 */
public interface IWalletApi {

    /**
     * Create wallet
     * Pass in the specified wallet name to create a new wallet for the main wallet
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-create
     *
     * @param walletName required: true
     *                   wallet name
     * @param showStatus required: false
     *                   Whether to display the wallet on the app and web after creation, 1 display, 2 not display; Default not displayed
     */
    WalletResult createWallet(String walletName, AppShowStatus showStatus);


    /**
     * Create Wallet Address
     * Create an address for a specified wallet and coin; the same wallet can have multiple addresses, and Memo types may create multiple memos.
     * https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-create-address
     *
     * @param walletId required: true
     *                 wallet ID
     * @param symbol   required: true
     *                 Unique identifier for the coin, e.g.：ETH
     */
    WalletAddressResult createWalletAddress(Integer walletId, String symbol);


    /**
     * Query Wallet Address
     * List of wallet addresses
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-get-address
     *
     * @param walletId required: true
     *                 wallet ID
     * @param symbol   required: true
     *                 Unique identifier for the coin, e.g.：ETH
     * @param maxId    required: true
     *                 Starting address id, default is 0
     */
    WalletAddressListResult queryWalletAddress(Integer walletId, String symbol, Integer maxId);


    /**
     * Get Wallet Assets
     * Get the account assets under the specified wallet and coin.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-assets
     *
     * @param walletId required: true
     *                 wallet ID
     * @param symbol   required: true
     *                 Unique identifier for the coin, used for transfers, e.g.：ETH
     */
    WalletAssetsResult getWalletAssets(Integer walletId, String symbol);

    /**
     * Modify the Wallet Display Status
     * The display of the specified wallet in the App and web portal is essential for initiating transactions. If it is not displayed, transactions cannot be initiated in the app.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-show-status
     *
     * @param walletIds   required: true
     *                    A string of multiple wallet ids, separated by commas
     * @param showStatus, required: true
     *                    1 show ,2 don’t show, default: 2
     */
    boolean changeWalletShowStatus(List<Integer> walletIds, AppShowStatus showStatus);

    /**
     * Address Information
     * Input a specific address and get the response of the corresponding custody user and currency information
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/sub-wallet/subwallet-address-info
     *
     * @param address required: true
     *                Any address
     * @param memo    required: false
     *                If it’s a Memo type, input the memo
     */
    WalletAddressInfoResult walletAddressInfo(String address, String memo);


}
