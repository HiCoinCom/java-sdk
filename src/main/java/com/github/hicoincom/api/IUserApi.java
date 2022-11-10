package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.UserInfoResult;
import com.github.hicoincom.exception.CryptoException;

/**
 *  user related api
 */
public interface IUserApi {
    UserInfoResult RegisterMobileUser(String country, String mobile) ;

    UserInfoResult RegisterEmailUser(String email);

    UserInfoResult GetMobileUser(String country, String mobile) ;

    UserInfoResult GetEmailUser(String email);
}
