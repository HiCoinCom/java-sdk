package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.CoinInfoListResult;

/**
 * Cryptocurrency information related API interface
 * 
 * This interface provides methods for querying information about
 * supported cryptocurrencies.
 * 
 * @author ChainUp Custody
 */
public interface ICoinApi {

    /**
     * Get list of supported cryptocurrencies
     * 
     * Retrieves information about all cryptocurrencies supported by the platform.
     * 
     * @return CoinInfoListResult containing list of coin information
     * @see <a href="http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html">API Documentation</a>
     */
    CoinInfoListResult getCoinList();
}
