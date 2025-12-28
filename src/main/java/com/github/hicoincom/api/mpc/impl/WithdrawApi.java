package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.MpcConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.mpc.*;
import com.github.hicoincom.api.mpc.IWithdrawApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import com.github.hicoincom.exception.ConfigException;
import com.github.hicoincom.exception.CryptoException;
import com.github.hicoincom.util.Md5Util;
import com.github.hicoincom.util.MpcSignUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author ChainUp Custody
 */
public class WithdrawApi extends WaasApi implements IWithdrawApi {

    public WithdrawApi(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public WithdrawResult withdraw(WithdrawArgs withdrawArgs, boolean needTransactionSign) {
        if (ObjectUtils.isEmpty(withdrawArgs)) {
            throw new ArgsNullException("mpc withdraw args empty");
        }
        if (needTransactionSign && !this.dataCrypto.hasSignKey()) {
            logger.error("mpc withdrawal, requires the 'sign' parameter, but the configured 'signPrivateKey' data is empty");
            throw new ConfigException("configure 'signPrivateKey' as empty");
        }

        if (needTransactionSign) {
            Map<String, String> signParamsMap = MpcSignUtil.getWithdrawSignParams(withdrawArgs);
            String signData = MpcSignUtil.paramsSort(signParamsMap);
            if (StringUtils.isBlank(signData)) {
                throw new CryptoException("mpc withdrawal, parameter signing failed");
            }
            this.info("mpc withdrawal, sign params string:{}, md5:{}", signData, Md5Util.getMd5(signData));

            String sign = this.dataCrypto.sign(Md5Util.getMd5(signData));
            if (StringUtils.isBlank(sign)) {
                throw new CryptoException("mpc withdrawal, sign parameter error");
            }
            // set sign params
            withdrawArgs.setSign(sign);
        }

        return this.invoke(MpcApiUri.BILLING_WITHDRAW, withdrawArgs, WithdrawResult.class);
    }

    @Override
    public WithdrawResult withdraw(WithdrawArgs withdrawArgs) {
        if (ObjectUtils.isEmpty(withdrawArgs)) {
            throw new ArgsNullException("mpc withdraw args empty");
        }

        return this.invoke(MpcApiUri.BILLING_WITHDRAW, withdrawArgs, WithdrawResult.class);
    }

    @Override
    public WithdrawRecordResult getWithdrawRecords(List<String> requestIds) {
        if (ObjectUtils.isEmpty(requestIds) || requestIds.isEmpty()) {
            throw new ArgsNullException("the request parameter 'ids' empty");
        }

        GetTransactionRecordArgs args = new GetTransactionRecordArgs();
        args.setIds(StringUtils.join(requestIds, ","));

        return this.invoke(MpcApiUri.WITHDRAW_RECORDS, args, WithdrawRecordResult.class);
    }

    @Override
    public WithdrawRecordResult syncWithdrawRecords(Integer maxId) {
        SyncTransactionRecordArgs args = new SyncTransactionRecordArgs();
        args.setMaxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId);

        return this.invoke(MpcApiUri.SYNC_WITHDRAW_RECORDS, args, WithdrawRecordResult.class);
    }

}
