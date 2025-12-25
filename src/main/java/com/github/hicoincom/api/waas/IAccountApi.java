package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.UserAccountResult;
import com.github.hicoincom.api.bean.waas.AccountResult;
import com.github.hicoincom.api.bean.waas.UserAddressListResult;
import com.github.hicoincom.api.bean.waas.UserAddressResult;

/**
 * Account operation related API interface
 * 
 * This interface provides methods for managing user accounts,
 * querying balances, and retrieving deposit addresses.
 * 
 * @author ChainUp Custody
 */
public interface IAccountApi {

    /**
     * Get user account balance for a specific cryptocurrency
     * 
     * @param uid user ID
     * @param symbol cryptocurrency symbol (e.g., BTC, ETH)
     * @return UserAccountResult containing account balance information
     */
    UserAccountResult getUserAccount(Integer uid, String symbol) ;

    /**
     * Get user deposit address for a specific cryptocurrency
     * 
     * @param uid user ID
     * @param symbol cryptocurrency symbol (e.g., BTC, ETH)
     * @return UserAddressResult containing deposit address information
     */
    UserAddressResult getUserAddress(Integer uid, String symbol) ;

    /**
     * Get company (merchant) account balance for a specific cryptocurrency
     * 
     * @param symbol cryptocurrency symbol (e.g., BTC, ETH)
     * @return AccountResult containing company account information
     */
    AccountResult getCompanyAccount(String symbol) ;

    /**
     * Get user address information by address
     * 
     * @param address the blockchain address to query
     * @return UserAddressResult containing address details
     */
    UserAddressResult getUserAddressInfo(String address) ;

    UserAddressListResult syncUserAddressList(Integer maxId) ;

}
