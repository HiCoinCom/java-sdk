package com.github.hicoincom.api;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.bean.ApiUri;
import com.github.hicoincom.api.bean.RegisterArgs;
import com.github.hicoincom.api.bean.UserInfoArgs;
import com.github.hicoincom.api.bean.UserInfoResult;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.exception.CryptoException;

/**
 *  用户api
 */
public class UserApi extends WaasApi implements IUserApi{
    public UserApi(WaasConfig cfg, IDataCrypto crypto){
        super(cfg, crypto);
    }

    @Override
    public UserInfoResult RegisterMobileUser(String country, String mobile) {
        RegisterArgs args = new RegisterArgs();
        args.setCountry(country);
        args.setMobile(mobile);
        return this.invoke(ApiUri.CREATE_USER_MOBILE, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult RegisterEmailUser(String email){
        RegisterArgs args = new RegisterArgs();
        args.setEmail(email);
        return this.invoke(ApiUri.CREATE_USER_EMAIL, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult GetMobileUser(String country, String mobile) {
        UserInfoArgs args = new UserInfoArgs();
        args.setCountry(country);
        args.setMobile(mobile);
        return this.invoke(ApiUri.GET_USER_INFO, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult GetEmailUser(String email){
        UserInfoArgs args = new UserInfoArgs();
        args.setEmail(email);
        return this.invoke(ApiUri.GET_USER_INFO, args, UserInfoResult.class);
    }
}
