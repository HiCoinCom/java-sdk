package com.chainup.waas.api;

import com.chainup.waas.WaasConfig;
import com.chainup.waas.api.bean.*;
import com.chainup.waas.crypto.IDataCrypto;
import com.chainup.waas.exception.CryptoException;

/**
 *  币种api
 */
public class CoinApi extends WaasApi implements ICoinApi{
    public CoinApi(WaasConfig cfg, IDataCrypto crypto){
        super(cfg, crypto);
    }

    /**
     *  获取币种列表
     *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
     * @return
     */
    public CoinInfoListResult getCoinList() throws CryptoException {
        CoinInfoArgs args = new CoinInfoArgs();
        return this.invoke(ApiUri.COIN_LIST, args, CoinInfoListResult.class);
    }
}
