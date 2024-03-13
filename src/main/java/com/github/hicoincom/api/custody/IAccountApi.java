package com.github.hicoincom.api.custody;

import com.github.hicoincom.api.bean.custody.UserAccountResult;
import com.github.hicoincom.api.bean.custody.AccountResult;
import com.github.hicoincom.api.bean.custody.UserAddressResult;

/**
 *  Account operation related api
 */
public interface IAccountApi {

    UserAccountResult GetUserAccount(Integer uid, String symbol) ;

    UserAddressResult GetUserAddress(Integer uid, String symbol) ;

    AccountResult GetCompanyAccount(String symbol) ;

}
