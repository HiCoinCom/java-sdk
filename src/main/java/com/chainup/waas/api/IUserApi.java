package com.chainup.waas.api;

import com.chainup.waas.api.bean.UserInfoResult;
import com.chainup.waas.exception.CryptoException;

/**
 *  用户api
 */
public interface IUserApi {
    UserInfoResult RegisterMobileUser(String country, String mobile) throws CryptoException;

    UserInfoResult RegisterEmailUser(String email)throws CryptoException;

    UserInfoResult GetMobileUser(String country, String mobile) throws CryptoException;

    UserInfoResult GetEmailUser(String email)throws CryptoException;
}
