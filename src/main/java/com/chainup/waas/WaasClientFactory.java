package com.chainup.waas;

import com.chainup.waas.api.*;
import com.chainup.waas.crypto.DataCrypto;
import com.chainup.waas.crypto.IDataCrypto;

public class WaasClientFactory {
    public static WaasClient  CreateClient(WaasConfig cfg){
        DataCrypto crypto = new DataCrypto(cfg.getUserPrivateKey(), cfg.getWaasPublickKey());
        return CreateClient(cfg, crypto);
    }

    public static WaasClient  CreateClient(WaasConfig cfg, IDataCrypto crypto){
        WaasClient client = new WaasClient();
        client.setAccountApi(new AccountApi(cfg, crypto));
        client.setAsyncNotifyApi(new AsyncNotifyApi(cfg, crypto));
        client.setBillingApi(new BillingApi(cfg, crypto));
        client.setCoinApi(new CoinApi(cfg, crypto));
        client.setUserApi(new UserApi(cfg, crypto));
        return client;
    }
}
