package com.chainup.waas.api;

import com.chainup.waas.api.bean.*;
import com.chainup.waas.exception.CryptoException;

/**
 *  账户操作相关api
 */
public interface IAccountApi {

    UserAccountResult GetUserAccount(Integer uid, String symbol) throws CryptoException;

    UserAddressResult GetUserAddress(Integer uid, String symbol) throws CryptoException;

    AccountResult GetCompanyAccount(String symbol) throws CryptoException;

}
