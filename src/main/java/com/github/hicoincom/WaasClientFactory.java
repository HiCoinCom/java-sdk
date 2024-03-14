package com.github.hicoincom;

import com.github.hicoincom.api.custody.impl.*;
import com.github.hicoincom.api.mpc.impl.*;
import com.github.hicoincom.crypto.DataCrypto;
import com.github.hicoincom.crypto.IDataCrypto;

public class WaasClientFactory {
    public static WaasClient CreateClient(WaasConfig cfg) {
        DataCrypto crypto = new DataCrypto(cfg.getUserPrivateKey(), cfg.getWaasPublickKey());
        return CreateClient(cfg, crypto);
    }

    public static WaasClient CreateClient(WaasConfig cfg, IDataCrypto crypto) {
       return WaasClient.WaasClientBuilder
                .aWaasClient()
                .accountApi(new AccountApi(cfg, crypto))
                .asyncNotifyApi(new AsyncNotifyApi(cfg, crypto))
                .billingApi(new BillingApi(cfg, crypto))
                .coinApi(new CoinApi(cfg, crypto))
                .userApi(new UserApi(cfg, crypto))
                .transferApi(new TransferApi(cfg, crypto))
                .build();
    }

    public static MpcClient CreateMpcClient(CustodyMpcConfig cfg) {
        DataCrypto crypto = new DataCrypto(cfg.getUserPrivateKey(), cfg.getCustodyPublicKey());
        return CreateMpcClient(cfg, crypto);
    }

    public static MpcClient CreateMpcClient(CustodyMpcConfig cfg, IDataCrypto crypto) {
        return MpcClient.MpcClientBuilder
                .aMpcClient()
                .workSpaceApi(new WorkSpaceApi(crypto, cfg))
                .walletApi(new WalletApi(crypto, cfg))
                .depositApi(new DepositApi(crypto, cfg))
                .withdrawApi(new WithdrawApi(crypto, cfg))
                .web3Api(new Web3Api(crypto, cfg))
                .autoSweepApi(new AutoSweepApi(crypto, cfg))
                .build();
    }

}
