package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.CoinInfoListResult;

/**
 * @author ChainUp Custody
 * coin related api
 *
 */
public interface ICoinApi {

    /**
     * get coin list
     * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
     */
    CoinInfoListResult getCoinList();
}
