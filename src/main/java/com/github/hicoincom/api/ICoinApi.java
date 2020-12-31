package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.CoinInfo;
import com.github.hicoincom.api.bean.Result;
import com.github.hicoincom.exception.CryptoException;

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
