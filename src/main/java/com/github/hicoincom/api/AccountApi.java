package com.github.hicoincom.api;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.bean.*;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.exception.CryptoException;

/**
 *  账户操作相关api
 */
public class AccountApi extends  WaasApi implements IAccountApi{
    public AccountApi(WaasConfig cfg, IDataCrypto crypto){
        super(cfg, crypto);
    }

    @Override
    public UserAccountResult GetUserAccount(Integer uid, String symbol) throws CryptoException {
        UserAccountArgs args = new UserAccountArgs();
        args.setSymbol(symbol);
        args.setUid(uid);
        return this.invoke(ApiUri.USER_SYMBOL_ACCOUNT, args, UserAccountResult.class);
    }

    @Override
    public UserAddressResult GetUserAddress(Integer uid, String symbol) throws CryptoException{
        UserAddressArgs args = new UserAddressArgs();
        args.setSymbol(symbol);
        args.setUid(uid);
        return this.invoke(ApiUri.USER_DEPOSIT_ADDRESS, args, UserAddressResult.class);
    }

    @Override
    public AccountResult GetCompanyAccount(String symbol) throws CryptoException{
        CompanyAccountArgs args = new CompanyAccountArgs();
        args.setSymbol(symbol);

        return this.invoke(ApiUri.COMPANY_SYMBOL_ACCOUNT, args, AccountResult.class);
    }
}
