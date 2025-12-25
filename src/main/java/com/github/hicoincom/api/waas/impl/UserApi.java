package com.github.hicoincom.api.waas.impl;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.waas.*;
import com.github.hicoincom.api.waas.IUserApi;
import com.github.hicoincom.enums.ApiUri;
import com.github.hicoincom.crypto.IDataCrypto;

/**
 * @author ChainUp Custody
 * user related api
 */
public class UserApi extends WaasApi implements IUserApi {

    public UserApi(WaasConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public UserInfoResult registerMobileUser(String country, String mobile) {
        RegisterArgs args = new RegisterArgs();
        args.setCountry(country);
        args.setMobile(mobile);
        return this.invoke(ApiUri.CREATE_USER_MOBILE, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult registerEmailUser(String email) {
        RegisterArgs args = new RegisterArgs();
        args.setEmail(email);
        return this.invoke(ApiUri.CREATE_USER_EMAIL, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult getMobileUser(String country, String mobile) {
        UserInfoArgs args = new UserInfoArgs();
        args.setCountry(country);
        args.setMobile(mobile);
        return this.invoke(ApiUri.GET_USER_INFO, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult getEmailUser(String email) {
        UserInfoArgs args = new UserInfoArgs();
        args.setEmail(email);
        return this.invoke(ApiUri.GET_USER_INFO, args, UserInfoResult.class);
    }

    @Override
    public UserInfoListResult syncUserList(Integer maxId) {
        SyncUserListArgs args = new SyncUserListArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.GET_USER_LIST, args, UserInfoListResult.class);
    }
}
