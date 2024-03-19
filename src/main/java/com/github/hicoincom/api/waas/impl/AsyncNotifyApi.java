package com.github.hicoincom.api.waas.impl;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.waas.AsyncNotifyArgs;
import com.github.hicoincom.api.bean.waas.WithdrawArgs;
import com.github.hicoincom.api.waas.IAsyncNotifyApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ChainUp Custody
 * Asynchronous callback notification related api (interface provided to waas)
 */
public class AsyncNotifyApi extends WaasApi implements IAsyncNotifyApi {

    public AsyncNotifyApi(WaasConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public AsyncNotifyArgs notifyRequest(String cipher) {
        if (StringUtils.isBlank(cipher)) {
            logger.info("NotifyRequest cipher can not be empty");
            return null;
        }

        String raw = this.dataCrypto.decode(cipher);
        logger.info("NotifyRequest decode data:{}", raw);
        if (StringUtils.isBlank(raw)) {
            logger.error("NotifyRequest decode cipher return null");
            return null;
        }

        AsyncNotifyArgs notify = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
                .fromJson(raw, AsyncNotifyArgs.class);

        if (notify == null) {
            logger.error("NotifyRequest json decode return null");
            return null;
        }
        return notify;
    }

    @Override
    public WithdrawArgs verifyRequest(String cipher) {
        if (StringUtils.isBlank(cipher)) {
            this.info("VerifyRequest cipher can not be empty");
            return null;
        }

        String raw = this.dataCrypto.decode(cipher);
        this.info("VerifyRequest decode data:{}", raw);
        if (StringUtils.isBlank(raw)) {
            logger.error("VerifyRequest decode cipher return null");
            return null;
        }

        WithdrawArgs withdraw = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
                .fromJson(raw, WithdrawArgs.class);
        if (withdraw == null) {
            logger.error("VerifyRequest json decode withdraw return null");
            return null;
        }
        return withdraw;
    }

    @Override
    public String verifyResponse(WithdrawArgs withdraw) {
        if (withdraw == null) {
            logger.error("VerifyResponse withdraw can not be empty");
            return null;
        }

        String withdrawJson = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
                .toJson(withdraw);

        String raw = this.dataCrypto.encode(withdrawJson);
        if (StringUtils.isBlank(raw)) {
            logger.error("VerifyResponse encode cipher return null");
            return null;
        }
        return raw;
    }
}
