package com.chainup.waas.api;

import com.chainup.waas.WaasConfig;
import com.chainup.waas.api.bean.*;
import com.chainup.waas.crypto.IDataCrypto;
import com.chainup.waas.exception.CryptoException;

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
