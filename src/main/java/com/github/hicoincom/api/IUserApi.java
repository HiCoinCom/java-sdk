package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.UserInfoResult;
import com.github.hicoincom.exception.CryptoException;

/**
 *  用户api
 */
public interface IUserApi {
    UserInfoResult RegisterMobileUser(String country, String mobile) throws CryptoException;

    UserInfoResult RegisterEmailUser(String email)throws CryptoException;

    UserInfoResult GetMobileUser(String country, String mobile) throws CryptoException;

    UserInfoResult GetEmailUser(String email)throws CryptoException;
}
