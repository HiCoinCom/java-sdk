package com.github.hicoincom;

import com.github.hicoincom.api.waas.*;

/**
 * @author ChainUp Custody
 */
public class WaasClient {

    private IAccountApi accountApi;

    private IAsyncNotifyApi asyncNotifyApi;

    private IBillingApi billingApi;

    private ICoinApi coinApi;

    private IUserApi userApi;

    private ITransferApi transferApi;

    public IAccountApi getAccountApi() {
        return accountApi;
    }

    public void setAccountApi(IAccountApi accountApi) {
        this.accountApi = accountApi;
    }

    public IAsyncNotifyApi getAsyncNotifyApi() {
        return asyncNotifyApi;
    }

    public void setAsyncNotifyApi(IAsyncNotifyApi asyncNotifyApi) {
        this.asyncNotifyApi = asyncNotifyApi;
    }

    public IBillingApi getBillingApi() {
        return billingApi;
    }

    public void setBillingApi(IBillingApi billingApi) {
        this.billingApi = billingApi;
    }

    public ICoinApi getCoinApi() {
        return coinApi;
    }

    public void setCoinApi(ICoinApi coinApi) {
        this.coinApi = coinApi;
    }

    public IUserApi getUserApi() {
        return userApi;
    }

    public void setUserApi(IUserApi userApi) {
        this.userApi = userApi;
    }

    public ITransferApi getTransferApi() {
        return transferApi;
    }

    public void setTransferApi(ITransferApi transferApi) {
        this.transferApi = transferApi;
    }

    public static final class WaasClientBuilder {
        private IAccountApi accountApi;
        private IAsyncNotifyApi asyncNotifyApi;
        private IBillingApi billingApi;
        private ICoinApi coinApi;
        private IUserApi userApi;
        private ITransferApi transferApi;

        private WaasClientBuilder() {
        }

        public static WaasClientBuilder builder() {
            return new WaasClientBuilder();
        }

        public WaasClientBuilder accountApi(IAccountApi accountApi) {
            this.accountApi = accountApi;
            return this;
        }

        public WaasClientBuilder asyncNotifyApi(IAsyncNotifyApi asyncNotifyApi) {
            this.asyncNotifyApi = asyncNotifyApi;
            return this;
        }

        public WaasClientBuilder billingApi(IBillingApi billingApi) {
            this.billingApi = billingApi;
            return this;
        }

        public WaasClientBuilder coinApi(ICoinApi coinApi) {
            this.coinApi = coinApi;
            return this;
        }

        public WaasClientBuilder userApi(IUserApi userApi) {
            this.userApi = userApi;
            return this;
        }

        public WaasClientBuilder transferApi(ITransferApi transferApi) {
            this.transferApi = transferApi;
            return this;
        }

        public WaasClient build() {
            WaasClient waasClient = new WaasClient();
            waasClient.setAccountApi(accountApi);
            waasClient.setAsyncNotifyApi(asyncNotifyApi);
            waasClient.setBillingApi(billingApi);
            waasClient.setCoinApi(coinApi);
            waasClient.setUserApi(userApi);
            waasClient.setTransferApi(transferApi);
            return waasClient;
        }
    }
}
