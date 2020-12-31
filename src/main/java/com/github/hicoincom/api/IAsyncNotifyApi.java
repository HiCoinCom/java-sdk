package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.AsyncNotifyArgs;
import com.github.hicoincom.api.bean.Withdraw;
import com.github.hicoincom.exception.CryptoException;

/**
 *  异步回调通知相关api(提供给waas的接口)
 */
public interface IAsyncNotifyApi {
    /**
     *  解密充值提现通知参数
     * @param cipher
     * @return
     */
    AsyncNotifyArgs NotifyRequest(String cipher)throws CryptoException;

    /**
     *  解密提现二次验证请求参数
     * @param cipher
     * @return
     */
    Withdraw VerifyRequest(String cipher)throws CryptoException;

    /**
     *  加密二次验证提现响应数据
     * @param withdraw
     * @return
     */
    String VerifyResponse(Withdraw withdraw)throws CryptoException;
}
