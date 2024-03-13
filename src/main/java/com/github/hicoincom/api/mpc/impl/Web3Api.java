package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.CustodyMpcConfig;
import com.github.hicoincom.api.MpcApi;
import com.github.hicoincom.api.bean.Result;
import com.github.hicoincom.api.bean.mpc.*;
import com.github.hicoincom.api.mpc.IWeb3Api;
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
 * @author Chainup Custody
 */
public class Web3Api extends MpcApi implements IWeb3Api {

    public Web3Api(IDataCrypto dataCrypto, CustodyMpcConfig cfg) {
        super(dataCrypto, cfg);
    }

    @Override
    public MpcCreateWeb3Result createWeb3Trans(MpcWeb3TransArgs web3TransArgs, boolean needTransactionSign) {
        if (ObjectUtils.isEmpty(web3TransArgs)) {
            throw new ArgsNullException("mpc create web3 transaction args empty");
        }

        if (needTransactionSign && StringUtils.isBlank(this.cfg.getSignPrivateKey())) {
            logger.error("mpc create web3 transaction, requires the 'sign' parameter, but the configured 'signPrivateKey' data is empty");
            throw new ConfigException("configure 'signPrivateKey' as empty");
        }

        if (needTransactionSign) {
            Map<String, String> signParamsMap = new HashMap<>(6, 1);
            signParamsMap.put("request_id", web3TransArgs.getRequestId());
            signParamsMap.put("sub_wallet_id", web3TransArgs.getSubWalletId().toString());
            signParamsMap.put("main_chain_symbol", web3TransArgs.getMainChainSymbol());
            signParamsMap.put("interactive_contract", web3TransArgs.getInteractiveContract());
            signParamsMap.put("amount", web3TransArgs.getAmount());
            signParamsMap.put("input_data", web3TransArgs.getInputData());

            String signData = SignUtil.paramsSort(signParamsMap);
            if (StringUtils.isBlank(signData)) {
                throw new CryptoException("mpc create web3 transaction, parameter signing failed");
            }
            this.info("mpc create web3 transaction, sign params string:{}, md5:{}", signData, MD5Util.getMD5(signData));

            String sign = SignUtil.sign(signData, this.cfg.getSignPrivateKey());
            if (StringUtils.isBlank(sign)) {
                throw new CryptoException("mpc create web3 transaction, sign parameter error");
            }
            // set sign params
            web3TransArgs.setSign(sign);
        }

        return this.invoke(MpcApiUri.CREATE_WEB3_TRANSACTION, web3TransArgs, MpcCreateWeb3Result.class);
    }

    @Override
    public boolean accelerationWeb3Trans(MpcWeb3AccelerationArgs accelerationArgs) {
        if (ObjectUtils.isEmpty(accelerationArgs)) {
            throw new ArgsNullException("acceleration web3 transaction args empty");
        }

        Result result = this.invoke(MpcApiUri.WEB3_TRANS_ACCELERATION, accelerationArgs, Result.class);
        if (result.getCode().equalsIgnoreCase("0")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    @Override
    public MpcWeb3RecordResult getWeb3Records(List<String> requestIds) {
        if (ObjectUtils.isEmpty(requestIds) || requestIds.isEmpty()) {
            throw new ArgsNullException("get web3 records, the request parameter 'ids' empty");
        }

        GetMpcTransactionRecordArgs args = GetMpcTransactionRecordArgs.GetMpcTransactionRecordArgsBuilder
                .aGetMpcTransactionRecordArgs()
                .ids(StringUtils.join(requestIds, ","))
                .build();
        return this.invoke(MpcApiUri.WEB3_TRANS_RECORDS, args, MpcWeb3RecordResult.class);
    }

    @Override
    public MpcWeb3RecordResult syncWeb3Records(Integer maxId) {
        MpcSyncTransactionRecordArgs args = MpcSyncTransactionRecordArgs.MpcSyncTransactionRecordArgsBuilder
                .aMpcSyncTransactionRecordArgs()
                .maxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId)
                .build();
        return this.invoke(MpcApiUri.SYNC_WEB3_RECORDS, args, MpcWeb3RecordResult.class);
    }
}
