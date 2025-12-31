package com.github.hicoincom;

import com.github.hicoincom.api.waas.impl.*;
import com.github.hicoincom.api.mpc.impl.*;
import com.github.hicoincom.crypto.DataCrypto;
import com.github.hicoincom.crypto.IDataCrypto;

/**
 * Factory class for creating WaaS and MPC client instances
 * 
 * This factory provides convenient methods to create fully configured
 * client instances with all necessary API implementations and encryption
 * settings.
 * 
 * @author ChainUp Custody
 */
public class WaasClientFactory {

    /**
     * Create a WaaS client with default crypto implementation
     * 
     * @param cfg WaasConfig containing API credentials and settings
     * @return WaasClient fully configured client instance
     */
    public static WaasClient CreateClient(WaasConfig cfg) {
        DataCrypto crypto = new DataCrypto(cfg.getUserPrivateKey(), cfg.getWaasPublickKey());
        return CreateClient(cfg, crypto);
    }

    /**
     * Create a WaaS client with custom crypto implementation
     * 
     * @param cfg WaasConfig containing API credentials and settings
     * @param crypto IDataCrypto custom encryption/decryption implementation
     * @return WaasClient fully configured client instance
     */
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
        DataCrypto crypto = new DataCrypto(cfg.getUserPrivateKey(), cfg.getWaasPublickKey(), cfg.getSignPrivateKey());
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
                .tronBuyResourceApi(new TronBuyResourceApi(cfg, crypto))
                .build();
    }

}
