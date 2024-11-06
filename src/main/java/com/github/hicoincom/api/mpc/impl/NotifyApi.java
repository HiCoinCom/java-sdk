package com.github.hicoincom.api.mpc.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.mpc.NotifyArgs;
import com.github.hicoincom.api.mpc.INotifyApi;
import com.github.hicoincom.crypto.IDataCrypto;
import org.apache.commons.lang3.StringUtils;

public class NotifyApi extends WaasApi implements INotifyApi {

    public NotifyApi(WaasConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public NotifyArgs notifyRequest(String cipher) {
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

        NotifyArgs notify = JSONObject.parseObject(raw, NotifyArgs.class);
        if (notify == null) {
            logger.error("NotifyRequest json decode return null");
            return null;
        }
        return notify;
    }

}
