package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.CustodyMpcConfig;
import com.github.hicoincom.api.MpcApi;
import com.github.hicoincom.api.bean.mpc.GetMpcDepositRecordArgs;
import com.github.hicoincom.api.bean.mpc.MpcDepositRecordResult;
import com.github.hicoincom.api.bean.mpc.MpcSyncDepositRecordArgs;
import com.github.hicoincom.api.mpc.IDepositApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author ChainUp Custody
 */
public class DepositApi extends MpcApi implements IDepositApi {

    public DepositApi(IDataCrypto dataCrypto, CustodyMpcConfig cfg) {
        super(dataCrypto, cfg);
    }

    @Override
    public MpcDepositRecordResult getDepositRecords(List<Integer> ids) {
        if (ObjectUtils.isEmpty(ids) || ids.isEmpty()) {
            throw new ArgsNullException("the request parameter 'ids' empty");
        }

        GetMpcDepositRecordArgs args = GetMpcDepositRecordArgs.GetMpcDepositRecordArgsBuilder.aGetMpcDepositRecordArgs()
                .ids(StringUtils.join(ids, ","))
                .build();

        return this.invoke(MpcApiUri.DEPOSIT_RECORDS, args, MpcDepositRecordResult.class);
    }

    @Override
    public MpcDepositRecordResult syncDepositRecords(Integer maxId) {
        MpcSyncDepositRecordArgs args = MpcSyncDepositRecordArgs.MpcSyncDepositRecordArgsBuilder
                .aMpcSyncDepositRecordArgs()
                .maxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId)
                .build();
        return this.invoke(MpcApiUri.SYNC_WITHDRAW_RECORDS, args, MpcDepositRecordResult.class);
    }
}
