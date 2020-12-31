package com.github.hicoincom;

import com.github.hicoincom.api.*;

public class WaasClient {
    private IAccountApi accountApi;
    private IAsyncNotifyApi asyncNotifyApi;
    private IBillingApi billingApi;
    private ICoinApi coinApi;
    private IUserApi userApi;

    public WaasClient(){}

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
}
