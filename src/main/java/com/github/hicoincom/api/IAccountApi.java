package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.UserAccountResult;
import com.github.hicoincom.exception.CryptoException;
import com.github.hicoincom.api.bean.AccountResult;
import com.github.hicoincom.api.bean.UserAddressResult;

/**
 *  账户操作相关api
 */
public interface IAccountApi {

    UserAccountResult GetUserAccount(Integer uid, String symbol) ;

    UserAddressResult GetUserAddress(Integer uid, String symbol) ;

    AccountResult GetCompanyAccount(String symbol) ;

}
