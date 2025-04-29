package com.github.hicoincom;

import com.github.hicoincom.api.mpc.*;

/**
 * @author ChainUp Custody
 */
public class MpcClient {

    private IWorkSpaceApi workSpaceApi;

    private IWalletApi walletApi;

    private IDepositApi depositApi;

    private IWithdrawApi withdrawApi;

    private IWeb3Api web3Api;

    private IAutoSweepApi autoSweepApi;

    private INotifyApi notifyApi;

    private ITronBuyResourceApi tronBuyResourceApi;


    public IWorkSpaceApi getWorkSpaceApi() {
        return workSpaceApi;
    }

    public void setWorkSpaceApi(IWorkSpaceApi workSpaceApi) {
        this.workSpaceApi = workSpaceApi;
    }

    public IWalletApi getWalletApi() {
        return walletApi;
    }

    public void setWalletApi(IWalletApi walletApi) {
        this.walletApi = walletApi;
    }

    public IDepositApi getDepositApi() {
        return depositApi;
    }

    public void setDepositApi(IDepositApi depositApi) {
        this.depositApi = depositApi;
    }

    public IWithdrawApi getWithdrawApi() {
        return withdrawApi;
    }

    public void setWithdrawApi(IWithdrawApi withdrawApi) {
        this.withdrawApi = withdrawApi;
    }

    public IWeb3Api getWeb3Api() {
        return web3Api;
    }

    public void setWeb3Api(IWeb3Api web3Api) {
        this.web3Api = web3Api;
    }

    public IAutoSweepApi getAutoSweepApi() {
        return autoSweepApi;
    }

    public void setAutoSweepApi(IAutoSweepApi autoSweepApi) {
        this.autoSweepApi = autoSweepApi;
    }

    public INotifyApi getNotifyApi() {
        return notifyApi;
    }

    public void setNotifyApi(INotifyApi notifyApi) {
        this.notifyApi = notifyApi;
    }

    public ITronBuyResourceApi getTronBuyResourceApi() {
        return tronBuyResourceApi;
    }

    public void setTronBuyResourceApi(ITronBuyResourceApi tronBuyResourceApi) {
        this.tronBuyResourceApi = tronBuyResourceApi;
    }

    public static final class MpcClientBuilder {
        private IWorkSpaceApi workSpaceApi;
        private IWalletApi walletApi;
        private IDepositApi depositApi;
        private IWithdrawApi withdrawApi;
        private IWeb3Api web3Api;
        private IAutoSweepApi autoSweepApi;
        private INotifyApi notifyApi;
        private ITronBuyResourceApi tronBuyResourceApi;

        private MpcClientBuilder() {
        }

        public static MpcClientBuilder builder() {
            return new MpcClientBuilder();
        }

        public MpcClientBuilder workSpaceApi(IWorkSpaceApi workSpaceApi) {
            this.workSpaceApi = workSpaceApi;
            return this;
        }

        public MpcClientBuilder walletApi(IWalletApi walletApi) {
            this.walletApi = walletApi;
            return this;
        }

        public MpcClientBuilder depositApi(IDepositApi depositApi) {
            this.depositApi = depositApi;
            return this;
        }

        public MpcClientBuilder withdrawApi(IWithdrawApi withdrawApi) {
            this.withdrawApi = withdrawApi;
            return this;
        }

        public MpcClientBuilder web3Api(IWeb3Api web3Api) {
            this.web3Api = web3Api;
            return this;
        }

        public MpcClientBuilder autoSweepApi(IAutoSweepApi autoSweepApi) {
            this.autoSweepApi = autoSweepApi;
            return this;
        }

        public MpcClientBuilder notifyApi(INotifyApi notifyApi) {
            this.notifyApi = notifyApi;
            return this;
        }

        public MpcClientBuilder tronBuyResourceApi(ITronBuyResourceApi tronBuyResourceApi) {
            this.tronBuyResourceApi = tronBuyResourceApi;
            return this;
        }


        public MpcClient build() {
            MpcClient mpcClient = new MpcClient();
            mpcClient.setWorkSpaceApi(workSpaceApi);
            mpcClient.setWalletApi(walletApi);
            mpcClient.setDepositApi(depositApi);
            mpcClient.setWithdrawApi(withdrawApi);
            mpcClient.setWeb3Api(web3Api);
            mpcClient.setAutoSweepApi(autoSweepApi);
            mpcClient.setNotifyApi(notifyApi);
            mpcClient.setTronBuyResourceApi(tronBuyResourceApi);
            return mpcClient;
        }
    }
}
