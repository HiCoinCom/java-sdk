package com.github.hicoincom.api.custody.impl;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.enums.ApiUri;
import com.github.hicoincom.api.bean.custody.CoinInfoArgs;
import com.github.hicoincom.api.bean.custody.CoinInfoListResult;
import com.github.hicoincom.api.custody.ICoinApi;
import com.github.hicoincom.crypto.IDataCrypto;

/**
 *   coin related api
 */
public class CoinApi extends WaasApi implements ICoinApi {
    public CoinApi(WaasConfig cfg, IDataCrypto crypto){
        super(cfg, crypto);
    }

    /**
     *  get coin list
     *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
     * @return
     */
    public CoinInfoListResult getCoinList()  {
        CoinInfoArgs args = new CoinInfoArgs();
        return this.invoke(ApiUri.COIN_LIST, args, CoinInfoListResult.class);
    }
}
