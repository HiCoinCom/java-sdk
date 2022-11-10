package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.AsyncNotifyArgs;
import com.github.hicoincom.api.bean.WithdrawArgs;

/**
 *  Asynchronous callback notification related api (interface provided to waas)
 */
public interface IAsyncNotifyApi {
    /**
     *  Decrypt deposit and withdrawal notification parameters
     * @param cipher
     * @return
     */
    AsyncNotifyArgs NotifyRequest(String cipher);

    /**
     *  Decryption withdrawal secondary verification request parameters
     * @param cipher
     * @return
     */
    WithdrawArgs VerifyRequest(String cipher);

    /**
     *  Encrypt the secondary verification withdrawal response data
     * @param withdraw
     * @return
     */
    String VerifyResponse(WithdrawArgs withdraw);
}
