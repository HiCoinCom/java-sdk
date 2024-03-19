package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.UserAccountResult;
import com.github.hicoincom.api.bean.waas.AccountResult;
import com.github.hicoincom.api.bean.waas.UserAddressResult;

/**
 * @author ChainUp Custody
 *  Account operation related api
 */
public interface IAccountApi {

    UserAccountResult getUserAccount(Integer uid, String symbol) ;

    UserAddressResult getUserAddress(Integer uid, String symbol) ;

    AccountResult getCompanyAccount(String symbol) ;

}
