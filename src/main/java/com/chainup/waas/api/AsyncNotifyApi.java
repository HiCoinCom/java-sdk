package com.chainup.waas.api;

import com.alibaba.fastjson.JSONObject;
import com.chainup.waas.WaasConfig;
import com.chainup.waas.api.bean.AsyncNotifyArgs;
import com.chainup.waas.api.bean.Withdraw;
import com.chainup.waas.crypto.IDataCrypto;
import com.chainup.waas.exception.CryptoException;
import org.apache.commons.lang3.StringUtils;

/**
 *  异步回调通知相关api(提供给waas的接口)
 */
public class AsyncNotifyApi extends  WaasApi implements IAsyncNotifyApi{
    public AsyncNotifyApi(WaasConfig cfg, IDataCrypto crypto){
        super(cfg, crypto);
    }

    @Override
    public AsyncNotifyArgs NotifyRequest(String cipher)throws CryptoException{
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
    public Withdraw VerifyRequest(String cipher)throws CryptoException {
        if(StringUtils.isBlank(cipher)){
            logger.info("VerifyRequest cipher can not be empty");
            return null;
        }

        String raw = this.dataCrypto.decode(cipher);
        logger.info("VerifyRequest decode data:{}", raw);
        if(StringUtils.isBlank(raw)){
            logger.error("VerifyRequest decode cipher return null");
            return null;
        }

        Withdraw withdraw = JSONObject.parseObject(raw, Withdraw.class);
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
    public String VerifyResponse(Withdraw withdraw)throws CryptoException{
        if(withdraw == null){
            logger.info("VerifyResponse withdraw can not be empty");
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
