package com.chainup.waas.api;

import com.chainup.waas.api.bean.CoinInfo;
import com.chainup.waas.api.bean.Result;
import com.chainup.waas.exception.CryptoException;

import java.util.List;

/**
 *  币种api
 */
public interface ICoinApi {
    /**
     *  获取币种列表
     *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
     * @return
     */
    Result<List<CoinInfo>> getCoinList() throws CryptoException;
}
