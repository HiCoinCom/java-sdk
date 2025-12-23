package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.AsyncNotifyArgs;
import com.github.hicoincom.api.bean.waas.WithdrawArgs;

/**
 * Asynchronous callback notification related API interface
 * 
 * This interface provides methods for handling async notifications
 * from the WaaS platform, including deposit/withdrawal notifications
 * and secondary verification for withdrawals.
 * 
 * @author ChainUp Custody
 */
public interface IAsyncNotifyApi {

    /**
     * Decrypt deposit and withdrawal notification parameters
     * 
     * Used to decrypt encrypted notification data received from WaaS callbacks.
     * 
     * @param cipher encrypted notification data
     * @return AsyncNotifyArgs decrypted notification arguments
     */
    AsyncNotifyArgs notifyRequest(String cipher);

    /**
     * Decrypt withdrawal secondary verification request parameters
     * 
     * Used to decrypt verification request data for withdrawal operations
     * that require additional confirmation.
     * 
     * @param cipher encrypted verification request data
     * @return WithdrawArgs decrypted withdrawal arguments
     */
    WithdrawArgs verifyRequest(String cipher);

    /**
     * Encrypt the secondary verification withdrawal response data
     * 
     * Used to encrypt the response data when confirming or rejecting
     * a withdrawal that requires secondary verification.
     * 
     * @param withdraw withdrawal arguments to encrypt
     * @return String encrypted response data
     */
    String verifyResponse(WithdrawArgs withdraw);
}
