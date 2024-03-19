package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.AsyncNotifyArgs;
import com.github.hicoincom.api.bean.waas.WithdrawArgs;

/**
 * @author ChainUp Custody
 * Asynchronous callback notification related api (interface provided to waas)
 */
public interface IAsyncNotifyApi {

    /**
     * Decrypt deposit and withdrawal notification parameters
     *
     * @param cipher
     * @return
     */
    AsyncNotifyArgs notifyRequest(String cipher);

    /**
     * Decryption withdrawal secondary verification request parameters
     *
     * @param cipher
     * @return
     */
    WithdrawArgs verifyRequest(String cipher);

    /**
     * Encrypt the secondary verification withdrawal response data
     *
     * @param withdraw
     * @return
     */
    String verifyResponse(WithdrawArgs withdraw);
}
