package com.github.hicoincom;

import com.github.hicoincom.api.waas.impl.*;
import com.github.hicoincom.api.mpc.impl.*;
import com.github.hicoincom.crypto.DataCrypto;
import com.github.hicoincom.crypto.IDataCrypto;

/**
 * @author ChainUp Custody
 */
public class WaasClientFactory {

    public static WaasClient CreateClient(WaasConfig cfg) {
        DataCrypto crypto = new DataCrypto(cfg.getUserPrivateKey(), cfg.getWaasPublickKey());
        return CreateClient(cfg, crypto);
    }

    public static WaasClient CreateClient(WaasConfig cfg, IDataCrypto crypto) {
        return WaasClient.WaasClientBuilder.builder()
                .accountApi(new AccountApi(cfg, crypto))
                .asyncNotifyApi(new AsyncNotifyApi(cfg, crypto))
                .billingApi(new BillingApi(cfg, crypto))
                .coinApi(new CoinApi(cfg, crypto))
                .userApi(new UserApi(cfg, crypto))
                .transferApi(new TransferApi(cfg, crypto))
                .build();
    }

    public static MpcClient CreateMpcClient(MpcConfig cfg) {
        DataCrypto crypto = new DataCrypto(cfg.getUserPrivateKey(), cfg.getWaasPublickKey());
        return CreateMpcClient(cfg, crypto);
    }

    public static MpcClient CreateMpcClient(MpcConfig cfg, IDataCrypto crypto) {
        return MpcClient.MpcClientBuilder.builder()
                .workSpaceApi(new WorkSpaceApi(cfg, crypto))
                .walletApi(new WalletApi(cfg, crypto))
                .depositApi(new DepositApi(cfg, crypto))
                .withdrawApi(new WithdrawApi(cfg, crypto))
                .web3Api(new Web3Api(cfg, crypto))
                .autoSweepApi(new AutoSweepApi(cfg, crypto))
                .notifyApi(new NotifyApi(cfg, crypto))
                .build();
    }

}
