package com.github.hicoincom.api.mpc;

import com.github.hicoincom.api.bean.mpc.GetLastBlockHeightResult;
import com.github.hicoincom.api.bean.mpc.CoinDetailsResult;
import com.github.hicoincom.api.bean.mpc.SupportMainChainResult;

/**
 * @author ChainUp Custody
 */
public interface IWorkSpaceApi {


    /**
     * Get Supported Main Chains
     * Get the supported MPC main chain coins and the MPC main chain coins opened in ChainUp Custody.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/wallet/open-coin
     * @return SupportMainChainResult
     */
    SupportMainChainResult getSupportMainChain();

    /**
     * Get MPC Workspace Coin Details
     * Get the details of MPC workspace's main chain coins and tokens supported
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/wallet/coin-list
     *
     * @param symbol     required: false
     *                   Unique identifier for the coin, used for transfers, e.g.：USDTERC20
     * @param baseSymbol required: false
     *                   Main chain coins, Unique identifier for the coin, used for transfers, e.g.：ETH
     * @param openChain  required: false
     *                   Main chain coin, default to getting all, true to get opened coins, false to get unopened coins
     * @return CoinDetailsResult
     */
    CoinDetailsResult getCoinDetails(String symbol, String baseSymbol, Boolean openChain);


    /**
     * Get Latest Block Height
     * Get the latest block height of the specified main chain.
     * @param baseSymbol required: true
     *                   Main chain coins, Unique identifier for the coin, e.g.：ETH
     *
     * @return GetLastBlockHeightResult
     */
    GetLastBlockHeightResult getLastBlockHeight(String baseSymbol);

}
