package com.github.hicoincom.api.mpc;


import com.github.hicoincom.api.bean.mpc.AutoCollectRecordResult;
import com.github.hicoincom.api.bean.mpc.AutoCollectWalletsResult;
import com.github.hicoincom.api.bean.mpc.SetAutoCollectSymbolResult;

/**
 * @author ChainUp Custody
 */
public interface IAutoSweepApi {

    /**
     * Get Auto-Sweep Wallets
     * Retrieve the auto-sweep wallet and auto fueling wallet for a specific coin.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/consolidation/consolidation-subwallet
     *
     * @param symbol required: true
     *               Unique identifier for the coin, e.g.：USDTERC20
     */
    AutoCollectWalletsResult autoCollectSubWallets(String symbol);


    /**
     * Configure Auto-Sweep for Coin
     *
     * @param symbol       required: true
     *                     Unique identifier for the coin, e.g.：USDTERC20
     * @param collectMin   required: true
     *                     Minimum amount for auto-sweep; up to 6 decimal places, not exceeding 9999999999999999
     * @param fuelingLimit required: true
     *                     Maximum miner fee amount for auto-sweep; up to 6 decimal places, not exceeding 9999999999999999
     */
    SetAutoCollectSymbolResult setAutoCollectSymbol(String symbol, String collectMin, String fuelingLimit);

    /**
     * Sync Auto Sweeping Records
     *
     * @param maxId required: true, default:0
     *              Starting ID for sweeping records
     */
    AutoCollectRecordResult syncAutoCollectRecords(Integer maxId);

}
