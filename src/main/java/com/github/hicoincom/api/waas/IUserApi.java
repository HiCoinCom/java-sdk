package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.UserInfoResult;

/**
 * @author ChainUp Custody
 * user related api
 */
public interface IUserApi {

    UserInfoResult registerMobileUser(String country, String mobile);

    UserInfoResult registerEmailUser(String email);

    UserInfoResult getMobileUser(String country, String mobile);

    UserInfoResult getEmailUser(String email);
}
