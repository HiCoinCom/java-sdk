package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.CustodyMpcConfig;
import com.github.hicoincom.api.MpcApi;
import com.github.hicoincom.api.bean.mpc.*;
import com.github.hicoincom.api.mpc.IWithdrawApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import com.github.hicoincom.exception.ConfigException;
import com.github.hicoincom.exception.CryptoException;
import com.github.hicoincom.util.MD5Util;
import com.github.hicoincom.util.SignUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChainUp Custody
 */
public class WithdrawApi extends MpcApi implements IWithdrawApi {

    public WithdrawApi(IDataCrypto dataCrypto, CustodyMpcConfig cfg) {
        super(dataCrypto, cfg);
    }

    @Override
    public MpcWithdrawResult withdraw(MpcWithdrawArgs withdrawArgs, boolean needTransactionSign) {
        if (ObjectUtils.isEmpty(withdrawArgs)) {
            throw new ArgsNullException("mpc withdraw args empty");
        }
        if (needTransactionSign && StringUtils.isBlank(this.cfg.getSignPrivateKey())) {
            logger.error("mpc withdrawal, requires the 'sign' parameter, but the configured 'signPrivateKey' data is empty");
            throw new ConfigException("configure 'signPrivateKey' as empty");
        }

        if (needTransactionSign) {
            Map<String, String> signParamsMap = new HashMap<>(6, 1);
            signParamsMap.put("request_id", withdrawArgs.getRequestId());
            signParamsMap.put("sub_wallet_id", withdrawArgs.getSubWalletId().toString());
            signParamsMap.put("symbol", withdrawArgs.getSymbol());
            signParamsMap.put("address_to", withdrawArgs.getAddressTo());
            signParamsMap.put("amount", withdrawArgs.getAmount());
            signParamsMap.put("memo", withdrawArgs.getMemo());

            String signData = SignUtil.paramsSort(signParamsMap);
            if (StringUtils.isBlank(signData)) {
                throw new CryptoException("mpc withdrawal, parameter signing failed");
            }
            this.info("mpc withdrawal, sign params string:{}, md5:{}", signData, MD5Util.getMD5(signData));

            String sign = SignUtil.sign(signData, this.cfg.getSignPrivateKey());
            if (StringUtils.isBlank(sign)) {
                throw new CryptoException("mpc withdrawal, sign parameter error");
            }
            // set sign params
            withdrawArgs.setSign(sign);
        }

        return this.invoke(MpcApiUri.BILLING_WITHDRAW, withdrawArgs, MpcWithdrawResult.class);
    }

    @Override
    public MpcWithdrawRecordResult getWithdrawRecords(List<String> requestIds) {
        if (ObjectUtils.isEmpty(requestIds) || requestIds.isEmpty()) {
            throw new ArgsNullException("the request parameter 'ids' empty");
        }

        GetMpcTransactionRecordArgs args = GetMpcTransactionRecordArgs.GetMpcTransactionRecordArgsBuilder
                .aGetMpcTransactionRecordArgs()
                .ids(StringUtils.join(requestIds, ","))
                .build();
        return this.invoke(MpcApiUri.WITHDRAW_RECORDS, args, MpcWithdrawRecordResult.class);
    }


    @Override
    public MpcWithdrawRecordResult syncWithdrawRecords(Integer maxId) {
        MpcSyncTransactionRecordArgs args = MpcSyncTransactionRecordArgs.MpcSyncTransactionRecordArgsBuilder
                .aMpcSyncTransactionRecordArgs()
                .maxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId)
                .build();
        return this.invoke(MpcApiUri.SYNC_WITHDRAW_RECORDS, args, MpcWithdrawRecordResult.class);
    }


}
