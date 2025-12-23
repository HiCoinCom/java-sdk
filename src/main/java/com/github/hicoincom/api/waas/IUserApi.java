package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.UserInfoResult;

/**
 * User management related API interface
 * 
 * This interface provides methods for registering and querying
 * users in the WaaS system.
 * 
 * @author ChainUp Custody
 */
public interface IUserApi {

    /**
     * Register a new user with mobile number
     * 
     * @param country country code (e.g., "86" for China)
     * @param mobile mobile phone number
     * @return UserInfoResult containing registered user information
     */
    UserInfoResult registerMobileUser(String country, String mobile);

    /**
     * Register a new user with email address
     * 
     * @param email user's email address
     * @return UserInfoResult containing registered user information
     */
    UserInfoResult registerEmailUser(String email);

    /**
     * Get user information by mobile number
     * 
     * @param country country code (e.g., "86" for China)
     * @param mobile mobile phone number
     * @return UserInfoResult containing user information
     */
    UserInfoResult getMobileUser(String country, String mobile);

    /**
     * Get user information by email address
     * 
     * @param email user's email address
     * @return UserInfoResult containing user information
     */
    UserInfoResult getEmailUser(String email);
}
