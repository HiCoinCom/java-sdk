package com.chainup.waas.api;

import com.chainup.waas.WaasConfig;
import com.chainup.waas.api.bean.ApiUri;
import com.chainup.waas.api.bean.RegisterArgs;
import com.chainup.waas.api.bean.UserInfoArgs;
import com.chainup.waas.api.bean.UserInfoResult;
import com.chainup.waas.crypto.IDataCrypto;
import com.chainup.waas.exception.CryptoException;

/**
 *  用户api
 */
public class UserApi extends WaasApi implements IUserApi{
    public UserApi(WaasConfig cfg, IDataCrypto crypto){
        super(cfg, crypto);
    }

    @Override
    public UserInfoResult RegisterMobileUser(String country, String mobile)throws CryptoException {
        RegisterArgs args = new RegisterArgs();
        args.setCountry(country);
        args.setMobile(mobile);
        return this.invoke(ApiUri.CREATE_USER_MOBILE, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult RegisterEmailUser(String email)throws CryptoException{
        RegisterArgs args = new RegisterArgs();
        args.setEmail(email);
        return this.invoke(ApiUri.CREATE_USER_EMAIL, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult GetMobileUser(String country, String mobile) throws CryptoException{
        UserInfoArgs args = new UserInfoArgs();
        args.setCountry(country);
        args.setMobile(mobile);
        return this.invoke(ApiUri.GET_USER_INFO, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult GetEmailUser(String email)throws CryptoException{
        UserInfoArgs args = new UserInfoArgs();
        args.setEmail(email);
        return this.invoke(ApiUri.GET_USER_INFO, args, UserInfoResult.class);
    }
}
