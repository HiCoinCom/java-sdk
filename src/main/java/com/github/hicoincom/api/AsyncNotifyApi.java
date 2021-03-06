package com.github.hicoincom.api;

import com.alibaba.fastjson.JSONObject;
import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.bean.AsyncNotifyArgs;
import com.github.hicoincom.api.bean.Withdraw;
import com.github.hicoincom.api.bean.WithdrawArgs;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.exception.CryptoException;
import org.apache.commons.lang3.StringUtils;

/**
 *  异步回调通知相关api(提供给waas的接口)
 */
public class AsyncNotifyApi extends  WaasApi implements IAsyncNotifyApi{
    public AsyncNotifyApi(WaasConfig cfg, IDataCrypto crypto){
        super(cfg, crypto);
    }

    @Override
    public AsyncNotifyArgs NotifyRequest(String cipher) {
        if(StringUtils.isBlank(cipher)){
            logger.info("NotifyRequest cipher can not be empty");
            return null;
        }

        String raw = this.dataCrypto.decode(cipher);
        logger.info("NotifyRequest decode data:{}", raw);
        if(StringUtils.isBlank(raw)){
            logger.error("NotifyRequest decode cipher return null");
            return null;
        }

        AsyncNotifyArgs notify = JSONObject.parseObject(raw, AsyncNotifyArgs.class);
        if(notify == null){
            logger.error("NotifyRequest json decode return null");
            return null;
        }
        return  notify;
    }

    /**
     *  解密提现二次验证请求参数
     * @param cipher
     * @return
     */
    @Override
    public WithdrawArgs VerifyRequest(String cipher) {
        if(StringUtils.isBlank(cipher)){
            this.info("VerifyRequest cipher can not be empty");
            return null;
        }

        String raw = this.dataCrypto.decode(cipher);
        this.info("VerifyRequest decode data:{}", raw);
        if(StringUtils.isBlank(raw)){
            logger.error("VerifyRequest decode cipher return null");
            return null;
        }

        WithdrawArgs withdraw = JSONObject.parseObject(raw, WithdrawArgs.class);
        if(withdraw == null){
            logger.error("VerifyRequest json decode withdraw return null");
            return null;
        }
        return  withdraw;
    }

    /**
     *  加密二次验证提现响应数据
     * @param withdraw
     * @return
     */
    @Override
    public String VerifyResponse(WithdrawArgs withdraw){
        if(withdraw == null){
            logger.error("VerifyResponse withdraw can not be empty");
            return null;
        }

        String raw = this.dataCrypto.encode(JSONObject.toJSONString(withdraw));
        if(StringUtils.isBlank(raw)){
            logger.error("VerifyResponse encode cipher return null");
            return null;
        }
        return raw;
    }
}
