package com.github.hicoincom.api.waas.impl;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.waas.*;
import com.github.hicoincom.api.waas.IAccountApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.ApiUri;

/**
 * @author ChainUp Custody
 * API related to account operation
 */
public class AccountApi extends WaasApi implements IAccountApi {

    public AccountApi(WaasConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public UserAccountResult getUserAccount(Integer uid, String symbol) {
        UserAccountArgs args = new UserAccountArgs();
        args.setSymbol(symbol);
        args.setUid(uid);
        return this.invoke(ApiUri.USER_SYMBOL_ACCOUNT, args, UserAccountResult.class);
    }

    @Override
    public UserAddressResult getUserAddress(Integer uid, String symbol) {
        UserAddressArgs args = new UserAddressArgs();
        args.setSymbol(symbol);
        args.setUid(uid);
        return this.invoke(ApiUri.USER_DEPOSIT_ADDRESS, args, UserAddressResult.class);
    }

    @Override
    public AccountResult getCompanyAccount(String symbol) {
        CompanyAccountArgs args = new CompanyAccountArgs();
        args.setSymbol(symbol);

        return this.invoke(ApiUri.COMPANY_SYMBOL_ACCOUNT, args, AccountResult.class);
    }

    @Override
    public UserAddressResult getUserAddressInfo(String address) {
        UserAddressArgs args = new UserAddressArgs();
        args.setAddress(address);
        return this.invoke(ApiUri.USER_DEPOSIT_ADDRESS_INFO, args, UserAddressResult.class);
    }
}
