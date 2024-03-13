package com.github.hicoincom.api.custody;

import com.github.hicoincom.api.bean.custody.CoinInfoListResult;

/**
 *  coin related api
 */
public interface ICoinApi {
    /**
     *  get coin list
     *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
     * @return
     */
    CoinInfoListResult getCoinList() ;
}
