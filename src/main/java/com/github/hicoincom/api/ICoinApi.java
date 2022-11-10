package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.CoinInfoListResult;
import com.github.hicoincom.exception.CryptoException;

import java.util.List;

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
