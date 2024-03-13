package com.github.hicoincom.api.custody;

import com.github.hicoincom.api.bean.custody.UserInfoResult;

/**
 * user related api
 */
public interface IUserApi {
    UserInfoResult RegisterMobileUser(String country, String mobile);

    UserInfoResult RegisterEmailUser(String email);

    UserInfoResult GetMobileUser(String country, String mobile);

    UserInfoResult GetEmailUser(String email);
}
