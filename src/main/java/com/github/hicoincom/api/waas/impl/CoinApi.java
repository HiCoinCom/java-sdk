package com.github.hicoincom.api.waas.impl;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.enums.ApiUri;
import com.github.hicoincom.api.bean.waas.CoinInfoArgs;
import com.github.hicoincom.api.bean.waas.CoinInfoListResult;
import com.github.hicoincom.api.waas.ICoinApi;
import com.github.hicoincom.crypto.IDataCrypto;

/**
 * @author ChainUp Custody
 * coin related api
 */
public class CoinApi extends WaasApi implements ICoinApi {

    public CoinApi(WaasConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public CoinInfoListResult getCoinList() {
        CoinInfoArgs args = new CoinInfoArgs();
        return this.invoke(ApiUri.COIN_LIST, args, CoinInfoListResult.class);
    }
}
